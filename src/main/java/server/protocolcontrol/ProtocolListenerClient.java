package server.protocolcontrol;




import server.eventmodel.EventOfProtocol;

abstract public class ProtocolListenerClient
{
    public static final int FREE = 0;
    public static final int BUSY = 1;
 
    abstract public EventOfProtocol receive();
    abstract public boolean hasIncoming();
    abstract public void send(String ev);

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
    
    private String name = "";
    private int    state = 0;
}
