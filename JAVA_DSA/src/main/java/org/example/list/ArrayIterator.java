package org.example.list;
import org.example.iteration.IteratorOutOfBoundsException;

public class ArrayIterator implements Iterator{
    private final Object[] _array;
    private final int _start;
    private final int _end;
    private int _current = 0;

    public ArrayIterator(Object[] array, int start, int length) {
        assert array != null : "array can't be null";
        assert start >= 0 : "start value can't be <0";
        assert start < array.length : "start can't be > array.length";
        assert length >= 0 : "length can't be < 0";
        _array = array;
        _start= start;
        _end = start + length - 1;
        assert _end < array.length ;
    }
    public ArrayIterator(Object[] array) {
        assert array != null : "array can't be zero";
        _array = array;
        _start = 0;
        _end = array.length - 1;
    }

    public void first() {
        _current = _start;
    }
    public void last() {
        _current = _end;
    }
    public void next() {
        ++_current;

    }

    public void previous() {
        --_current;
    }
    public boolean isDone() {
        return _current < _start || _current > _end;
    }
    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) {
            throw new IteratorOutOfBoundsException();
        }
        return _array[_current];
    }
}
