package custom_classes_java_core.util;

import custom_classes_java_core.CheckClassByQuickSort;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

public class CheckQuickSort {

    @Test
    public void checkQuickSortString() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Ivan");
        list.add("Aleks");
        list.add("Alex");
        list.add("Danila");
        list.add("Helen");
        QuickSortUtil.quickSort(list);
    }

    @Test
    public void checkQuickSortInteger() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        for (int i = 9; i > 0; i--) {
            list.add(i);
        }
        QuickSortUtil.quickSort(list, Comparator.naturalOrder());
    }

    @Test
    public void checkQuickSortObject() {
        CustomArrayList<CheckClassByQuickSort> list = new CustomArrayList<>();
        Random value = new Random();
        for (int i = 0; i < 10000; i++) {
            int count  = value.nextInt(30000);
            list.add(new CheckClassByQuickSort(count));
        }
        QuickSortUtil.quickSort(list, Comparator.comparing(CheckClassByQuickSort::getCount));
        QuickSortUtil.quickSort(list, Comparator.comparing(CheckClassByQuickSort::getName));
    }
}
