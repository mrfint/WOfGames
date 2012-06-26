package eventmodel;

import java.util.EventObject;

public class EventOfProtocol extends EventObject{
    
    private String            message;


    public EventOfProtocol(Object source, String message)
    {
        super(source);
        this.message = message;
    }
    public EventOfProtocol(Object source)
    {
        this(source, "");
    }
    public EventOfProtocol(String message)
    {
        this(null, message);
    }
    public EventOfProtocol()
    {
        this(null, "");
    }
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString()
    {
        return getClass().getName() + "[source = " + getSource() + ", message = " + message + "]";
    }
        
}
