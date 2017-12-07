package connection;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

//public class TCPServer {
//    private static ServerSocket serverSocket;
//    private static Socket socket;
//    private static boolean isSocketActive = false;
//
//    public static void start() {
//        isSocketActive = true;
//        try {
//            while (isSocketActive) {
//                serverSocket = new ServerSocket(9876);
//                socket = serverSocket.accept();
//
//                System.out.println("Connected!");
//                new Connection(socket);
//                System.out.println("Waiting for connection!");
//            }
//        } catch (SocketException se) {
//            System.out.println(se.getStackTrace());
//        } catch (IOException ioe) {
//            System.out.println(ioe.getStackTrace());
//        }
//    }
//
//    static class Connection extends Thread {
//        Socket socket;
//
//        Connection(Socket socket) {
//            this.socket = socket;
//            this.start();
//        }
//
//        @Override
//        public void run() {
//            try {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//                System.out.println("Thread");
//
//                String message;
//                while (!(message = reader.readLine()).equals("close")) {
//                    new MessageHandler(new MessageParser(message));
//                }
//                socket.close();
//                System.out.println("Closed!");
//            } catch (IOException ex) {
//                System.out.println(ex.getStackTrace());
//            }
//        }
//    }
//
//    public static void closeSession() {
//        try {
//            isSocketActive = false;
//            socket.close();
//        } catch (IOException ex) {
//            System.out.println(ex.getStackTrace());
//        }
//    }
//
//    public static void sendMessage(String message) {
//        try {
//            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
//            outputStream.writeBytes(message + "\n");
//            outputStream.flush();
//        } catch (IOException ex) {
//            System.out.println(ex.getStackTrace());
//        }
//    }
//}

public class TCPServer implements Runnable {

    protected int          serverPort    = 9876;
    protected ServerSocket serverSocket  = null;
    protected boolean      isStopped     = false;
    protected Thread       runningThread = null;

    public TCPServer(int port){
        this.serverPort = port;
    }

    public void run(){
        synchronized(this) {
            this.runningThread = Thread.currentThread();
        }

        openServerSocket();

        while(!isStopped()){

            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }

                throw new RuntimeException(
                        "Error accepting client connection", e);
            }

            new Thread(
                    new WorkerRunnable(
                            clientSocket, "Multithreaded Server")
            ).start();
        }
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 9876", e);
        }
    }

}
