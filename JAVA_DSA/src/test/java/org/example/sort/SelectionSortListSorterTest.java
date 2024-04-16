package org.example.sort;

public class SelectionSortListSorterTest extends AbstractListSorterTest{

    protected ListSorter createListSorter(Comparator comparator) {

        return new SelectionSortListSorter(comparator);
    }
}
