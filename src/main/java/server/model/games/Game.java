
package server.model.games;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.model.client.Client;


abstract public class Game {
    public static int counter = 0;
    protected List<Client> lst;
    protected int current = -1;
    private int id;
    private String name;
    private boolean isStart = false;
    
    
    private String inLine;
    
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

    public void start() {
        //BooleanFlag
        isStart = true;
        
        for(Client client:lst){
            client.send("GameStart:");
            client.send("endResponse:");          
        }
        current = (int) (Math.random()*lst.size());
        
        lst.get(current).send("Listen:");
        
    }
    public void end() {
        for(Client client:lst){
            client.send("GameEnd:");
            client.send("endResponse:");          
        }
    }
    
    void reseive() {
        try {
            inLine = lst.get(current).receive();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    abstract void control();

    abstract void send();

    void setNextCurrent() {
        current = (current+1<lst.size())? ++current : 0;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    public void setEnd() {
        isStart = false;
    }
    public boolean isContinuous() {
        return isStart;
    }

    boolean hasIncoming() throws IOException {
        return lst.get(current).hasIncoming();
    }

    public String getInLine() {
        return inLine;
    }

    public int getCurrent() {
        return current;
    }
    
    
}
