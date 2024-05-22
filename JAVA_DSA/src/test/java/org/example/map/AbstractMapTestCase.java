package org.example.map;

import junit.framework.TestCase;
import org.example.list.List;
import org.example.iteration.Iterator;
import org.example.list.LinkedList;
import org.example.iteration.ReverseIterator;
import org.example.iteration.IteratorOutOfBoundsException;

public abstract class AbstractMapTestCase extends TestCase {
    private static final Map.Entry A = new DefaultEntry("akey", "avalue");
    private static final Map.Entry B = new DefaultEntry("bkey", "bvalue");
    private static final Map.Entry C = new DefaultEntry("ckey", "cvalue");
    private static final Map.Entry D = new DefaultEntry("dkey", "dvalue");
    private static final Map.Entry E = new DefaultEntry("ekey", "evalue");
    private static final Map.Entry F = new DefaultEntry("fkey", "fvalue");
    private Map _map;
    protected void setUp() throws Exception {
        super.setUp();
        _map = createMap();
        _map.set(C.getKey(), C.getValue());
        _map.set(A.getKey(), A.getValue());
        _map.set(B.getKey(), B.getValue());
        _map.set(D.getKey(), D.getValue());
    }
    protected abstract Map createMap();
    public void testContainsExisting() {
        assertTrue(_map.contains(A.getKey()));
        assertTrue(_map.contains(B.getKey()));
        assertTrue(_map.contains(C.getKey()));
        assertTrue(_map.contains(D.getKey()));
    }
    public void testContainsNonExisting() {
        assertFalse(_map.contains(E.getKey()));
        assertFalse(_map.contains(F.getKey()));
    }
    public void testGetExisting() {
        assertEquals(A.getValue(), _map.get(A.getKey()));
        assertEquals(B.getValue(), _map.get(B.getKey()));
        assertEquals(C.getValue(), _map.get(C.getKey()));
        assertEquals(D.getValue(), _map.get(D.getKey()));
    }
    public void testGetNonExisting() {
        assertNull(_map.get(E.getKey()));
        assertNull(_map.get(F.getKey()));
    }
    public void testSetNewKey() {
        assertEquals(4, _map.size());
        assertNull(_map.set(E.getKey(), E.getValue()));

        assertEquals(E.getValue(), _map.get(E.getKey()));
        assertEquals(5, _map.size());
        assertNull(_map.set(F.getKey(), F.getValue()));
        assertEquals(F.getValue(), _map.get(F.getKey()));
        assertEquals(6, _map.size());
    }
    public void testSetExistingKey() {
        assertEquals(4, _map.size());
        assertEquals(C.getValue(), _map.set(C.getKey(), "cvalue2"));
        assertEquals("cvalue2", _map.get(C.getKey()));
        assertEquals(4, _map.size());
    }
    public void testDeleteExisting() {
        assertEquals(4, _map.size());
        assertEquals(B.getValue(), _map.delete(B.getKey()));
        assertFalse(_map.contains(B.getKey()));
        assertEquals(3, _map.size());
        assertEquals(A.getValue(), _map.delete(A.getKey()));
        assertFalse(_map.contains(A.getKey()));
        assertEquals(2, _map.size());
        assertEquals(C.getValue(), _map.delete(C.getKey()));
        assertFalse(_map.contains(C.getKey()));
        assertEquals(1, _map.size());
        assertEquals(D.getValue(), _map.delete(D.getKey()));
        assertFalse(_map.contains(D.getKey()));
        assertEquals(0, _map.size());
    }
    public void testDeleteNonExisting() {
        assertEquals(4, _map.size());
        assertNull(_map.delete(E.getKey()));
        assertEquals(4, _map.size());
        assertNull(_map.delete(F.getKey()));
        assertEquals(4, _map.size());
    }
    public void testClear() {
        assertEquals(4, _map.size());
        assertFalse(_map.isEmpty());
        _map.clear();
        assertEquals(0, _map.size());
        assertTrue(_map.isEmpty());
        assertFalse(_map.contains(A.getKey()));
        assertFalse(_map.contains(B.getKey()));

        assertFalse(_map.contains(C.getKey()));
        assertFalse(_map.contains(D.getKey()));
    }


}
