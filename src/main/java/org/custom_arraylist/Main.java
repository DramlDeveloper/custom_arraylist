package org.custom_arraylist;

import org.custom_arraylist.util.CustomArrayList;

import java.util.Arrays;

public class Main {

    public static CustomArrayList fullArrayList(int countIteration) {
        CustomArrayList customArrayList = new CustomArrayList();
        for (int i = 0; i < countIteration; i++) {
            customArrayList.add(i);
            customArrayList.add("test");
            customArrayList.add(new CustomArrayList());
        }
        return customArrayList;
    }

    public static void main(String[] args) {
        CustomArrayList customArrayList = fullArrayList(10);
        customArrayList.remove(0);
        System.out.println(customArrayList);


    }
}