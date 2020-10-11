package com.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPProxy implements Runnable {

    int outerTCPPort;
    final BackendServerDataStorage serverData;

    public TCPProxy(BackendServerDataStorage serverData, int outerTCPPort) {
        this.outerTCPPort = outerTCPPort;
        this.serverData = serverData;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(outerTCPPort);

            while (true) {
                // the server accepts a connection
                Socket clientSocket = serverSocket.accept();

                TCPProxyTask task = new TCPProxyTask(clientSocket, serverData);
                Thread tcpProxyThread = new Thread(task);
                tcpProxyThread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
