package org.example.tst;

import junit.framework.TestCase;
import org.example.list.LinkedList;
import org.example.list.List;

public class TernarySearchTreeTest extends TestCase {
    private TernarySearchTree _tree;

    protected void setUp() throws Exception {
        super.setUp();
        _tree = new TernarySearchTree();
        _tree.add("prefabricate");
        _tree.add("presume");
        _tree.add("prejudice");
        _tree.add("preliminary");
        _tree.add("apple");
        _tree.add("ape");
        _tree.add("appeal");
        _tree.add("car");
        _tree.add("dog");
        _tree.add("cat");
        _tree.add("mouse");
        _tree.add("mince");
        _tree.add("minty");
    }

    public void testContains() {
        assertTrue(_tree.contains("prefabricate"));
        assertTrue(_tree.contains("presume"));
        assertTrue(_tree.contains("prejudice"));
        assertTrue(_tree.contains("preliminary"));
        assertTrue(_tree.contains("apple"));
        assertTrue(_tree.contains("ape"));
        assertTrue(_tree.contains("appeal"));
        assertTrue(_tree.contains("car"));
        assertTrue(_tree.contains("dog"));
        assertTrue(_tree.contains("cat"));
        assertTrue(_tree.contains("mouse"));
        assertTrue(_tree.contains("mince"));
        assertTrue(_tree.contains("mince"));
        assertFalse(_tree.contains("pre"));
        assertFalse(_tree.contains("dogs"));
        assertFalse(_tree.contains("cats"));
    }

    public void testPrefixSearch() {
        assertPrefixEquals(new String[]{"prefabricate", "prejudice", "preliminary", "presume"}, "pre");
        assertPrefixEquals(new String[]{"ape", "appeal", "apple"}, "ap");
    }

    public void testPatternMatch() {
        assertPatternMatch(new String[]{"mince", "mouse"}, "m???e");
        assertPatternMatch(new String[]{"car", "cat"}, "?a?");
    }

    private void assertPrefixEquals(String[] expected, String prefix) {
        List words = new LinkedList();
        _tree.prefixSearch(prefix, words);
        assertEquals(expected, words);

    }

    private void assertPatternMatch(String[] expected, String pattern) {
        List words = new LinkedList();
        _tree.patternMatch(pattern, words);
        assertEquals(expected, words);
    }

    private void assertEquals(String[] expected, List actual) {
        assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }
}
