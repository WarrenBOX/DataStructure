package listDemo;

import com.tunbobo.LinkedList.SUM.reverse.ReverseDemo;
import org.junit.Test;

public class ListTest {
    @Test
    public void listTest() {
        ReverseDemo list = new ReverseDemo();
        list.add(5);
        list.add(7);
        list.add(8);
//        System.out.println(list);

        list.reverse(list);
        list.print(list);
        System.out.println(list);
    }
}
