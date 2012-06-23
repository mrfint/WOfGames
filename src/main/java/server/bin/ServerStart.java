package server.bin;

import server.SocketSever.SocketListener;
import server.model.client.ClientHandler;
import server.webServer.WebServer;

public class ServerStart {

    public static void main(String[] args) {
        
        Thread t1 = new Thread(new SocketListener());
        Thread t2 = new Thread(new WebServer());
        Thread t3 = new Thread(new ClientHandler());
        // Run threads
        t1.start();
        t2.start();
        t3.start();
        
    }
}
