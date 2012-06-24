package eventmodel;

import java.util.EventObject;

public class ProtocolEvent extends EventObject{
    
    private String            message;


    public ProtocolEvent(Object source, String message)
    {
        super(source);
        this.message = message;
    }
    public ProtocolEvent(Object source)
    {
        this(source, "");
    }
    public ProtocolEvent(String message)
    {
        this(null, message);
    }
    public ProtocolEvent()
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
