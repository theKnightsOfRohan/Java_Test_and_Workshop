package server;

import java.net.*;
import java.io.*;

public class Window {
    public static void main(String[] args) throws IOException {
        while (true) {
            Socket socket = null;

            try {
                socket = new Socket("localhost", 3002);
                System.out.println("Window started on port " + socket.getPort());

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

    public static void send(String message, Socket socket) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            out.write(message);
            out.newLine();
            out.flush();
            System.out.println("Client sent: " + message);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
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
