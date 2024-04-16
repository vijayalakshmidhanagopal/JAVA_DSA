package org.example.sort;

import junit.framework.TestCase;
import org.example.list.List;
import org.example.list.LinkedList;
import org.example.iteration.Iterator;


public abstract class AbstractListSorterTest extends TestCase {
    private List _unsortedList;
    private List _sortedList;

    protected void setUp() throws Exception {
        _unsortedList = new LinkedList();
        _unsortedList.add("test");
        _unsortedList.add("driven");
        _unsortedList.add("development");
        _unsortedList.add("is");
        _unsortedList.add("one");
        _unsortedList.add("small");
        _unsortedList.add("step");
        _unsortedList.add("for");
        _unsortedList.add("a");
        _unsortedList.add("development");
        _unsortedList.add("but");
        _unsortedList.add("it's");
        _unsortedList.add("one");
        _unsortedList.add("giant");
        _unsortedList.add("leap");
        _unsortedList.add("for");
        _unsortedList.add("programming");
        _sortedList = new LinkedList();
        _sortedList.add("a");
        _sortedList.add("but");
        _sortedList.add("development");
        _sortedList.add("development");
        _sortedList.add("driven");
        _sortedList.add("for");
        _sortedList.add("for");
        _sortedList.add("giant");
        _sortedList.add("is");
        _sortedList.add("it's");
        _sortedList.add("leap");
        _sortedList.add("one");
        _sortedList.add("one");
        _sortedList.add("programming");
        _sortedList.add("small");
        _sortedList.add("step");
        _sortedList.add("test");
    }

    protected void tearDown() throws Exception {
        _sortedList = null;
        _unsortedList = null;
    }

    protected abstract ListSorter createListSorter(Comparator comparator);

    public void testListSorterCanSortSampleList() {
        ListSorter sorter = createListSorter(NaturalComparator.INSTANCE);
        List result = sorter.sort(_unsortedList);
        assertEquals(result.size(), _sortedList.size());
        Iterator actual = result.iterator();
        actual.first();
        Iterator expected = _sortedList.iterator();
        expected.first();
        assertFalse(expected.isDone());
        assertSame(expected.current(), actual.current());
        actual.next();
        expected.next();
        assertSame(expected.current(), actual.current());


    }


}