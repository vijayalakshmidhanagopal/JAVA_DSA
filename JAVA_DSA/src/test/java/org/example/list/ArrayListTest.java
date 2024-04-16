package org.example.list;

public class ArrayListTest extends AbstractListTestCase{
    protected List createList() {
        return new ArrayList();
    }
    public void testResizeBeyondInitialCapacity() {
        List list = new ArrayList(1);
        list.add(VALUE_A);
        list.add(VALUE_A);
        list.add(VALUE_A);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_A, list.get(1));
        assertSame(VALUE_A, list.get(2)); }
    public void testDeleteFromLastElementInArray() {

        List list = new ArrayList(1);
        list.add(new Object());
        list.delete(0);
    }
}
