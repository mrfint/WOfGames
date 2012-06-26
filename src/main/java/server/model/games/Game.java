
package server.model.games;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract public class Game  {
    public static int counter = 0;

    protected int current = -1;
    private int id;
    private String name;
    private boolean isStart = false;
    
    
    private String inLine;

    public int getId() {
        return id;
    }
    
    
    
             

    public void start() {
//        //BooleanFlag
//        isStart = true;
//        
//        for(Client client:lst){
//            client.send("GameStart:");
//            client.send("endResponse:");          
//        }
//        current = (int) (Math.random()*lst.size());
//        
//        lst.get(current).send("Listen:");
        
    }
    public void end() {
//        for(Client client:lst){
//            client.send("GameEnd:");
//            client.send("endResponse:");          
//        }
    }
    
    void reseive() {
//        try {
//            inLine = lst.get(current).receive();
//        } catch (IOException ex) {
//            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    abstract void control();

    abstract void send();


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

    public String getInLine() {
        return inLine;
    }

    public int getCurrent() {
        return current;
    }
    
    
}
