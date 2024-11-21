/*****************************************************************************
 * Author: Richard Elliott Jr                                                *
 * Date: 04/25/23                                                            *
 * CMSC 440 Spring 2023                                                      * 
 * This code is for sending ping packets and receiveing ping responses form  *
 * the ping server.                                                          *
 * PING Assignment                                                           *
 * ***************************************************************************
 */
import java.net.*;
import java.util.*;
import java.io.*;

public class PINGClient {
    public static void main(String[] args) throws Exception {
        if (args.length != 5) {
            System.out.println("Usage: java PINGClient <server ip> <server port> <client id> <num packets> <wait>");
            return;
        }

        String serverIP = args[0];
        int serverPort = Integer.parseInt(args[1]);
        int clientID = Integer.parseInt(args[2]);
        int numPackets = Integer.parseInt(args[3]);
        int waitTime = Integer.parseInt(args[4]);

        InetAddress serverAddr = InetAddress.getByName(serverIP);

        System.out.println("PINGClient started with server IP: " + serverIP + ", port: " + serverPort +
                ", client ID: " + clientID + ", packets: " + numPackets + ", wait: " + waitTime);

        int packetsSent = 0;
        int packetsReceived = 0;
        double minRTT = Double.MAX_VALUE;
        double maxRTT = 0;
        double avgRTT = 0;

        Random rand = new Random();

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            clientSocket.setSoTimeout(waitTime * 1000);

            for (int i = 0; i < numPackets; i++) {
                String host = "client.example.com";
                String className = "VCU-CMSC440-SPRING-2023";
                String userName = "Doe, John";
                String rest = generateRandomString(10);

                // Construct request packet
                byte[] requestBuffer = constructPingPacket(clientID, i+1, host, className, userName, rest);
                DatagramPacket requestPacket = new DatagramPacket(requestBuffer, requestBuffer.length, serverAddr, serverPort);

                // Send request packet
                long sendTime = System.currentTimeMillis();
                clientSocket.send(requestPacket);
                packetsSent++;

                // Receive response packet
                DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
                try {
                    clientSocket.receive(responsePacket);
                    long receiveTime = System.currentTimeMillis();
                    packetsReceived++;

                    // Calculate RTT
                    double rtt = (double) (receiveTime - sendTime) / 1000;

                    // Update min and max RTT
                    if (rtt < minRTT) {
                        minRTT = rtt;
                    }
                    if (rtt > maxRTT) {
                        maxRTT = rtt;
                    }

                    // Update average RTT
                    avgRTT = ((avgRTT * (packetsReceived - 1)) + rtt) / packetsReceived;

                    // Parse response packet
                    PingPacket response = parsePingPacket(responsePacket.getData());
                    System.out.println("---------- Received Ping Response Packet Header ----------");
                    System.out.println(response.getHeader());
                    System.out.println("--------- Received Ping Response Packet Payload ------------");
                    System.out.println(response.getPayload());
                    System.out.println("-----------------------------------------------------------");

                    System.out.println("RTT: " + rtt + " seconds");
                } catch (SocketTimeoutException e) {
                    System.out.println("--------------- Ping Response Packet Timed-Out ------------------");
                }

                // Wait for specified time before sending next packet
                Thread.sleep(waitTime * 1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Print summary
        double packetLoss = ((double) (packetsSent - packetsReceived) / packetsSent) * 100;
       
    }
}
