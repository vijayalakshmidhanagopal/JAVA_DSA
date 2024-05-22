package org.example.hashtable;

import org.example.iteration.Iterator;

public class HashtableIterator implements Iterator {
    private final Object[] elements;
    private int currentIndex;

    public HashtableIterator(Object[] elements) {
        this.elements = elements;
        this.currentIndex = 0;
    }
    public void first()
    {
        currentIndex = 0;
    }
    public void next()
    {
        currentIndex++;
    }
    public boolean isDone() {
        return currentIndex >= elements.length;
    }
    public Object current() {
        if (isDone()) {
            throw new IndexOutOfBoundsException("Iterator is out of bounds.");
        }
        return elements[currentIndex];
    }
    public void last() {

        currentIndex = elements.length - 1;
    }




    public void previous() {
        if (currentIndex > 0) {
            currentIndex--;
        } else {
            throw new IndexOutOfBoundsException("Iterator is already at the beginning.");
        }
    }
}

