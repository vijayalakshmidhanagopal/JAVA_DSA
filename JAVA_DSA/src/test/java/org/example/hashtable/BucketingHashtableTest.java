package org.example.hashtable;

public class BucketingHashtableTest extends  AbstractHashtableTestCase{
    protected Hashtable createTable(int capacity){

        return new BucketingHashtable(capacity,0.75f);
    }
}
