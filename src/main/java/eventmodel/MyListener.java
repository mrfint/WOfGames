package eventmodel;

public interface MyListener
{
  public void myWillHappend(MyEvent myEvent);
  public void myHappend(MyEvent myEvent);
}
