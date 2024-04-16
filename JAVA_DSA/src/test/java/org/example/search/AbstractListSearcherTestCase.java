package org.example.search;

import junit.framework.TestCase;
import org.example.list.List;
import org.example.sort.Comparator;
import org.example.list.ArrayList;
import org.example.sort.NaturalComparator;

public abstract class AbstractListSearcherTestCase extends TestCase {
    private static final Object[] VALUES = {"B", "C", "D", "F", "H", "I", "J", "K", "L", "M", "P", "Q"};

    private ListSearcher _searcher;
    private List _list;

    protected abstract ListSearcher createSearcher(Comparator comparator);

    protected void setUp() throws Exception {
        super.setUp();
        _searcher = createSearcher(NaturalComparator.INSTANCE);
        _list = new ArrayList();
        for (Object value : VALUES) {
            _list.add(value);
        }
    }

    public void testSearchForExistingValues() {
        for (int i = 0; i < _list.size(); ++i) {
            assertEquals(i, _searcher.search(_list, _list.get(i)));
        }
    }

    public void testSearchForNonExistingValueLessThanFirstItem() {
        assertEquals(-1, _searcher.search(_list, "A"));
    }

    public void testSearchForNonExistingValueGreaterThanLastItem() {
        assertEquals(-13, _searcher.search(_list, "Z"));
    }

    public void testSearchForArbitraryNonExistingValue() {
        assertEquals(-4, _searcher.search(_list, "E"));
    }


}
