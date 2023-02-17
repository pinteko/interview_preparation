package com.korsuk.algorithms.array;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class MyArray<E> extends AbstractList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private static final Object[] EMPTY_LIST = {};
    private Object[] myList;
    private int size = 0;

    public MyArray() {
        myList = EMPTY_LIST;
    }

    public MyArray(int capacity) {
        if (capacity > 0) {
            myList = new Object[capacity];
        }
        else if (capacity == 0) {
            myList = EMPTY_LIST;
        }
        else {
            throw new IllegalArgumentException("Wrong capacity!");
        }
    }

    private void addInList(E e, Object[] o, int s) {
        if (size == myList.length) {
            myList = changeCapacity();
        }
        myList[size] = e;
        size = s + 1;
    }

    public boolean addInList(E e) {
        addInList(e, myList, size);
        return true;
    }

    private void removeFromMyList(int index) {
        int newSize = size - 1;
        if (index == newSize) {
            myList[index] = null;
        }
        else {
            System.arraycopy(myList, index + 1, myList, index, newSize - index);
        }
    }

    public boolean removeFromList(int index) {
        if (index >= 0 && index < size) {
            removeFromList(index);
            return true;
        }
        return false;
    }

    private Object[] changeCapacity() {
        int oldCapacity = myList.length;
        if (oldCapacity > 0) {
            int newCapacity = oldCapacity + DEFAULT_CAPACITY;
            return myList = Arrays.copyOf(myList, newCapacity);
        }
        else {
            return myList = new Object[DEFAULT_CAPACITY];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return (E) myList[index];
    }
}
