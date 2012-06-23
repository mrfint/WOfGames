package eventmodel;

import java.util.ArrayList;

public class MyEventProducer
{
  private ArrayList<iProtocolListener> listeners = new ArrayList<iProtocolListener>();
  public void addMyListener(iProtocolListener listener)
  {
    listeners.add(listener);
  }
  public iProtocolListener[] getMyListeners()
  {
    return listeners.toArray(new iProtocolListener[listeners.size()]);
  }
  
  public void removeMyListener(iProtocolListener listener)
  {
    listeners.remove(listener);
  }
  
  protected void fireMyWillHappend(String message)
  {
    MyEvent ev = new MyEvent(this, message);
    for(iProtocolListener listener : listeners)
      listener.myWillHappend(ev);
  }
  
  protected void fireMyHappend(String message)
  {
    MyEvent ev = new MyEvent(this, message);
    for(iProtocolListener listener : listeners)
      listener.myHappend(ev);
  }
  
  public void doWork(String workName)
  {
    fireMyWillHappend("begin work " + workName);
    try
    {
      Thread.sleep(1000);
    }
    catch(InterruptedException e)
    {
    }
    fireMyHappend("end work" + workName);
  }
}
