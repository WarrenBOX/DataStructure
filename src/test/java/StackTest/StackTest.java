package StackTest;

import com.tunbobo.Stack.StackList;
import org.junit.Test;

public class StackTest {
    @Test
    public void test() {
        StackList stack = new StackList();
        stack.push(5);
        stack.push(7);
        stack.push(8);
        System.out.println(stack);
        System.out.println(stack.top.next);
        System.out.println(stack.top.next.next);
        System.out.println(stack.top.next.next.next);
    }
}
