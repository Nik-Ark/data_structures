package avl_tree.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import doubly_linked_list.MyDLL;
import static avl_tree.tests.Samples.*;

public class RemoveTest {

  private static MyAVLTree<String> avl_str;
  private static MyAVLTree<Integer> avl_int;
  private static MyAVLTree<String> avl_str_empty;
  private static MyAVLTree<Integer> avl_int_empty;

  @Before
  public void setUp() {
    avl_str = new MyAVLTree<>(strArr);
    avl_str_empty = new MyAVLTree<>();
    avl_int = new MyAVLTree<>(intArrAVL);
    avl_int_empty = new MyAVLTree<>();
  }

  @Test
  public void testRemoveStr() {

    String levelOrderAfterRemoveStr[] = { "R", "K", "V", "E", "L", "T", "X", "G" };
    String postOrderAfterRemoveStr[] = { "G", "E", "L", "K", "T", "X", "V", "R" };

    assertThrows(NullPointerException.class, () -> avl_str.find(null));
    assertFalse(avl_str_empty.remove("N"));
    assertTrue(avl_str_empty.insert("N"));
    assertTrue(avl_str_empty.insert("M"));
    assertTrue(avl_str_empty.size() == 2);

    assertTrue(avl_str_empty.remove("N"));
    assertTrue(avl_str_empty.remove("M"));
    assertFalse(avl_str_empty.remove("N"));
    assertTrue(avl_str_empty.size() == 0);

    assertTrue(avl_str.remove("N"));
    assertTrue(avl_str.remove("M"));
    assertTrue(avl_str.remove("H"));
    assertTrue(avl_str.remove("J"));
    assertTrue(avl_str.remove("U"));

    MyDLL<String> avl_str_levelOrder = avl_str.levelOrder();
    for (int i = 0; i < levelOrderAfterRemoveStr.length; i++) {
      assertEquals(levelOrderAfterRemoveStr[i], avl_str_levelOrder.get(i));
    }
    assertTrue(avl_str_levelOrder.size() == avl_str.size() && avl_str.size() == 8);

    MyDLL<String> avl_str_postOrder = avl_str.postOrder();
    for (int i = 0; i < postOrderAfterRemoveStr.length; i++) {
      assertEquals(postOrderAfterRemoveStr[i], avl_str_postOrder.get(i));
    }
    assertTrue(avl_str_postOrder.size() == avl_str.size() && avl_str.size() == 8);

    assertEquals(3, avl_str.height());
  }

  @Test
  public void testRemoveInt() {

    int levelOrderAfterRemoveInt[] = { 130, 90, 230, 40, 99, 170, 250, 25 };
    int postOrderAfterRemoveInt[] = { 25, 40, 99, 90, 170, 250, 230, 130 };

    assertThrows(NullPointerException.class, () -> avl_int.find(null));
    assertFalse(avl_int_empty.remove(100));
    assertTrue(avl_int_empty.insert(100));
    assertTrue(avl_int_empty.insert(200));
    assertTrue(avl_int_empty.size() == 2);

    assertTrue(avl_int_empty.remove(100));
    assertTrue(avl_int_empty.remove(200));
    assertFalse(avl_int_empty.remove(100));
    assertTrue(avl_int_empty.size() == 0);

    assertTrue(avl_int.remove(100));
    assertTrue(avl_int.remove(50));
    assertTrue(avl_int.remove(70));
    assertTrue(avl_int.remove(30));
    assertTrue(avl_int.remove(200));
    assertTrue(avl_int.remove(150));

    MyDLL<Integer> avl_int_levelOrder = avl_int.levelOrder();
    for (int i = 0; i < levelOrderAfterRemoveInt.length; i++) {
      assertEquals(levelOrderAfterRemoveInt[i], avl_int_levelOrder.get(i));
    }
    assertTrue(avl_int_levelOrder.size() == avl_int.size() && avl_int.size() == 8);

    MyDLL<Integer> avl_int_postOrder = avl_int.postOrder();
    for (int i = 0; i < postOrderAfterRemoveInt.length; i++) {
      assertEquals(postOrderAfterRemoveInt[i], avl_int_postOrder.get(i));
    }
    assertTrue(avl_int_postOrder.size() == avl_int.size() && avl_int.size() == 8);

    assertEquals(3, avl_int.height());

  }
}
