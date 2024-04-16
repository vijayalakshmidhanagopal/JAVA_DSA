package org.example.list;
import org.example.iteration.Iterable;

public interface List extends  Iterable{
    public void insert(int index, Object value)
            throws IndexOutOfBoundsException;
    public void add(Object value);
    public Object delete(int index) throws IndexOutOfBoundsException;
    public boolean delete(Object value);
    public void clear();
    public Object set(int index, Object value)
            throws IndexOutOfBoundsException;
    public Object get(int index) throws IndexOutOfBoundsException;
    public int indexOf(Object value);
    public boolean contains(Object value);
    public int size();
    public boolean isEmpty();
}
