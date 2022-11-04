package binary_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import binary_tree.MyBinaryTree;
import doubly_linked_list.MyDLL;

import static binary_tree.tests.Samples.*;

public class InOrderTraversalTest {

  private static MyBinaryTree<String> bst_str;
  private static MyBinaryTree<Integer> bst_int;

  @Before
  public void setUp() {
    bst_str = new MyBinaryTree<>(strArr);
    bst_int = new MyBinaryTree<>(intArr);
  }

  @Test
  public void testInOrderTraversal() {

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
