package eventmodel;

import java.util.ArrayList;

public class MyEventProducer
{
  private ArrayList<MyListener> listeners = new ArrayList<MyListener>();
  public void addMyListener(MyListener listener)
  {
    listeners.add(listener);
  }
  public MyListener[] getMyListeners()
  {
    return listeners.toArray(new MyListener[listeners.size()]);
  }
  
  public void removeMyListener(MyListener listener)
  {
    listeners.remove(listener);
  }
  
  protected void fireMyWillHappend(String message)
  {
    MyEvent ev = new MyEvent(this, message);
    for(MyListener listener : listeners)
      listener.myWillHappend(ev);
  }
  
  protected void fireMyHappend(String message)
  {
    MyEvent ev = new MyEvent(this, message);
    for(MyListener listener : listeners)
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
