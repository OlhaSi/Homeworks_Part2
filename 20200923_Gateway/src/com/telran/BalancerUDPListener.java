package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BalancerUDPListener implements Runnable {
    BackendServerDataStorage serverData;
    int fromBalancerUdpPort;

    public BalancerUDPListener(BackendServerDataStorage serverData, int fromBalancerUdpPort) {
        this.fromBalancerUdpPort = fromBalancerUdpPort;
        this.serverData = serverData;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(fromBalancerUdpPort);

            byte[] dataIn = new byte[1024];
            DatagramPacket packetIn = new DatagramPacket(dataIn, dataIn.length);

            while (true) {
                socket.receive(packetIn);

                String body = new String(dataIn, 0, packetIn.getLength());
                String[] hostAndPort = body.split(":");

                synchronized (serverData) {
                    serverData.setHost(hostAndPort[0]);
                    serverData.setPort(Integer.parseInt(hostAndPort[1]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
