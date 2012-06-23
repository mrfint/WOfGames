package eventmodel;

import java.util.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;


public class EventsQueue {

    private static EventsQueue _instance = null;

    private Queue<AbstractEvent> _queue = new ConcurrentLinkedQueue<AbstractEvent>();


    private EventsQueue() {}

    public static EventsQueue getInstance() {

        if (_instance == null)
            _instance = new EventsQueue();
        return _instance;
    }

    @SuppressWarnings("unchecked")
    public synchronized <T extends AbstractEvent> T fetchEvent() {
        return (T) _queue.poll();
    }

    public synchronized void putEvent(AbstractEvent event) {

        _queue.add(event);
        System.out.println("event with class: " + event.getClass().getName() + " added");
        System.out.println("queue size: " + _queue.size());

    }

}
