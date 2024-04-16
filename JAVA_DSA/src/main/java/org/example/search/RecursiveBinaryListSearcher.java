package org.example.search;
import org.example.sort.Comparator;
import org.example.list.List;

public class RecursiveBinaryListSearcher implements ListSearcher {
    private final Comparator _comparator;

    public RecursiveBinaryListSearcher(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }
    public int search(List list, Object key) {
        assert list != null : "list can't be null";
        return searchRecursively(list, key, 0, list.size() - 1);
    }
    private int searchRecursively(List list, Object key, int lowerIndex, int upperIndex) {
        assert list != null : "list can't be null";
        if (lowerIndex > upperIndex) {
            return -(lowerIndex + 1);
        }
        int index = lowerIndex + (upperIndex - lowerIndex) / 2;
        int cmp = _comparator.compare(key, list.get(index));
        if (cmp < 0) {
            index = searchRecursively(list, key, lowerIndex, index - 1);
        } else if (cmp > 0) {
            index = searchRecursively(list, key, index + 1, upperIndex);
        }
        return index;
    }


}
