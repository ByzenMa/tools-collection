package com.nlp.basic.tools.algorithm.chapter1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackToQueue<Item> implements Iterable<Item> {
    private Stack<Item> pushStack;
    private Stack<Item> popStack;
    private int size;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }


    class Stack<Item> implements Iterable<Item> {
        private Node<Item> first;
        private int size;


        public Stack() {
            first = null;
            size = 0;
        }


        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(Item item) {
            Node<Item> oldFirst = first;
            first = new Node<>();
            first.item = item;
            first.next = oldFirst;
            size++;
        }

        public Item pop() {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
            Item item = first.item;
            first = first.next;
            size--;
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

            public ListIterator(Node<Item> node) {
                this.current = node;
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
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

    public StackToQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        pushStack.push(item);
        size++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        size--;
        return popStack.pop();
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        if (popStack.isEmpty()) {
            for (Item item : pushStack) {
                popStack.push(item);
            }
        }
        return popStack.peek();
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Item item : this) {
            b.append(item);
            b.append(' ');
        }
        return b.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(pushStack, popStack);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Stack<Item> reversePushStack;
        private Node<Item> current;

        public ListIterator(Stack<Item> pushStack, Stack<Item> popStack) {
            reversePushStack = new Stack<>();
            for (Item item : pushStack) {
                reversePushStack.push(item);
            }
            current = popStack.first;
        }

        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            if (current == null) current = reversePushStack.first;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
