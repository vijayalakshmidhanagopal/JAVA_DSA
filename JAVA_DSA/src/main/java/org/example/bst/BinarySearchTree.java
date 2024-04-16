package org.example.bst;
import org.example.sort.Comparator;

public class BinarySearchTree {
    private final Comparator _comparator;
    private Node _root;
    public BinarySearchTree(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }
    public Node search(Object value) {
        assert value != null : "value can't be null";
        Node node = _root;
        while (node != null) {
            int cmp = _comparator.compare(value, node.getValue());
            if (cmp == 0) {
                break;
            }
            node = cmp < 0 ? node.getSmaller() : node.getLarger();
        }
        return node;
    }

    public Node insert(Object value) {
        Node parent = null;
        Node node = _root;
        int cmp = 0;
        while (node != null) {
            parent = node;
            cmp = _comparator.compare(value, node.getValue());
            node = cmp <= 0 ? node.getSmaller() : node.getLarger();
        }
        Node inserted = new Node(value);
        inserted.setParent(parent);
        if (parent == null) {
            _root = inserted;
        } else if (cmp < 0) {
            parent.setSmaller(inserted);
        } else {
            parent.setLarger(inserted);
        }
        return inserted;
    }
    public Node delete(Object value) {
        Node node = search(value);
        if (node == null) {
            return null;
        }
        Node deleted = node.getSmaller() != null && node.getLarger() != null ? node.successor() : node;
        assert deleted != null : "deleted can't be null";
        Node replacement = deleted.getSmaller() != null ? deleted.getSmaller() : deleted.getLarger();
        if (replacement != null) {
            replacement.setParent(deleted.getParent());
        }
        if (deleted == _root) {
            _root = replacement;
        } else if (deleted.isSmaller()) {
            deleted.getParent().setSmaller(replacement);
        } else {
            deleted.getParent().setLarger(replacement);
        }
        if (deleted != node) {
            Object deletedValue = node.getValue();
            node.setValue(deleted.getValue());
            deleted.setValue(deletedValue);
        }

        return deleted;
    }
    public Node getRoot() {
        return _root;
    }
}
