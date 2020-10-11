package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Main {

    static final String SERVER_HOST = "google.com";
    static final int SERVER_PORT = 80;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(SERVER_HOST, SERVER_PORT);

        // sends data from console to the server
        PrintStream socketOut = new PrintStream(socket.getOutputStream());
        // receives data from server
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        socketOut.println("GET / HTTP/1.1");
        socketOut.println("Host: www.google.com");
        socketOut.println();

        String line;

        int counter = 0;
        while ((line = socketIn.readLine()) != null) {
//            if (line.equals("")){
//                if (counter == 1)
//                    break;
//                counter++;
//            }
            if (line.equals("") && counter++ == 1)
                break;

            System.out.println(line);
        }

        socket.close();
    }
}
