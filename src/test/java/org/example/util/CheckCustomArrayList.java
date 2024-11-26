package org.example.util;

import org.junit.Test;


public class CheckCustomArrayList {


    @Test
    public void checkIndexOutOfBoundsExceptionRemove() {
        try {
            fullArrayList(1).remove(20);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkIndexOutOfBoundsExceptionGetElementCustomArrayList() {
        try {
            fullArrayList(1000).get(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkIndexOutOfBoundsExceptionGetElement() {
        CustomArrayList customArrayList = fullArrayList(10000);
        try {
            customArrayList.get(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkGetElement() {
        CustomArrayList customArrayList = fullArrayList(10000);
        customArrayList.get(1000);
    }

    @Test
    public void checkAddInsert() {
        CustomArrayList customArrayList = fullArrayList(10);
        customArrayList.add(16, "Aleks");
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
    public void checkClear() {
        CustomArrayList customArrayList = fullArrayList(10000);
        customArrayList.clear();
    }

    @Test
    public void checkSet() {
        CustomArrayList customArrayList = fullArrayList(10000);
        customArrayList.set(2, "tes10");
        customArrayList.set(3, 56);
        System.out.println(customArrayList);
    }


    public CustomArrayList fullArrayList(int countIteration) {
        CustomArrayList customArrayList = new CustomArrayList();
        for (int i = 0; i < countIteration; i++) {
            customArrayList.add(i);
            customArrayList.add("test");
            customArrayList.add("test1");
            customArrayList.add("test2");
            customArrayList.add("test3");
            customArrayList.add(new CustomArrayList());
        }
        return customArrayList;
    }
}
