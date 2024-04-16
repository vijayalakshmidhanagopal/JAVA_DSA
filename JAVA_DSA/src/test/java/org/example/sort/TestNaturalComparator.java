package org.example.sort;
import junit.framework.TestCase;

public class TestNaturalComparator extends TestCase {
    public void testLessThan() {
        assertTrue(NaturalComparator.INSTANCE.compare("A", "B") < 0);
    }

    public void testGreaterThan()
    {
        assertTrue(NaturalComparator.INSTANCE.compare("B", "A") > 0);
    }

    public void testEqualTo()
    {
        assertTrue(NaturalComparator.INSTANCE.compare("A", "A") == 0);
    }
}
