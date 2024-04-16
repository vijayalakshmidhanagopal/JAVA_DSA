package org.example.sort;

public class InsertionSortListSorterTest extends AbstractListSorterTest{
    protected final ListSorter createListSorter(Comparator comparator){
        return new InsertionSortListSorter(comparator);
    }
}
