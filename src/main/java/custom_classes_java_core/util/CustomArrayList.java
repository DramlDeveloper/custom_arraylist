package custom_classes_java_core.util;


import java.util.Arrays;

/**
 * Динамически массив с различными вспомогательными методами
 *
 * @param <T> тип элементов в этом списке
 */
public class CustomArrayList<T> {

    private T[] array;
    private int size = 0;

    public static final int DEFAULT_CAPACITY = 10;

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
        validation(index, size());
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
        validation(index, size());
        return array[index];
    }

    /**
     * Метод заменяющий элемент массива по установленному индексу
     *
     * @param index индекс массива
     * @param value новое значение элемента массива
     */
    public void set(int index, Object value)  {
        validation(index, size());
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
     * Обработка исключения при выходе за пределы размера массива
     * @param index - запрашиваемы индекс в массиве
     * @param size - размер массива
     */
    public void validation(int index, int size) {
        if (index < 0)
            throw new IndexOutOfBoundsException("IndexException: значение индекса не может быть меньше 0");
        if (index >= size)
            throw new IndexOutOfBoundsException("IndexException: значение индекса превышает размер массива");
    }

}