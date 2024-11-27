package custom_classes_java_core.util;

import custom_classes_java_core.CheckClassByQuickSort;
import org.junit.Test;

import java.util.Random;


public class CheckCustomArrayList<T> {

    @Test
    public void checkGetElement() {
        CustomArrayList<T> customArrayList = fullArrayList(10000);
        customArrayList.get(1000);
    }

    @Test
    public void checkExceptionGetElementOutIncrement() {
        try {
            fullArrayList(10).get(200);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkExceptionGetElementOutDecrement() {
        try {
            fullArrayList(10).get(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkAddInsert() {
        CustomArrayList<T> customArrayList = fullArrayList(5);
        System.out.println(customArrayList);
        customArrayList.add(4, "Alex");
        System.out.println(customArrayList);

    }

    @Test
    public  void checkAdd() {
        CustomArrayList<T> customArrayList = fullArrayList(200000);
        System.out.println(customArrayList);
    }

    @Test
    public  void checkRemove() {
        CustomArrayList<T> customArrayList = fullArrayList(10000);
        customArrayList.remove(2);
    }

    @Test
    public void checkExceptionRemoveOutIncrement() {
        try {
            fullArrayList(1).remove(20);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkExceptionRemoveOutDecrement() {
        try {
            fullArrayList(1).remove(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkClear() {
        CustomArrayList<T> customArrayList = fullArrayList(10000);
        customArrayList.clear();
        System.out.println(customArrayList);
    }

    @Test
    public void checkSet() {
        try {
            CustomArrayList<T> customArrayList = fullArrayList(20);
            customArrayList.set(2, "tes10");
            customArrayList.set(3, 56);
            customArrayList.set(100, new CustomArrayList<T>());
            System.out.println(customArrayList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

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