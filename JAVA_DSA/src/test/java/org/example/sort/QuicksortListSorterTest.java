package org.example.sort;

public class QuicksortListSorterTest extends AbstractListSorterTest{
    protected ListSorter createListSorter(Comparator comparator) {
        return new QuicksortListSorter(comparator);
    }
}
