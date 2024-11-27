package custom_classes_java_core.util;



/**
 * Обработчик исключений
 */
public final class ValidationOutIndex {

    private ValidationOutIndex() {
        throw new RuntimeException();
    }

    public static void validation(int index, int size) {
        if (index < 0)
            throw new IndexOutOfBoundsException("IndexException: значение индекса не может быть меньше 0");
        if (index >= size)
            throw new IndexOutOfBoundsException("IndexException: значение индекса превышает размер массива");
    }
}
