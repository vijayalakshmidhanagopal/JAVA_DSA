package org.example.sort;

public class MergesortListSorterTest extends AbstractListSorterTest{
    protected ListSorter createListSorter(Comparator comparator) {
        return new MergesortListSorter(comparator);
    }
}
