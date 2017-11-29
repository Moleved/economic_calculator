package connection;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static boolean isSocketActive = false;

    public static void establishConnection() {
        isSocketActive = true;
        try {
            while (isSocketActive) {
                serverSocket = new ServerSocket(9876);
                socket = serverSocket.accept();

                System.out.println("Connected!");

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                new MessageHandler(new MessageParser(reader.readLine()));
            }
        } catch (SocketException se) {
            System.out.println(se.getStackTrace());
        } catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
        }
    }

    public static void closeSession() {
        try {
            isSocketActive = false;
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    public static void sendMessage(String message) {
        try {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeBytes(message);
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
