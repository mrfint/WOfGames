
package eventmodel;


public class Events {


    public static void main(String[] args) {
        MyEventProducer client = new MyEventProducer();
        
        client.addMyListener(new Listener());
        client.doWork("vasia login");
        client.doWork("nick login");
    }
    
    private static class Listener implements MyListener{
    
            @Override
            public void myHappend(MyEvent myEvent) {
                System.out.println("myHappend() " + myEvent.getMessage());
            }

            @Override
            public void myWillHappend(MyEvent myEvent) {
                System.out.println("myWillHappend() " + myEvent.getMessage());
            }
        
}
}
