package com.nlp.basic.tools.algorithm.chapter1;

import com.nlp.basic.tools.stdlib.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CopyOfStack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        Node() {
        }

        Node(Node x) {
            item = (Item) x.item;
            if (x.next != null) next = new Node(x.next);
        }
    }

    public CopyOfStack(CopyOfStack<Item> s) {
        first = new Node<>(s.first);
    }

    public CopyOfStack() {
        first = null;
        n = 0;
    }

//    public CopyOfStack(Stack<Item> s) {
//        for (Item item : s) {
//            this.push(item);
//        }
//    }


    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("Queue overflow");
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
