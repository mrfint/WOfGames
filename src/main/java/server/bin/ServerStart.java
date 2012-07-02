package server.bin;

import server.eventmodel.EventOfProtocol;
import server.webServer.WebServer;

public class ServerStart {

    public static void main(String[] args) {
        
        Thread t1 = new Thread(new SocketListener());
        Thread t2 = new Thread(new WebServer());
        Thread t3 = new Thread(new ClientsListener());
        Thread t4 = new Thread(new ProtocolEventDispetcher());
        Thread t5 = new Thread(new WebSocketListener());
        // Run threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
