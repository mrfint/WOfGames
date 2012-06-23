
package server.model.client;

import eventmodel.ProtocolEvent;
import eventmodel.iProtocolListener;
import java.io.IOException;


abstract public class Client implements iProtocolListener{
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
    
    @Override
    public void refresh(ProtocolEvent myEvent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void suggest(ProtocolEvent myEvent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void response(ProtocolEvent myEvent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
}
