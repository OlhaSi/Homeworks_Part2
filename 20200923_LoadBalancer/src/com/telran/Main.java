package com.telran;

import com.telran.backend.IBackendServerStorage;
import com.telran.backend.SetBackendStorage;
import com.telran.task.BackendUdpListener;
import com.telran.task.GatewayUdpSender;

import java.io.IOException;

public class Main {

    // the port which listens to Backends
    static final int PORT_BACKEND_LISTENER = 5001;

    // coordinates gateway
    static final String GATEWAY_HOST = "localhost";
    static final int PORT_GATEWAY_LISTENER = 5002;
    private static final int SENDING_PERIOD_MILLIS = 100;

    public static void main(String[] args) throws IOException {

        IBackendServerStorage storage = new SetBackendStorage();

        // start listening load data from the backends
        BackendUdpListener backendUdpListener = new BackendUdpListener(storage, PORT_BACKEND_LISTENER);
        Thread listenerThread = new Thread(backendUdpListener);
        listenerThread.start();

        // start periodically send optimal backend data to the Gateway
        GatewayUdpSender gatewaySender = new GatewayUdpSender(GATEWAY_HOST, PORT_GATEWAY_LISTENER, storage, SENDING_PERIOD_MILLIS);
        Thread senderThread = new Thread(gatewaySender);
        senderThread.start();
    }
}
