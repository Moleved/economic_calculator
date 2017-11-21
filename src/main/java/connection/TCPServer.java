package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream inputStream;

    public TCPServer() {}

    public void establishConnection() {
        try {
            serverSocket = new ServerSocket(9999);
            socket = serverSocket.accept();

            System.out.println("Connected!");

            inputStream = new ObjectInputStream(socket.getInputStream());

            Object object = (Object) inputStream.readObject();
            socket.close();
        } catch (SocketException se) {
            System.out.println(se.getStackTrace());
        } catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
