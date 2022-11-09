package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import doubly_linked_list.MyDLL;
import static avl_tree.tests.Samples.*;

public class LevelOrderTraversalTest {

  private static MyAVLTree<String> bst_str;
  private static MyAVLTree<Integer> bst_int;
  private static MyAVLTree<Integer> bst_empty;

  @Before
  public void setUp() {
    bst_str = new MyAVLTree<>(strArr);
    bst_int = new MyAVLTree<>(intArr);
    bst_empty = new MyAVLTree<>();
  }

  @Test
  public void testLevelOrderTraversal() {

    assertTrue(bst_empty.levelOrder() != null);

    MyDLL<String> bst_str_levelOrder = bst_str.levelOrder();
    for (int i = 0; i < strLevelOrderSample.length; i++) {
      assertEquals(strLevelOrderSample[i], bst_str_levelOrder.get(i), "bst_str Level Order traversal test");
    }

    assertTrue((bst_str_levelOrder.size() == bst_str.size() && bst_str.size() == 13), "Check BST size");

    MyDLL<Integer> bst_int_levelOrder = bst_int.levelOrder();
    for (int i = 0; i < intLevelOrderSample.length; i++) {
      assertEquals(intLevelOrderSample[i], bst_int_levelOrder.get(i), "bst_int Level Order traversal test");
    }

    assertTrue((bst_int_levelOrder.size() == bst_int.size() && bst_int.size() == 13), "Check BST size");
  }
}
