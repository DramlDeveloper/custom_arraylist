package org.custom_arraylist.util;

import org.junit.Test;

import java.util.Comparator;


public class CheckCustomArrayList {


    @Test
    public void checkQuickSortString() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Ivan");
        list.add("Aleks");
        list.add("Alex");
        list.add("Danila");
        list.add("Helen");
        Sorted.quickSort(list);
        System.out.println(list);
    }

    @Test
    public void checkQuickSortInteger() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        for (int i = 9; i > 0; i--) {
            list.add(i);
        }
        Sorted.quickSort(list, Comparator.naturalOrder());
        System.out.println(list);
    }

    @Test
    public void checkGetElement() {
        CustomArrayList customArrayList = fullArrayList(10000);
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
        CustomArrayList customArrayList = fullArrayList(5);
        System.out.println(customArrayList);
        customArrayList.add(4, "Alex");
        System.out.println(customArrayList);

    }

    @Test
    public void checkAdd() {
        CustomArrayList customArrayList = fullArrayList(200000);
        System.out.println(customArrayList);
    }

    @Test
    public void checkRemove() {
        CustomArrayList customArrayList = fullArrayList(10000);
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
        CustomArrayList customArrayList = fullArrayList(10000);
        customArrayList.clear();
        System.out.println(customArrayList);
    }

    @Test
    public void checkSet() {
        try {
            CustomArrayList customArrayList = fullArrayList(20);
            customArrayList.set(2, "tes10");
            customArrayList.set(3, 56);
            customArrayList.set(100, new CustomArrayList());
            System.out.println(customArrayList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }


    public CustomArrayList fullArrayList(int countIteration) {
        CustomArrayList customArrayList = new CustomArrayList();
        for (int i = 0; i < countIteration; i++) {
            customArrayList.add(i);
            customArrayList.add("test");
            customArrayList.add(new CustomArrayList());
        }
        return customArrayList;
    }
}