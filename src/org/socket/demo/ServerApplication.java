package org.socket.demo;

import java.io.IOException;
import java.net.BindException;

public class ServerApplication {
    public static void main(String[] args) {
        try {
            IServer server = new Server(ApplicationConstants.APPLICATION_DEMO_PORT);
            server.doWhileNotExit();
        } catch (BindException bindException) {
            System.out.println("Address or port port is already in use.");
        } catch (IOException exception) {
            System.out.println("Server application error.");
            exception.printStackTrace();
        }
    }
}
