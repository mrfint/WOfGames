
package server.model.games;

import java.util.LinkedList;
import java.util.List;
import server.model.client.Client;


public class AGame {
    public static long counter = 0;
    protected List<Client> lst;
    private long id;
    

    public AGame(Client c){
        id = counter++;
        lst = new LinkedList<Client>();
        
        lst.add(c);
    }
    
    public void addPlayer(Client c){
        lst.add(c);
    }

    public long getId() {
        return id;
    }
    
    public boolean hasRespond(){
        boolean res = false;
        
        for(Client player: lst){
            if(player.getInputStream().hasNextLine())
            {
                res = true;
                break;
            };
        }
        return res;
    }
    
    
}
