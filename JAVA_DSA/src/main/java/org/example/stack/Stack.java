package org.example.stack;
import org.example.queue.Queue;

public interface Stack extends Queue{
    public void push(Object value);
    public Object pop() throws EmptyStackException;
    public Object peek() throws EmptyStackException;
    public void clear();
    public int size();
    public boolean isEmpty();
}

