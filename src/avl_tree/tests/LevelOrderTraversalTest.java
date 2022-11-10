package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import doubly_linked_list.MyDLL;
import static avl_tree.tests.Samples.*;

public class LevelOrderTraversalTest {

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
  public void testLevelOrderTraversal() {

    assertTrue(avl_empty.levelOrder() != null);

    MyDLL<String> avl_str_levelOrder = avl_str.levelOrder();
    for (int i = 0; i < strLevelOrderSample.length; i++) {
      assertEquals(strLevelOrderSample[i], avl_str_levelOrder.get(i), "Level Order traversal test");
    }

    assertTrue((avl_str_levelOrder.size() == avl_str.size() && avl_str.size() == 13), "AVL Tree size");

    MyDLL<Integer> avl_int_levelOrder = avl_int.levelOrder();
    for (int i = 0; i < intLevelOrderSample.length; i++) {
      assertEquals(intLevelOrderSample[i], avl_int_levelOrder.get(i), "Level Order traversal test");
    }

    assertTrue((avl_int_levelOrder.size() == avl_int.size() && avl_int.size() == 14), "AVL Tree size");
  }
}
