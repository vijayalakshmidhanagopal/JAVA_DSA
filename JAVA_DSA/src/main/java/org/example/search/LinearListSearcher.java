package org.example.search;
import org.example.list.List;
import org.example.sort.Comparator;
import org.example.iteration.Iterator;

public class LinearListSearcher implements ListSearcher{
    private final Comparator _comparator;
    public LinearListSearcher(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }
    public int search(List list, Object key) {
        assert list != null :"list can't be null";
        int index = 0;
        Iterator i = list.iterator();
        for (i.first(); !i.isDone(); i.next()) {
            int cmp = _comparator.compare(key, i.current());
            if (cmp == 0) {
                return index;
            } else if (cmp < 0) {
                break;
            }
            ++index;
        }
        return -(index + 1);
    }
}
