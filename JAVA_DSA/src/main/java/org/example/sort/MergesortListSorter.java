package org.example.sort;
import org.example.list.List;
import org.example.iteration.Iterator;
import org.example.list.ArrayList;

public class MergesortListSorter implements ListSorter {
    private final Comparator _comparator;

    public MergesortListSorter(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }

    public List sort(List list) {
        assert list != null : "list can't be null";
        return mergesort(list, 0, list.size() - 1);
    }

    private List mergesort(List list, int startIndex, int endIndex) {
        if (startIndex == endIndex) { //base case
            List result = new ArrayList();
            result.add(list.get(startIndex));
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        List left = mergesort(list, startIndex, splitIndex); //recursive call
        List right = mergesort(list, splitIndex + 1, endIndex); //recursive call
        return merge(left, right);
    }

    private List merge(List left, List right) {
        List result = new ArrayList();
        Iterator l = left.iterator();
        Iterator r = right.iterator();
        l.first();
        r.first();
        while (!(l.isDone() && r.isDone())) {
            if (l.isDone()) {
                result.add(r.current());
                r.next();
            } else if (r.isDone()) {
                result.add(l.current());
                l.next();
            } else if (_comparator.compare(l.current(), r.current()) <= 0) {
                result.add(l.current());
                l.next();
            } else {
                result.add(r.current());
                r.next();
            }
        }
        return result;
    }
}
