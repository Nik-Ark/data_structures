package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import doubly_linked_list.MyDLL;
import static avl_tree.tests.Samples.*;

public class PreOrderTraversalTest {

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
  public void testPreOrderTraversal() {

    assertTrue(bst_empty.preOrder() != null);

    MyDLL<String> bst_str_preOrder = bst_str.preOrder();
    for (int i = 0; i < strPreOrderSample.length; i++) {
      assertEquals(strPreOrderSample[i], bst_str_preOrder.get(i), "bst_str PreOrder test");
    }

    assertTrue((bst_str_preOrder.size() == bst_str.size() && bst_str.size() == 13), "Check BST size");

    MyDLL<Integer> bst_int_preOrder = bst_int.preOrder();
    for (int i = 0; i < intPreOrderSample.length; i++) {
      assertEquals(intPreOrderSample[i], bst_int_preOrder.get(i), "bst_int PreOrder test");
    }

    assertTrue((bst_int_preOrder.size() == bst_int.size() && bst_int.size() == 13), "Check BST size");
  }
}
