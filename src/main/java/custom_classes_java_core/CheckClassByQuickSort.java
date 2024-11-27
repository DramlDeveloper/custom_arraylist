package custom_classes_java_core;


public class CheckClassByQuickSort {

    private int count;
    private String name = "Default Name";

    public CheckClassByQuickSort() {
    }

    public CheckClassByQuickSort(int count) {
        this.count = count;
    }

    public CheckClassByQuickSort(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "count: " + count + ", name: " + name;
    }
}