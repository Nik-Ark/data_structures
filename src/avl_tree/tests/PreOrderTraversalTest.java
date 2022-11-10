package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import doubly_linked_list.MyDLL;
import static avl_tree.tests.Samples.*;

public class PreOrderTraversalTest {

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
  public void testPreOrderTraversal() {

    assertTrue(avl_empty.preOrder() != null);

    MyDLL<String> avl_str_preOrder = avl_str.preOrder();
    for (int i = 0; i < strPreOrderSample.length; i++) {
      assertEquals(strPreOrderSample[i], avl_str_preOrder.get(i), "avl_str PreOrder test");
    }

    assertTrue((avl_str_preOrder.size() == avl_str.size() && avl_str.size() == 13), "AVL Tree size");

    MyDLL<Integer> avl_int_preOrder = avl_int.preOrder();
    for (int i = 0; i < intPreOrderSample.length; i++) {
      assertEquals(intPreOrderSample[i], avl_int_preOrder.get(i), "avl_int PreOrder test");
    }

    assertTrue((avl_int_preOrder.size() == avl_int.size() && avl_int.size() == 14), "AVL Tree size");
  }
}
