
package server.model.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import server.SocketServer.CommandFactory;


public class ClientHandler implements Runnable{
    
    private static int PAUSE_TIME = 1000;
    
    @Override
    public void run() {
        while (true) {
        ClientList lstClient = ClientList.getInstance();

        int pause = PAUSE_TIME / (lstClient.size() + 1);

        try {
            Thread.sleep(pause);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        for (int i = 0; i < lstClient.size(); i++) {
            Client player = lstClient.get(i);

            try {
                Thread.sleep(pause);
                if (!player.hasIncoming()) {
                        continue;
                }
                
                
                String inputData="";    String s=""; 
                while ((!(s=player.receive()).toLowerCase().equals("endcommand")))
                {
                        inputData += s;
                }

                System.out.println(">>"+inputData);

                CommandFactory.getInstance(inputData, player).execute(); 
            } catch (Exception e) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        }
	}

}
