package org.example.hashtable;

public class LinearProbingHashtableTest extends AbstractHashtableTestCase{
    protected Hashtable createTable(int capacity){
        return new LinearProbingHashtable(capacity);
    }
}
