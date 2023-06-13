package server;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(3000);
        System.out.println("Server started on port 3001.");

        Socket window = null;
        BufferedWriter windowOut = null;
        
        while (true) {
            try {
                window = socket.accept();
                System.out.println("Client connected.");

                windowOut = new BufferedWriter(new OutputStreamWriter(window.getOutputStream()));

                windowOut.write("Hello, client!");
                windowOut.newLine();
                windowOut.flush();

                while (true) {
                    Socket client = socket.accept();

                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    
                }

                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Close the resources
                if (window != null) {
                    window.close();
                }
                if (windowOut != null) {
                    windowOut.close();
                }
            }
        }
    }
}
