package org.example.search;
import org.example.sort.Comparator;

public class LinearListSearcherTest extends AbstractListSearcherTestCase {
    protected ListSearcher createSearcher(Comparator comparator) {
        return new LinearListSearcher(comparator);

    }
}
