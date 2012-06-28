package server.eventmodel;

import java.util.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;


public class EventsQueue {

    private static EventsQueue _instance = null;

    private Queue<EventOfProtocol> _queue = new ConcurrentLinkedQueue<EventOfProtocol>();


    private EventsQueue() {}

    public static EventsQueue getInstance() {

        if (_instance == null)
            _instance = new EventsQueue();
        return _instance;
    }

    @SuppressWarnings("unchecked")
    public synchronized <T extends EventOfProtocol> T fetchEvent() {
        return (T) _queue.poll();
    }

    public synchronized void putEvent(EventOfProtocol event) {

        _queue.add(event);
        System.out.println("event added. Message:"+event.getMessage());
        System.out.println("queue size: " + _queue.size());

    }

}
