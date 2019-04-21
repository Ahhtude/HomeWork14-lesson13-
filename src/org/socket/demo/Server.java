package org.socket.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements IServer {

    private final int serverPort;

    public Server(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    public void doWhileNotExit() throws IOException {
        try(
            ServerSocket serverSocket = new ServerSocket(serverPort);
        ) {
            System.out.println("Server started on port " + serverPort);
            try (
                Socket socket = serverSocket.accept();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                );
            ) {
                System.out.println("Client connected to server.");
                String clientMessage = null;
                while(!ApplicationConstants.EXIT_COMMAND.equals((clientMessage = br.readLine()))) {
                    System.out.println("Message from client " + clientMessage);
                    bw.write("Message received.");
                    bw.newLine();
                    bw.flush();
                }
            }
        }
    }
}
