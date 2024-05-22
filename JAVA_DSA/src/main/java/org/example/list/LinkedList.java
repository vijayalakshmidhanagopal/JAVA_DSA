package org.example.list;
import org.example.iteration.Iterator;
import org.example.iteration.IteratorOutOfBoundsException;

public class LinkedList implements List{
    private final Element _headAndTail = new Element(null);
    private int _size;
    public LinkedList() {
        clear();
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if (index < 0 || index > _size) {
            throw new IndexOutOfBoundsException();
        }
        Element element = new Element(value);
        element.attachBefore(getElement(index));
        ++_size;
    }


    private Element getElement(int index) {
        Element element = _headAndTail.getNext();
        for (int i = index; i > 0; --i) {
            element = element.getNext();
        }
        return element;
    }
    public void add(Object value) {
        insert(_size, value);
    }
    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }
    public Object set(int index, Object value)
            throws IndexOutOfBoundsException {
        assert value != null :"value can't be null";
        checkOutOfBounds(index);
        Element element = getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }
    private void checkOutOfBounds(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

    }
    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= _size;
    }
    public int indexOf(Object value) {
        assert value != null :"value can't be null";
        int index = 0;
        for (Element e = _headAndTail.getNext();
             e != _headAndTail;
             e = e.getNext()) {
            if (value.equals(e.getValue())) {
                return index;
            }
            ++index;
        }
        return -1;
    }
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }
    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element element = getElement(index);
        element.detach();
        --_size;
        return element.getValue();
    }
    public boolean delete(Object value) {
        assert value != null :"value can't be null";
        for (Element e = _headAndTail.getNext();
             e != _headAndTail;
             e = e.getNext()) {
            if (value.equals(e.getValue())) {
                e.detach();
                --_size;
                return true;
            }
        }
        return false;
    }
    private final class ValueIterator implements Iterator {
        private Element _current = _headAndTail;
        public void first() {
            _current = _headAndTail.getNext();
        }
        public void last() {
            _current = _headAndTail.getPrevious();
        }
        public boolean isDone() {
            return _current == _headAndTail;
        }
        public void next() {
            _current = _current.getNext();
        }
        public void previous() {
            _current = _current.getPrevious();
        }
        public Object current() throws IteratorOutOfBoundsException {
            if (isDone()) {
                throw new IteratorOutOfBoundsException();
            }
            return _current.getValue();
        }
    }
    public Iterator iterator() {
        return new ValueIterator();
    }
    public int size() {
        return _size;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        _headAndTail.setPrevious(_headAndTail);
        _headAndTail.setNext(_headAndTail);
        _size = 0;
    }

}
