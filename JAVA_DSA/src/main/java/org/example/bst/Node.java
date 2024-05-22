package org.example.bst;

public class Node {
    private Object _value;
    private Node _parent;
    private Node _smaller;
    private Node _larger;

    public Node(Object value) {
        this(value, null, null);
    }
    public Node(Object value, Node smaller, Node larger) {
        setValue(value);
        setSmaller(smaller);
        setLarger(larger);
        if (smaller != null) {
            smaller.setParent(this);
        }
        if (larger != null) {
            larger.setParent(this);
        }
    }
    public Object getValue()
    {
        return _value;
    }
    public void setValue(Object value) {
        assert value != null : "value can't be null";
        _value = value;
    }
    public Node getParent()
    {
        return _parent;
    }
    public void setParent(Node parent)
    {
        _parent = parent;
    }
    public Node getSmaller() {

        return _smaller;
    }
    public void setSmaller(Node smaller) {
        if (isAncestor(smaller)) {
            throw new IllegalArgumentException("Setting smaller child would create a cycle.");
        }
        _smaller = smaller;
    }
    public void setLarger(Node larger) {
        if (isAncestor(larger)) {
            throw new IllegalArgumentException("Setting larger child would create a cycle.");
        }
        _larger = larger;
    }

    public Node getLarger() {
        return _larger;
    }

    private boolean isAncestor(Node node) {
        Node ancestor = this.getParent();
        while (ancestor != null) {
            if (ancestor == node) {
                return true;
            }
            ancestor = ancestor.getParent();
        }
        return false;
    }


    public boolean isSmaller() {
        return getParent() != null && this == getParent().getSmaller();
    }

    public boolean isLarger() {
        return getParent() != null && this == getParent().getLarger();
    }
    public Node minimum() {
        Node node = this;
        while (node.getSmaller() != null) {
            node = node.getSmaller();
        }
        return node;
    }
    public Node maximum() {
        Node node = this;
        while (node.getLarger() != null) {
            node = node.getLarger();
        }
        return node;
    }

    public Node successor() {
        if (getLarger() != null) {
            return getLarger().minimum();
        }
        Node parent = getParent();
        Node current = this;
        while (parent != null && current == parent.getLarger()) {
            current = parent;
            parent = parent.getParent();
        }
        return parent;
    }


    public Node predecessor() {
        if (getSmaller() != null) {
            return getSmaller().maximum();
        }
        Node parent = getParent();
        Node current = this;
        while (parent != null && current == parent.getSmaller()) {
            current = parent;
            parent = parent.getParent();
        }
        return parent;
    }
    public int size() {
        return size(this);
    }
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != getClass()) {
            return false;
        }
        Node other = (Node) object;
        return getValue().equals(other.getValue())
                && equalsSmaller(other.getSmaller())
                && equalsLarger(other.getLarger());
    }
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getSmaller()) + size(node.getLarger());
    }
    private boolean equalsSmaller(Node other) {
        return getSmaller() == null && other == null
                || getSmaller() != null && getSmaller().equals(other);
    }
    private boolean equalsLarger(Node other) {
        return getLarger() == null && other == null
                || getLarger() != null && getLarger().equals(other);
    }

}
