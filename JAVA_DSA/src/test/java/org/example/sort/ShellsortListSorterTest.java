package org.example.sort;

public class ShellsortListSorterTest extends AbstractListSorterTest{
    protected final ListSorter createListSorter(Comparator comparator) {
        return new ShellsortListSorter(comparator);
    }
}
