package com.imokhonko.Iterator;

import java.util.Iterator;

public class MyList<E> implements Iterable<E> {

    private final static int DEFAULT_ELEMENTS_SIZE = 10;
    private IterationOrder DEFAULT_ORDERING = IterationOrder.NATURAL;

    private int size = 0;
    private Object[] elements;

    public MyList(int size) {
        elements = new Object[size];
    }

    public MyList() {
        this(DEFAULT_ELEMENTS_SIZE);
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    private void ensureCapacity(int i) {
        if(i > elements.length) {
            Object[] newArray = new Object[elements.length + (elements.length >> 1)];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    public int getListCapacity() {
        return elements.length;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void setOrdering(IterationOrder iterationOrder) {
        this.DEFAULT_ORDERING = iterationOrder;
    }

    public Iterator<E> iterator() {
        switch(DEFAULT_ORDERING) {
            case NATURAL: {
                return new Iterator<E>() {
                    int count = 0;
                    public boolean hasNext() { return count < size; }
                    public E next() { return get(count++); }
                    public void remove() {}
                };
            }
            case REVERSE: {
                return new Iterator<E>() {
                    int count = size;
                    public boolean hasNext() { return count > 0; }
                    public E next() { return get(--count); }
                    public void remove() {}
                };
            }
            default: {
                throw new RuntimeException();
            }
        }
    }

    public enum IterationOrder {
        NATURAL,
        REVERSE;
    }

}
