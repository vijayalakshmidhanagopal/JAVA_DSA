package org.example.search;
import org.example.sort.Comparator;

public class IterativeBinaryListSearcherTest extends  AbstractListSearcherTestCase{

    protected ListSearcher createSearcher(Comparator comparator) {

        return new IterativeBinaryListSearcher(comparator);
    }
}
