package TreeTest;

import com.tunbobo.Tree.binaryTree.TreeDemo;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testAddTree() {
        TreeDemo tree = new TreeDemo();
        tree.add(5);
        tree.add(4);
        tree.add(7);
        tree.add(8);
        System.out.println(tree);

        tree.add(1);
        System.out.println(tree);
    }

    @Test
    public void testDeleteTree() {
        TreeDemo tree = new TreeDemo();
        tree.add(4);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(11);
        tree.add(5);
        tree.add(2);
        tree.add(3);
        tree.add(6);
        System.out.println(tree);

//        tree.delete();
        tree.delete(8);
        System.out.println(tree);
    }
}
