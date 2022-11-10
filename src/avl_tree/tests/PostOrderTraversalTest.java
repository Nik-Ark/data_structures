package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import doubly_linked_list.MyDLL;
import static avl_tree.tests.Samples.*;

public class PostOrderTraversalTest {

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
  public void testPostOrderTraversal() {

    assertTrue(avl_empty.postOrder() != null);

    MyDLL<String> avl_str_postOrder = avl_str.postOrder();
    for (int i = 0; i < strPostOrderSample.length; i++) {
      assertEquals(strPostOrderSample[i], avl_str_postOrder.get(i), "Post Order traversal test");
    }

    assertTrue((avl_str_postOrder.size() == avl_str.size() && avl_str.size() == 13), "Check avl size");

    MyDLL<Integer> avl_int_postOrder = avl_int.postOrder();
    for (int i = 0; i < intPostOrderSample.length; i++) {
      assertEquals(intPostOrderSample[i], avl_int_postOrder.get(i), "Post Order traversal test");
    }

    assertTrue((avl_int_postOrder.size() == avl_int.size() && avl_int.size() == 14), "Check avl size");
  }
}
