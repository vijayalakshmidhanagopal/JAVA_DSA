package org.example.sort;

public final class NaturalComparator implements Comparator {
    public static final NaturalComparator INSTANCE = new NaturalComparator();

    private NaturalComparator() {
    }


    public int compare(Object left, Object right) {
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";

        if (!(left instanceof java.lang.Comparable)) {

            return left.toString().compareTo(right.toString());
        }

        return ((java.lang.Comparable) left).compareTo(right);
    }
}


