package org.example.util;


import java.util.Arrays;

public class CustomArrayList {
    private final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private final int DEFAULT_CAPACITY = 10;

    private Object[] array;
    private int size = 0;

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

    public void add(int index, Object element) {

        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.array) .length)
            elementData = grow(size + 1);
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = array.length;
        if (oldCapacity > 0 || array != DEFAULTCAPACITY_EMPTY_ELEMENTDATA ) {
            int newCapacity = newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return array = Arrays.copyOf(array, newCapacity);
        } else {
            return array = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    public static int newLength(int oldLength, int minGrowth, int prefGrowth) {

        int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
        if (0 < prefLength && prefLength <= Integer.MAX_VALUE - 8) {
            return prefLength;
        } else {
            return hugeLength(oldLength, minGrowth);
        }
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) { // overflow
            throw new OutOfMemoryError(
                    "Required array length " + oldLength + " + " + minGrowth + " is too large");
        } else if (minLength <= Integer.MAX_VALUE - 8) {
            return Integer.MAX_VALUE - 8;
        } else {
            return minLength;
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void set(int index, Object o) throws IndexOutOfBoundsException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = o;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
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