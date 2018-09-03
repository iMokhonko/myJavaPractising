package com.imokhonko;

import java.util.Iterator;

public class Users implements Iterable<String> {

    private Node head = null;
    private Node last = null;
    private int size = 0;

    public Users(String... values) {
        for (String value : values) {
            this.add ( value );
        }
    }

    public boolean add(String value) {
        if(size == 0) {
            this.head = new Node (value);
            last = this.head;
        } else {
            Node node = new Node (value);
            last.setNext (node);
            last = node;
            last.setNext (head);
        }
        size++;
        return true;
    }

    public Node get(int index) {
        if(index < 0 || index > size) { return last; }
        Node entry = head;
        for (int i = 0; i < index; i++) entry = entry.next;
        return entry;
    }

    public int getSize() {
        return size;
    }

    public Node getFirst() {
        return this.head;
    }

    public Node getLast() {
        return this.last;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String> () {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count != size;
            }

            @Override
            public String next() {
                return get (count++).value;
            }
        };
    }

    class Node {
        Node next;
        String value;
        public Node(String value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value;
        }
    }

}
