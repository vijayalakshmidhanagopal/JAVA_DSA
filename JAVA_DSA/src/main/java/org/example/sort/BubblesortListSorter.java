package org.example.sort;
import org.example.list.List;

public class BubblesortListSorter implements ListSorter{
    private final Comparator _comparator;
    public BubblesortListSorter(Comparator comparator) {
        assert comparator != null :"comparator can't be null";
        _comparator = comparator;
    }
    public List sort(List list) {
        assert list != null :"list can't be null";
        int size = list.size();
        for (int pass = 1; pass < size; ++pass) {
            for (int left = 0; left < (size - pass); ++left) {
                int right = left + 1;
                if (_comparator.compare(list.get(left), list.get(right)) > 0) {
                    swap(list, left, right);
                }
            }
        }
        return list;
    }
    private void swap(List list, int left, int right) {
        Object temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}

