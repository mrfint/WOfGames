
package server.model.games;

import server.model.client.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.SocketSever.CommandFactory;


public class GameHandler implements Runnable{
    
    private static int PAUSE_TIME = 1000;
    
    @Override
    public void run() {
       
        while (true) {
            
            GameList lstGames = GameList.getInstance();

            int pause = PAUSE_TIME / (lstGames.size() + 1);

            try {
                Thread.sleep(pause);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            
            for (int i = 0; i < lstGames.size(); i++) {
                Game game = lstGames.get(i);

                try {
                    Thread.sleep(pause);
                    if ( (!game.isContinuous()) && (!game.hasIncoming()) ) {
                            continue;
                    }
                    game.reseive();
                    
                    game.control();
                    
                    game.send();
                    
                    game.setNextCurrent();

                } catch (Exception e) {
                    Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            
        }
    }

}
