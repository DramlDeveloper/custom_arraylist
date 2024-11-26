package org.example;


import org.example.util.CustomArrayList;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        CustomArrayList customArrayList = new CustomArrayList();
        ArrayList arrayList = new ArrayList();

        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add(2);
        arrayList.clear();
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        for (int i = 0; i < 10; i++) {

            customArrayList.add("Hello");
            customArrayList.add("World");
            customArrayList.add("Java");
            customArrayList.add("Python");
            customArrayList.add(7);
        }

        int count = 0;
        customArrayList.remove(2);




        System.out.println(customArrayList);
        System.out.println(customArrayList.size());

try {
    customArrayList.clear();
}catch (Exception e){
    System.out.println(e);
}finally {
    System.out.println("cleared");
}

        System.out.println(customArrayList);

        //       System.out.println(customArrayList.get(2));
    }
}