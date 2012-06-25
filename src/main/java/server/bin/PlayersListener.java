
package server.bin;

import eventmodel.EventsQueue;
import eventmodel.ProtocolEvent;
import eventmodel.iProtocolListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.model.client.ClientList;


public class PlayersListener implements Runnable{
    
    private static int PAUSE_TIME = 1000;
    
    @Override
    public void run() {
        while (true) {
            ClientList lstClient = ClientList.getInstance();

            int pause = PAUSE_TIME / (lstClient.size() + 1);
            
            for (int i = 0; i < lstClient.size(); i++) 
            {
                iProtocolListener player = lstClient.get(i);
                
                if (player.hasIncoming())
                {
                    ProtocolEvent gotMessage  = player.receive();
                    EventsQueue.getInstance().putEvent( gotMessage );

                    System.out.println(">>"+gotMessage.getMessage());
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
