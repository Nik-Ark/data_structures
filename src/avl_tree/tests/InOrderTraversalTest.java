package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import doubly_linked_list.MyDLL;

import static avl_tree.tests.Samples.*;

public class InOrderTraversalTest {

  private static MyAVLTree<String> avl_str;
  private static MyAVLTree<Integer> avl_int;
  private static MyAVLTree<Integer> avl_empty;

  @Before
  public void setUp() {
    avl_str = new MyAVLTree<>(strArr);
    avl_int = new MyAVLTree<>(intArrAVL);
    avl_empty = new MyAVLTree<>();
  }

  @Test
  public void testInOrderTraversal() {

    assertTrue(avl_empty.inOrder() != null);

    MyDLL<String> avl_str_inOrder = avl_str.inOrder();
    for (int i = 0; i < strInOrderSample.length; i++) {
      assertEquals(strInOrderSample[i], avl_str_inOrder.get(i), "avl_str InOrder traversal test");
    }

    assertTrue((avl_str_inOrder.size() == avl_str.size() && avl_str.size() == 13), "Check tree size");

    MyDLL<Integer> avl_int_inOrder = avl_int.inOrder();
    for (int i = 0; i < intInOrderSample.length; i++) {
      assertEquals(intInOrderSample[i], avl_int_inOrder.get(i), "avl_int InOrder traversal test");
    }

    assertTrue((avl_int_inOrder.size() == avl_int.size() && avl_int.size() == 14), "Check tree size");
  }
}
