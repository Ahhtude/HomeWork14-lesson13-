package org.socket.demo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements IClient {

    private final String serverHost;

    private final int serverPort;

    public Client(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    @Override
    public void doWhileNotExit() throws IOException {
        try (
                Socket socket = new Socket(this.serverHost, this.serverPort);
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                );
                Scanner scanner = new Scanner(System.in);
                //
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
        ) {
            String userText = null;
            while (!ApplicationConstants.EXIT_COMMAND.equals(userText)) {
                System.out.println("Enter message");
                userText = scanner.nextLine();
                bw.write(userText);
                bw.newLine();
                bw.flush();

                String dataFromServer = br.readLine();
                System.out.println("Received from server " + dataFromServer);
            }
        }
    }
}
