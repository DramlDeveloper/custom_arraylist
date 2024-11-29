package custom_classes_java_core.util;

import custom_classes_java_core.CheckClassByQuickSort;
import org.junit.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckCustomArrayList<T> {

    @Test
    public void checkExceptionIndexOutIncrement() {
        Throwable throwable = assertThrows(
                Throwable.class,
                () -> {
                    fullArrayList(10).get(100);
                    fullArrayList(10).remove(100);
                }
        );
        assertEquals(IndexOutOfBoundsException.class, throwable.getClass());
    }

    @Test
    public void checkExceptionIndexOutDecrement() {
        Throwable throwable = assertThrows(
                Throwable.class,
                () -> {
                    fullArrayList(10).get(-1);
                    fullArrayList(10).remove(-1);
                }
        );
        assertEquals(IndexOutOfBoundsException.class, throwable.getClass());
    }

    @Test
    public void checkGetElement() {
        CustomArrayList<T> customArrayList = fullArrayList(10000);
        customArrayList.get(1000);
    }

    @Test
    public void checkAddInsert() {
        CustomArrayList<T> customArrayList = fullArrayList(5);
        customArrayList.add(4, "Alex");
    }

    @Test
    public void checkAdd() {
        CustomArrayList<T> customArrayList = fullArrayList(200000);
    }

    @Test
    public void checkRemove() {
        CustomArrayList<T> customArrayList = fullArrayList(10000);
        customArrayList.remove(2);
    }

    @Test
    public void checkClear() {
        CustomArrayList<T> customArrayList = fullArrayList(10000);
        customArrayList.clear();
    }

    @Test
    public void checkSet() {
            CustomArrayList<T> customArrayList = fullArrayList(20);
            customArrayList.set(2, "tes10");
            customArrayList.set(3, 56);
            customArrayList.set(10, new CustomArrayList<T>());
    }


    public CustomArrayList<T> fullArrayList(int countIteration) {
        CustomArrayList<T> customArrayList = new CustomArrayList<>();
        Random random = new Random();
        for (int i = 0; i < countIteration; i++) {
            customArrayList.add(random.nextInt(10000));
            customArrayList.add("test");
            customArrayList.add(new CheckClassByQuickSort(random.nextInt(10000)));
        }
        return customArrayList;
    }
}