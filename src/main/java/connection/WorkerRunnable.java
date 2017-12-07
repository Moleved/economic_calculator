package connection;

import java.io.*;
import java.net.Socket;

public class WorkerRunnable implements Runnable {

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            OutputStream output = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while (!(message = reader.readLine()).equals("closed")) {
                System.out.println(message);
                String response = new MessageHandler(new MessageParser(message)).handle();
                response += "\n";
                output.write(response.getBytes());
                System.out.println("MESSAGE: " + response);
                System.out.println("Message sent");
            }


            output.close();
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}
