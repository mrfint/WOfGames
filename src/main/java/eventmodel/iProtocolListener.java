package eventmodel;

import java.io.IOException;

public interface iProtocolListener
{
  public void send(String ev);
  public ProtocolEvent receive();
  public boolean hasIncoming();
  public String getName();
}
