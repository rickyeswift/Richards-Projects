Richard Elliott Jr V# 01000504

To compile and execute the program, follow the steps below:

Open a terminal or command prompt.

Navigate to the directory where the source code files are located.

Compile the PINGClient.java file using the following command:

Copy code
javac PINGClient.java
Compile the PINGServer.java file using the following command:

Copy code
javac PINGServer.java
Start the PINGServer by running the following command:

php
Copy code
java PINGServer <port number> <timeout>
Replace <port number> with the port number you want the server to listen on, and <timeout> with the number of seconds after which a ping request is considered to have timed out.

Start the PINGClient by running the following command:

php
Copy code
java PINGClient <server IP address> <port number> <client ID> <number of packets> <wait time between packets>
Replace <server IP address> with the IP address of the server, <port number> with the port number the server is listening on, <client ID> with a unique identifier for the client, <number of packets> with the number of ping packets to send, and <wait time between packets> with the time to wait between sending each packet.

The output of the PINGClient and PINGServer programs will be displayed in the terminal or command prompt.