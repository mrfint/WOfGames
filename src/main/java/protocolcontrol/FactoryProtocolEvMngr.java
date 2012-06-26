package protocolcontrol;

import java.util.HashMap;
import java.util.Map;
    
public class FactoryProtocolEvMngr {

    private static Map mp = null;
   
    public static ProtocolEventMngr getInstance(String type)
    {   ProtocolEventMngr ret=null;
        if(mp==null)
        {
            init();
        }
        return (ProtocolEventMngr) mp.get(type);
    }

    private static void init() {
        mp = new HashMap<String, ProtocolEventMngr>();  
            mp.put("lbby", new LobbyListEvMngr());
            mp.put("gmxo", new Game());
    }
}
