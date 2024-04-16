package org.example.iteration;

public  class FilterIterator implements Iterator {
    private final Iterator _iterator;
    private final Predicate _predicate;

    public FilterIterator(Iterator iterator, Predicate predicate) {
        assert iterator != null : "iterator can't be null";
        assert predicate != null : "predicate can't be null";
        _iterator = iterator;
        _predicate = predicate;
    }

    public boolean isDone() {
        return _iterator.isDone();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return _iterator.current();
    }

    public void first() {
        _iterator.first();
        filterForwards();
    }

    public void next() {
        _iterator.next();
        filterForwards();
    }

    private void filterForwards() {
        while (!_iterator.isDone() && !_predicate.evaluate(_iterator.current())) {
            _iterator.next();
        }
    }
    public void last() {
        _iterator.last();
        filterBackwards();
    }

    public void previous() {
        _iterator.previous();
        filterBackwards();
    }

    private void filterBackwards() {
        while (!_iterator.isDone() && !_predicate.evaluate(_iterator.current())) {
            _iterator.previous();
        }

    }
}
