
package server.model.client;

import java.io.IOException;


abstract public class Client {
    String name = "";
    private int state = 0;
    
    public static final int FREE = 0;
    public static final int BUSY = 1;

    public abstract void send(String message);
    public abstract String receive() throws IOException;
    public abstract boolean hasIncoming() throws IOException;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
        
        
    @Override
    public String toString() {
            return name + ",";
    }
        
}
