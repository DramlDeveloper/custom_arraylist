package custom_classes_java_core.util;

import java.util.Comparator;

/**
 * Динамически класс, в котором реализованы методы для быстрой сортировки
 * Среднее время работы быстрой сортировки составляет O(n log n)
 */
public final class Sorted {

    private Sorted() {
        throw new RuntimeException();
    }

    /**
     * Сортирует заданный {@link CustomArrayList} с помощью алгоритма быстрой сортировки
     * используя естественный порядок элементов {@link Comparable}.
     *
     * @param list выводит список {@link CustomArrayList} для сортировки.
     * @param <T> Тип элементов в списке.
     */
    public static <T> void quickSort(CustomArrayList<T> list, Comparator<T> comparator) {
        qSort(list, comparator, 0, list.size() - 1);
    }

    public static <T extends Comparable<T>> void quickSort(CustomArrayList<T> list) {
        qSort(list, Comparator.naturalOrder(), 0, list.size() - 1);
    }

    private static <T> void qSort(CustomArrayList<T> list, Comparator<T> comparator, int left, int right) {
        if (left < right) {
            int pivot = partition(list, comparator, left, right);
            qSort(list, comparator, left, pivot);
            qSort(list, comparator, pivot + 1, right);
        }
    }

    private static <T> int partition(CustomArrayList<T> list, Comparator<T> comparator, int left, int right) {
        T pivot = list.get((left + right) / 2);
        while (left <= right) {
            while (comparator.compare(list.get((left)), pivot) < 0) {
                left++;
            }
            while (comparator.compare(list.get((right)), pivot) > 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(list, left++, right--);
        }
        return right;
    }

    private static <T> void swap(CustomArrayList<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }


}