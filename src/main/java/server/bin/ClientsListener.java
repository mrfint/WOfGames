
package server.bin;

import server.eventmodel.EventsQueue;
import server.eventmodel.EventOfProtocol;
import server.protocolcontrol.ProtocolListenerClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.model.client.ClientList;


public class ClientsListener implements Runnable{
    
    private static int PAUSE_TIME = 1000;
    
    @Override
    public void run() {
        while (true) {
            ClientList lstClient = ClientList.getInstance();

            int pause = PAUSE_TIME / (lstClient.size() + 1);
            
            for (int i = 0; i < lstClient.size(); i++) 
            {
                ProtocolListenerClient player = lstClient.get(i);
             
                if (player.hasIncoming())
                {
                    EventOfProtocol gotMessage  = player.receive();
                    EventsQueue.getInstance().putEvent( gotMessage );

                }
            }
            
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            
        }
    }

}
