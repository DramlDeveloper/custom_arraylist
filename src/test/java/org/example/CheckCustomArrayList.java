import org.example.util.CustomArrayList;
import org.junit.Test;

public class CheckCustomArrayList {
    @Test
    public void checkAdd() {
        CustomArrayList customArrayList = new CustomArrayList();

        for (int i = 0; i < 10; i++) {
            customArrayList.add(i);
            customArrayList.add("test");
            customArrayList.add("test1");
            customArrayList.add("test2");
            customArrayList.add("test3");
            customArrayList.add(new CustomArrayList());

        }
    }
}
