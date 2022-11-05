package binary_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import doubly_linked_list.MyDLL;
import binary_tree.MyBinaryTree;
import static binary_tree.tests.Samples.*;

public class PostOrderTraversalTest {

  private static MyBinaryTree<String> bst_str;
  private static MyBinaryTree<Integer> bst_int;
  private static MyBinaryTree<Integer> bst_empty;

  @Before
  public void setUp() {
    bst_str = new MyBinaryTree<>(strArr);
    bst_int = new MyBinaryTree<>(intArr);
    bst_empty = new MyBinaryTree<>();
  }

  @Test
  public void testPostOrderTraversal() {

    assertTrue(bst_empty.postOrder() != null);

    MyDLL<String> bst_str_postOrder = bst_str.postOrder();
    for (int i = 0; i < strPostOrderSample.length; i++) {
      assertEquals(strPostOrderSample[i], bst_str_postOrder.get(i), "bst_str Post Order traversal test");
    }

    assertTrue((bst_str_postOrder.size() == bst_str.size() && bst_str.size() == 13), "Check BST size");

    MyDLL<Integer> bst_int_postOrder = bst_int.postOrder();
    for (int i = 0; i < intPostOrderSample.length; i++) {
      assertEquals(intPostOrderSample[i], bst_int_postOrder.get(i), "bst_int Post Order traversal test");
    }

    assertTrue((bst_int_postOrder.size() == bst_int.size() && bst_int.size() == 13), "Check BST size");
  }
}
