package org.example.sort;
import org.example.list.List;
import org.example.list.LinkedList;
import org.example.iteration.Iterator;

public class InsertionSortListSorter implements ListSorter {
    private final Comparator _comparator;

    public InsertionSortListSorter(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }

    public List sort(List list) {
        assert list != null : "list can't be null";
        final List result = new LinkedList();
        Iterator it = list.iterator();
        for (it.first(); !it.isDone(); it.next()) { //o(n)
            int slot = result.size();
            while (slot > 0) {
                if (_comparator.compare(it.current(), result.get(slot - 1)) >= 0) {
                    break;
                }
                --slot;
            }
            result.insert(slot, it.current()); //o(n)
        }
        return result;

    }
}
