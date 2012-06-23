package eventmodel;

import java.util.EventObject;

public class MyEvent extends EventObject
{
  private static final long serialVersionUID = -6326247162271636387L;
  private String            message;
  public MyEvent(Object source, String message)
  {
    super(source);
    this.message = message;
  }
  public MyEvent(Object source)
  {
    this(source, "");
  }
  public MyEvent(String message)
  {
    this(null, message);
  }
  public MyEvent()
  {
    this(null, "");
  }
  public String getMessage()
  {
    return message;
  }
  @Override
  public String toString()
  {
    return getClass().getName() + "[source = " + getSource() + ", message = " + message + "]";
  }
}
