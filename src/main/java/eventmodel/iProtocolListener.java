package eventmodel;

public interface iProtocolListener
{
  public void refresh(ProtocolEvent myEvent);
  public void suggest(ProtocolEvent myEvent);
  public void response(ProtocolEvent myEvent);
  
  
}
