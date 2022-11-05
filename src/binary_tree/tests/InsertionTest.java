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

public class InsertionTest {

  private static MyBinaryTree<String> bst_str;
  private static MyBinaryTree<String> bst_str_fromArr;
  private static MyBinaryTree<Integer> bst_int;
  private static MyBinaryTree<Integer> bst_int_fromArr;

  @Before
  public void setUp() {
    bst_str = new MyBinaryTree<>();
    bst_int = new MyBinaryTree<>();
    bst_str_fromArr = new MyBinaryTree<>(strArr);
    bst_int_fromArr = new MyBinaryTree<>(intArr);
  }

  @Test
  public void testInsertStr() {

    assertThrows(NullPointerException.class, () -> bst_str.insert(null));

    assertTrue(bst_str.insert("N"));
    assertFalse(bst_str.insert("N"));

    bst_str.insert("H");
    bst_str.insert("U");
    bst_str.insert("X");
    bst_str.insert("K");
    bst_str.insert("R");

    assertTrue(bst_str.insert("E"));
    assertFalse(bst_str.insert("E"));

    bst_str.insert("G");
    bst_str.insert("L");
    bst_str.insert("J");
    bst_str.insert("T");
    bst_str.insert("V");

    assertTrue(bst_str.insert("M"));
    assertFalse(bst_str.insert("M"));

    assertFalse(bst_str.insert("N"));

    MyDLL<String> bst_str_preOrder = bst_str.preOrder();
    for (int i = 0; i < strPreOrderSample.length; i++) {
      assertEquals(strPreOrderSample[i], bst_str_preOrder.get(i), "bst_str PreOrder test");
    }

    assertTrue(bst_str_preOrder.size() == bst_str.size() && bst_str.size() == 13, "test insert str size");
  }

  @Test
  public void testInsertInt() {

    assertThrows(NullPointerException.class, () -> bst_int.insert(null));

    assertTrue(bst_int.insert(100));
    assertFalse(bst_int.insert(100));

    bst_int.insert(200);
    bst_int.insert(50);
    bst_int.insert(90);
    bst_int.insert(30);
    bst_int.insert(40);

    assertTrue(bst_int.insert(99));
    assertFalse(bst_int.insert(99));

    bst_int.insert(25);
    bst_int.insert(70);
    bst_int.insert(150);
    bst_int.insert(170);
    bst_int.insert(230);

    assertTrue(bst_int.insert(130));
    assertFalse(bst_int.insert(130));

    assertFalse(bst_int.insert(100));

    MyDLL<Integer> bst_int_preOrder = bst_int.preOrder();
    for (int i = 0; i < intPreOrderSample.length; i++) {
      assertEquals(intPreOrderSample[i], bst_int_preOrder.get(i), "bst_int PreOrder test");
    }

    assertTrue(bst_int_preOrder.size() == bst_int.size() && bst_int.size() == 13, "test insert int size");
  }

  @Test
  public void testInsertArray() {

    String strTestSample[] = { "N", "H", "E", "G", "K", "J", "L", "M", "U", "R", "T", "X", "V", "Z" };
    int intTestSample[] = { 100, 50, 30, 25, 40, 90, 70, 99, 200, 150, 130, 170, 230, 250 };

    assertFalse(bst_str_fromArr.insert("N"));
    assertFalse(bst_str_fromArr.insert("E"));
    assertFalse(bst_str_fromArr.insert("M"));
    assertFalse(bst_int_fromArr.insert(100));
    assertFalse(bst_int_fromArr.insert(99));
    assertFalse(bst_int_fromArr.insert(130));

    bst_str_fromArr.insert("Z");
    bst_int_fromArr.insert(250);

    MyDLL<String> bst_str_preOrder = bst_str_fromArr.preOrder();
    for (int i = 0; i < strTestSample.length; i++) {
      assertEquals(strTestSample[i], bst_str_preOrder.get(i), "bst_str Insert Array test");
    }

    assertTrue(bst_str_preOrder.size() == bst_str_fromArr.size() && bst_str_fromArr.size() == 14,
        "test size of tree created with Array");

    MyDLL<Integer> bst_int_preOrder = bst_int_fromArr.preOrder();
    for (int i = 0; i < intTestSample.length; i++) {
      assertEquals(intTestSample[i], bst_int_preOrder.get(i), "bst_int Insert Array test");
    }

    assertTrue(bst_int_preOrder.size() == bst_int_fromArr.size() && bst_int_fromArr.size() == 14,
        "test size of tree created with Array");
  }
}
