package server.clientsExample;


import java.io.*;
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
            
//            Scanner in = new Scanner(inStream);
            BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
            Scanner in_cmd = new Scanner(System.in);
            PrintWriter out = new PrintWriter(outStream, true );
            String ss;
            try
            {   
                while(true){
//                do {

                    ss=in_cmd.nextLine();//+"\r\nendCommand";
                    out.println(ss);
//                }
//                while (!(ss).toLowerCase().equals("endcommand"));
                   
                String line="";
                //if(in.ready()){
                    while ((!(line=in.readLine()).toLowerCase().equals("endresponse"))) {

                        System.out.println(line);
                    }
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
