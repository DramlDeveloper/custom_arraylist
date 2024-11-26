package org.example.util;

import java.util.Arrays;

public class CustomArrayList {

    public Object[] array;
    int size = 0;

    public Object[] getArray() {
        return array;
    }

    public CustomArrayList() {
        array = new Object[10];
    }

    public int size() {
        return size;
    }

    public void add(Object o) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = o;
    }

    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void set(int index, Object o) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = o;
    }

    public void remove(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = null;
    }

    public void clear() {
        array = new Object[size()];
    }

    @Override
    public String toString() {
        int iMax = array.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < size; i++) {
            b.append(array[i]);
            if (i == size - 1)
                return b.append(']').toString();
            b.append(", ");
        }
        return b.append(']').toString();
    }

}
