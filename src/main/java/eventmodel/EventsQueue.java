package eventmodel;

import java.util.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;


public class EventsQueue {

    private static EventsQueue _instance = null;

    private Queue<ProtocolEvent> _queue = new ConcurrentLinkedQueue<ProtocolEvent>();


    private EventsQueue() {}

    public static EventsQueue getInstance() {

        if (_instance == null)
            _instance = new EventsQueue();
        return _instance;
    }

    @SuppressWarnings("unchecked")
    public synchronized <T extends ProtocolEvent> T fetchEvent() {
        return (T) _queue.poll();
    }

    public synchronized void putEvent(ProtocolEvent event) {

        _queue.add(event);
        System.out.println("event added. Message:"+event.getMessage());
        System.out.println("queue size: " + _queue.size());

    }

}
