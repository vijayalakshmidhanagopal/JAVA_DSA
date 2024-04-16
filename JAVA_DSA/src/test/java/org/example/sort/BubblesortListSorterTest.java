package org.example.sort;

public class BubblesortListSorterTest extends AbstractListSorterTest{
    protected  ListSorter createListSorter(Comparator comparator) {

        return new BubblesortListSorter(comparator);
    }

}
