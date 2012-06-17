
package server.model.games;

import java.util.LinkedList;
import java.util.List;
import server.model.client.Client;


abstract public class AGame {
    public static int counter = 0;
    protected List<Client> lst;
    private int id;
    

    public AGame(Client c){
        id = counter++;
        lst = new LinkedList<Client>();
        
        lst.add(c);
    }
    
    public void addPlayer(Client c){
        lst.add(c);
    }

    public int getId() {
        return id;
    }
    public int getQualOfPlayers(){
        return lst.size();
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

    public void start() {
        
        for(Client client:lst){
            client.getOutStream().println("GameStart:");
            client.getOutStream().println("endResponse:");          
        }
        
        play();
        
        for(Client client:lst){
            client.getOutStream().println("GameEnd:");
            client.getOutStream().println("endResponse:");          
        }
    }

    abstract public void play();
    
    
}
