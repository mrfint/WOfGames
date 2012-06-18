
package server.model.games;

import java.util.LinkedList;
import java.util.List;
import server.model.client.Client;


abstract public class Game {
    public static int counter = 0;
    protected List<Client> lst;
    private int id;
    private String name;
    
    
    public Game(Client c){
        
        this.name = this.getClass().getSimpleName();
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
        
//        for(ClientSocket player: lst){
//            if(player.getInputStream().hasNextLine())
//            {
//                res = true;
//                break;
//            };
//        }
        return res;
    }

    public void start() {
        
        for(Client client:lst){
            client.send("GameStart:");
            client.send("endResponse:");          
        }
        
        play();
        
        for(Client client:lst){
            client.send("GameEnd:");
            client.send("endResponse:");          
        }
    }

    @Override
    public String toString() {
        return name;
    }
    

    
    abstract public void play();
    
    
}
