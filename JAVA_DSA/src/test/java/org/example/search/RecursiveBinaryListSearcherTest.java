package org.example.search;
import org.example.sort.Comparator;

public class RecursiveBinaryListSearcherTest extends AbstractListSearcherTestCase {
    protected ListSearcher createSearcher(Comparator comparator) {
        return new RecursiveBinaryListSearcher(comparator);
    }

}
