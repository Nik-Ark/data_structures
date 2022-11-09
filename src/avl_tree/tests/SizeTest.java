package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;

public class SizeTest {

  private static MyAVLTree<Integer> bst_int;

  @Before
  public void setUp() {
    bst_int = new MyAVLTree<>();
  }

  @Test
  public void testSize() {

    assertTrue(bst_int.size() == 0);

    bst_int.insert(5);
    assertTrue(bst_int.size() == 1);

    bst_int.insert(7);
    assertTrue(bst_int.size() == 2);

    bst_int.insert(9);
    assertTrue(bst_int.size() == 3);

    bst_int.insert(3);
    assertTrue(bst_int.size() == 4);

    bst_int.insert(1);
    assertTrue(bst_int.size() == 5);

    bst_int.remove(5);
    assertTrue(bst_int.size() == 4);

    bst_int.remove(3);
    assertTrue(bst_int.size() == 3);

    bst_int.remove(9);
    assertTrue(bst_int.size() == 2);

    bst_int.remove(7);
    assertTrue(bst_int.size() == 1);

    bst_int.remove(1);
    assertTrue(bst_int.size() == 0);

  }
}
