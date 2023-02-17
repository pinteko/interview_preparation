package com.korsuk.algorithms.linked;


import java.util.*;

public class MyLinked<E> extends AbstractSequentialList<E>
        implements List<E> {

    transient int size = 0;
    transient MyNode<E> first;
    transient MyNode<E> last;

    public MyLinked() {
    }

    private void linkFirst(E e) {
        final MyNode<E> f = first;
        final MyNode<E> newNode = new MyNode<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    void linkLast(E e) {
        final MyNode<E> l = last;
        final MyNode<E> newNode = new MyNode<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private static class MyNode<E> {
        E item;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
