package custom_classes_java_core.util;


import java.util.Arrays;

import static custom_classes_java_core.util.ConstantValueUtil.*;

/**
 * Динамически массив с различными вспомогательными методами
 *
 * @param <T> тип элементов в этом списке
 */
public class CustomArrayList<T> {

    private T[] array;
    private int size = 0;

    public CustomArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * @return возвращает размер массива
     */
    public int size() {
        return size;
    }

    /**
     * @param value значение которое необходимо добавить в массив
     */
    public void add(Object value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = (T) value;
    }

    /**
     *  Метод позволяющий добавить элемент по индексу не заменяя
     *  имеющийся в массиве элемент
     *
     * @param index индекс в массиве, по которому добавляется элемент
     * @param element элемент, который добавляется в массив
     */

    public void add(int index, Object element) {
        final int s = size;
        System.arraycopy(array, index,
                array, index + 1,
                s - index);
        array[index] = (T) element;
        size++;
    }

    /**
     * Метод позволяющий удалить элемент по индексу с изменением
     * размера массива
     *
     * @param index индекс в массиве, по которому удаляется элемент
     */
    public void remove(int index) {
        ValidationOutIndex.validation(index, size());
        int s = size - index - 1;
        if (s > 0) {
            System.arraycopy(array, index + 1, array, index, s);
        }
        array[--size] = null;
    }

    /**
     * Метод возвращающий элемент массива по индексу
     *
     * @param index индекс возвращаемого элемента из массива
     */
    public T get(int index)  {
        ValidationOutIndex.validation(index, size());
        return array[index];
    }

    /**
     * Метод заменяющий элемент массива по установленному индексу
     *
     * @param index индекс массива
     * @param value новое значение элемента массива
     */
    public void set(int index, Object value)  {
        ValidationOutIndex.validation(index, size());
        array[index] = (T) value;
    }

    /**
     * Метод очищающий массив
     */
    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Переопределенный метод класса {@link Object}
     */
    public String toString() {
        if (array.length - 1 == -1)
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