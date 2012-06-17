package server.SocketSever;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientSocketDemo {
     public static void main(String[] args )
   {  
      try
      {  
            Socket s = new Socket("localhost", 8189);
            
            InputStream inStream = s.getInputStream();
            OutputStream outStream = s.getOutputStream();
            
            Scanner in = new Scanner(inStream);
            Scanner in_cmd = new Scanner(System.in);
            PrintWriter out = new PrintWriter(outStream, true );
            String ss;
            try
            {
                do {

                    ss=in_cmd.nextLine();//+"\r\nendCommand";
                    out.println(ss);
                }
                while (!(ss).equals("endCommand"));
                   
                String line="";
                while (in.hasNextLine()&&(!(line=in.nextLine()).equals("endResponse"))) {
                    
                    System.out.println(line);
                }
                   
                
            }
            finally{
                s.close();
            }
      
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }
}
