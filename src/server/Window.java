package server;

import java.net.*;
import java.io.*;

public class Window {
    public static void main(String[] args) throws IOException {
        while (true) {
            Socket socket = null;

            try {
                socket = new Socket("localhost", 3000);
                System.out.println("Client started on port 3000.");

                receive(socket);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Close the resources
                if (socket != null) {
                    socket.close();
                }
            }
        }
    }

    public static String receive(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String response = in.readLine();
            System.out.println("Server sent: " + response);

            in.close();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
