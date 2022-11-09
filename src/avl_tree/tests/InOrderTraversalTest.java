package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import doubly_linked_list.MyDLL;

import static avl_tree.tests.Samples.*;

public class InOrderTraversalTest {

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
  public void testInOrderTraversal() {

    assertTrue(bst_empty.inOrder() != null);

    MyDLL<String> bst_str_inOrder = bst_str.inOrder();
    for (int i = 0; i < strInOrderSample.length; i++) {
      assertEquals(strInOrderSample[i], bst_str_inOrder.get(i), "bst_str InOrder traversal test");
    }

    assertTrue((bst_str_inOrder.size() == bst_str.size() && bst_str.size() == 13), "Check BST size");

    MyDLL<Integer> bst_int_inOrder = bst_int.inOrder();
    for (int i = 0; i < intInOrderSample.length; i++) {
      assertEquals(intInOrderSample[i], bst_int_inOrder.get(i), "bst_int InOrder traversal test");
    }

    assertTrue((bst_int_inOrder.size() == bst_int.size() && bst_int.size() == 13), "Check BST size");
  }
}
