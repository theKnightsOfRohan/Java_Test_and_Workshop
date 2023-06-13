package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                Socket socket = new Socket("localhost", 3000);
                System.out.println("Client started on port 3000.");

                String message = input.nextLine();

                send(message, socket);
                receive(socket);

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
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
