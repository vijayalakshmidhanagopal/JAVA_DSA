package org.example.queue;

public class BlockingQueue implements Queue{
    private final Object _mutex = new Object();
    private final Queue _queue;
    private final int _maxSize;
    public BlockingQueue(Queue queue, int maxSize) {
        assert queue != null :"queue can't be null";
        assert maxSize > 0 :"size can't be less than 0";
        _queue = queue;
        _maxSize = maxSize;
    }
    public BlockingQueue(Queue queue) {

        this(queue, Integer.MAX_VALUE);
    }
    public void enqueue(Object value) {
        synchronized (_mutex) {
            while (size() == _maxSize) {
                waitForNotification();
            }
            _queue.enqueue(value);
            _mutex.notifyAll();
        }
    }
    private void waitForNotification() {
        try {
            _mutex.wait();
        } catch (InterruptedException e) {
// Ignore
        }
    }
    public Object dequeue() throws EmptyQueueException {
        synchronized (_mutex) {
            while (isEmpty()) {
                waitForNotification();
            }
            Object value = _queue.dequeue();
            _mutex.notifyAll();
            return value;
        }
    }
    public void clear() {
        synchronized (_mutex) {
            _queue.clear();
            _mutex.notifyAll();
        }
    }
    public int size() {
        synchronized (_mutex) {
            return _queue.size();
        }
    }
    public boolean isEmpty() {
        synchronized (_mutex) {
            return _queue.isEmpty();
        }
    }

}
