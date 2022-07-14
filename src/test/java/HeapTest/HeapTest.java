package HeapTest;

import com.tunbobo.Heap.Heap;
import org.junit.Test;

import java.util.Arrays;

public class HeapTest {
    @Test
    public void test() {
        Heap heap = new Heap(3);
        heap.insert(5);
        heap.insert(7);
        heap.insert(8);
        heap.insert(2);
        heap.insert(6);
        System.out.println(heap);

        heap.pop();
        System.out.println(heap);
    }
}
