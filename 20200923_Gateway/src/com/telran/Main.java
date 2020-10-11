package com.telran;

import java.io.IOException;

public class Main {

    static final int OUTER_TCP_PORT = 5000;
    static final int FROM_BALANCER_UDP_PORT = 5002;

    public static void main(String[] args) throws IOException {

        // storage for an optimal backend server coordinates
        BackendServerDataStorage serverData = new BackendServerDataStorage();

        // odp balancer listener, which updates serverData
        System.out.println("Load balancer listener run on port " + FROM_BALANCER_UDP_PORT);
        BalancerUDPListener balancerUDPListener = new BalancerUDPListener(serverData, FROM_BALANCER_UDP_PORT);
        Thread balancerThread = new Thread(balancerUDPListener);
        balancerThread.start();

        // the thread, which routes requests from client to backend
        System.out.println("Tcp proxy run on port " + OUTER_TCP_PORT);
        TCPProxy tcpProxy = new TCPProxy(serverData, OUTER_TCP_PORT);
        Thread proxyThread = new Thread(tcpProxy);
        proxyThread.start();

    }
}
