package binary_tree.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Before;
import org.junit.Test;

import doubly_linked_list.MyDLL;
import binary_tree.MyBinaryTree;
import static binary_tree.tests.Samples.*;

public class RemoveTest {

  private static MyBinaryTree<String> bst_str;
  private static MyBinaryTree<Integer> bst_int;
  private static MyBinaryTree<String> bst_str_empty;
  private static MyBinaryTree<Integer> bst_int_empty;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    bst_str = new MyBinaryTree<>(strArr);
    bst_str_empty = new MyBinaryTree<>();
    bst_int = new MyBinaryTree<>(intArr);
    bst_int_empty = new MyBinaryTree<>();
  }

  @Test
  public void testRemoveStr() {

    String levelOrderAfterRemoveStr[] = { "R", "K", "V", "E", "L", "T", "X", "G" };
    String postOrderAfterRemoveStr[] = { "G", "E", "L", "K", "T", "X", "V", "R" };

    assertThrows(NullPointerException.class, () -> bst_str.find(null));
    assertFalse(bst_str_empty.remove("N"));
    assertTrue(bst_str_empty.insert("N"));
    assertTrue(bst_str_empty.insert("M"));
    assertTrue(bst_str_empty.size() == 2);

    assertTrue(bst_str_empty.remove("N"));
    assertTrue(bst_str_empty.remove("M"));
    assertFalse(bst_str_empty.remove("N"));
    assertTrue(bst_str_empty.size() == 0);

    assertTrue(bst_str.remove("N"));
    assertTrue(bst_str.remove("M"));
    assertTrue(bst_str.remove("H"));
    assertTrue(bst_str.remove("J"));
    assertTrue(bst_str.remove("U"));

    MyDLL<String> bst_str_levelOrder = bst_str.levelOrder();
    for (int i = 0; i < levelOrderAfterRemoveStr.length; i++) {
      assertEquals(levelOrderAfterRemoveStr[i], bst_str_levelOrder.get(i));
    }
    assertTrue(bst_str_levelOrder.size() == bst_str.size() && bst_str.size() == 8);

    MyDLL<String> bst_str_postOrder = bst_str.postOrder();
    for (int i = 0; i < postOrderAfterRemoveStr.length; i++) {
      assertEquals(postOrderAfterRemoveStr[i], bst_str_postOrder.get(i));
    }
    assertTrue(bst_str_postOrder.size() == bst_str.size() && bst_str.size() == 8);
  }

  @Test
  public void testRemoveInt() {

    int levelOrderAfterRemoveInt[] = { 130, 90, 230, 40, 99, 150, 170 };
    int postOrderAfterRemoveInt[] = { 40, 99, 90, 170, 150, 230, 130 };

    assertThrows(NullPointerException.class, () -> bst_int.find(null));
    assertFalse(bst_int_empty.remove(100));
    assertTrue(bst_int_empty.insert(100));
    assertTrue(bst_int_empty.insert(200));
    assertTrue(bst_int_empty.size() == 2);

    assertTrue(bst_int_empty.remove(100));
    assertTrue(bst_int_empty.remove(200));
    assertFalse(bst_int_empty.remove(100));
    assertTrue(bst_int_empty.size() == 0);

    assertTrue(bst_int.remove(100));
    assertTrue(bst_int.remove(50));
    assertTrue(bst_int.remove(70));
    assertTrue(bst_int.remove(30));
    assertTrue(bst_int.remove(200));
    assertTrue(bst_int.remove(25));

    MyDLL<Integer> bst_int_levelOrder = bst_int.levelOrder();
    for (int i = 0; i < levelOrderAfterRemoveInt.length; i++) {
      assertEquals(levelOrderAfterRemoveInt[i], bst_int_levelOrder.get(i));
    }
    assertTrue(bst_int_levelOrder.size() == bst_int.size() && bst_int.size() == 7);

    MyDLL<Integer> bst_int_postOrder = bst_int.postOrder();
    for (int i = 0; i < postOrderAfterRemoveInt.length; i++) {
      assertEquals(postOrderAfterRemoveInt[i], bst_int_postOrder.get(i));
    }
    assertTrue(bst_int_postOrder.size() == bst_int.size() && bst_int.size() == 7);

  }
}
