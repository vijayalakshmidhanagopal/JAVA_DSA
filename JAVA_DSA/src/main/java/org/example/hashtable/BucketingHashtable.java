package org.example.hashtable;
import org.example.list.List;
import org.example.list.LinkedList;
import org.example.iteration.Iterator;

public class BucketingHashtable implements Hashtable{
    private final float _loadFactor;
        private List[] _buckets;
        private int _size;
        public BucketingHashtable(int initialCapacity, float loadFactor) {
            assert initialCapacity > 0 :"initial capacity can't < 1";
            assert loadFactor > 0 : "loadfactor can't < 0";
            _loadFactor = loadFactor;
            _buckets = new List[initialCapacity];
        }
        public void add(Object value) {
            List bucket = bucketFor(value);
            if (!bucket.contains(value)) {
                bucket.add(value);
                ++_size;
                maintainLoad();
            }
        }
        public boolean contains(Object value) {
            List bucket = _buckets[bucketIndexFor(value)];
            return bucket != null && bucket.contains(value);
        }

        public int size() {
            return _size;
        }
        private List bucketFor(Object value) {
            int bucketIndex = bucketIndexFor(value);
            List bucket = _buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList();
                _buckets[bucketIndex] = bucket;
            }
            return bucket;
        }
        private int bucketIndexFor(Object value) {
            assert value != null : "values can't be null";
            return Math.abs(value.hashCode() % _buckets.length);
        }
        private void maintainLoad() {
            if (loadFactorExceeded()) {
                resize();
            }
        }
        private boolean loadFactorExceeded() {
            return size() > _buckets.length * _loadFactor;
        }
        private void resize() {
            BucketingHashtable copy = new BucketingHashtable(_buckets.length * 2, _loadFactor);
            for (int i = 0; i < _buckets.length; ++i) {
                if (_buckets[i] != null) {
                    copy.addAll(_buckets[i].iterator());
                }
            }
            _buckets = copy._buckets;
        }
        private void addAll(Iterator values) {
            assert values != null : "values can't be null";
            for (values.first(); !values.isDone(); values.next()) {
                add(values.current());
            }
        }
    public Iterator iterator() {
        return new HashtableIterator(_buckets);
    }
}
