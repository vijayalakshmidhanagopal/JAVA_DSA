package org.example.queue;

public class ListFifoQueueTest extends AbstractFifoQueueTestCase{
    protected Queue createFifoQueue() {
        return new ListFifoQueue();
    }
}
