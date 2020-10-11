package com.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static final int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        // the object which reserves a certain port
        // and then listens for the connections (sockets)
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        while (true) {
            // the server accepts a connection
            Socket socket = serverSocket.accept();

            Runnable serverTaskThread = new ServerTask(socket);
            pool.execute(serverTaskThread);

            // the same but using lambda
//            pool.execute(() -> {
//                try {
//                    PrintStream socketOut;
//                    socketOut = new PrintStream(socket.getOutputStream());
//
//                    // receives data from client
//                    BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//                    String line;
//                    while ((line = socketIn.readLine()) != null) {
//                        String response = String.format("The string %s was accepted from the client and handled", line);
//                        socketOut.println(response);
//
//                    }
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
        }
    }
}

