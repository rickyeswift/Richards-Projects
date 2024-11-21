/*****************************************************************************
 * Author: Richard Elliott Jr                                                *
 * Date: 04/25/23                                                            *
 * CMSC 440 Spring 2023                                                      * 
 * This code accepts two command-line arguments port which listens for       *
 * incoming pings from clients, and loss which is the percentage of packet   *
 * drops.                                                                    *
 * PING Assignment                                                           *
 * ***************************************************************************
 */
import java.net.*;
import java.util.*;

public class PINGServer {
    public static void main(String[] args) {
        // Parse command line arguments
        int port = Integer.parseInt(args[0]);
        int timeout = Integer.parseInt(args[1]);

        // Create socket and packet to receive data
        DatagramSocket socket = null;
        DatagramPacket packet = null;
        try {
            socket = new DatagramSocket(port);
            byte[] buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
        } catch (Exception e) {
            System.out.println("Error creating socket: " + e.getMessage());
            System.exit(1);
        }

        // Start listening for packets
        System.out.println("PINGServer started with server IP: " + socket.getLocalAddress() +
                           ", port: " + socket.getLocalPort() + " ...");
        while (true) {
            try {
                // Receive packet
                socket.receive(packet);

                // Parse packet data
                byte[] data = packet.getData();
                int length = packet.getLength();
                PINGPacket pingPacket = new PINGPacket(data, length);

                // Generate response packet
                PINGPacket responsePacket = new PINGPacket(pingPacket.getClientID(),
                                                           pingPacket.getSequenceNo(),
                                                           pingPacket.getTime(),
                                                           pingPacket.getPayload());
                responsePacket.setPayload(responsePacket.getPayload().toUpperCase().getBytes());

                // Send response packet
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                DatagramPacket response = new DatagramPacket(responsePacket.getBytes(),
                                                              responsePacket.getLength(),
                                                              clientAddress, clientPort);
                socket.send(response);

                // Print packet information
                System.out.println("IP:" + clientAddress + " :: Port:" + clientPort +
                                   " : ClientID:" + pingPacket.getClientID() +
                                   " :: Seq#:" + pingPacket.getSequenceNo() + " :: RECEIVED");
                System.out.println("----------Received Ping Request Packet Header----------");
                System.out.println(pingPacket.getHeader());
                System.out.println("---------Received Ping Request Packet Payload------------");
                System.out.println(pingPacket.getPayload());
                System.out.println("---------------------------------------");

                // Wait for next packet
                socket.setSoTimeout(timeout * 1000);
                socket.receive(packet);
            } catch (SocketTimeoutException e) {
                // Print timeout message
                PINGPacket timedOutPacket = new PINGPacket(packet.getData(), packet.getLength());
                System.out.println("IP:" + packet.getAddress() + " :: Port:" + packet.getPort() +
                                   " : ClientID:" + timedOutPacket.getClientID() +
                                   " :: Seq#:" + timedOutPacket.getSequenceNo() + " :: DROPPED");
            } catch (Exception e) {
                System.out.println("Error receiving packet: " + e.getMessage());
            }
        }
    }
}
