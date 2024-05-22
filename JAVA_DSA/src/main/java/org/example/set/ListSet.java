package org.example.set;

import org.example.iteration.Iterator;
import org.example.list.List;
import org.example.list.LinkedList;

public class ListSet implements Set {
    private final List _values = new LinkedList();

    public boolean contains(Object value) {
        return _values.contains(value);
    }

    public boolean add(Object value) {
        if (contains(value)) {
            return false;
        }
        _values.add(value); 
        return true;
    }

    public boolean delete(Object value) {
        return _values.delete(value);
    }

    public void clear() {
        _values.clear();
    }

    public int size() {
        return _values.size();
    }

    public boolean isEmpty() {
        return _values.isEmpty();
    }

    public Iterator iterator() {
        return _values.iterator();
    }
}
