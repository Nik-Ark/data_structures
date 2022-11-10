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

public class InsertionTest {

  private static MyAVLTree<String> avl_str;
  private static MyAVLTree<String> avl_str_fromArr;
  private static MyAVLTree<Integer> avl_int_fromArr;

  @Before
  public void setUp() {
    avl_str = new MyAVLTree<>();
    avl_str_fromArr = new MyAVLTree<>(strArr);
    avl_int_fromArr = new MyAVLTree<>(intArrAVL);
  }

  @Test
  public void testInsertStr() {

    assertThrows(NullPointerException.class, () -> avl_str.insert(null));

    assertTrue(avl_str.insert("N"));
    assertFalse(avl_str.insert("N"));

    avl_str.insert("H");
    avl_str.insert("U");
    avl_str.insert("X");
    avl_str.insert("K");
    avl_str.insert("R");

    assertTrue(avl_str.insert("E"));
    assertFalse(avl_str.insert("E"));

    avl_str.insert("G");
    avl_str.insert("L");
    avl_str.insert("J");
    avl_str.insert("T");
    avl_str.insert("V");

    assertTrue(avl_str.insert("M"));
    assertFalse(avl_str.insert("M"));

    assertFalse(avl_str.insert("N"));

    MyDLL<String> avl_str_preOrder = avl_str.preOrder();
    for (int i = 0; i < strPreOrderSample.length; i++) {
      assertEquals(strPreOrderSample[i], avl_str_preOrder.get(i), "avl_str PreOrder test");
    }

    assertTrue(avl_str_preOrder.size() == avl_str.size() && avl_str.size() == 13, "check str size");
  }

  @Test
  public void testInsertArray() {

    String strTestSample[] = { "N", "H", "E", "G", "K", "J", "L", "M", "U", "R", "T", "X", "V", "Z" };

    assertFalse(avl_str_fromArr.insert("N"));
    assertFalse(avl_str_fromArr.insert("E"));
    assertFalse(avl_str_fromArr.insert("M"));
    assertFalse(avl_int_fromArr.insert(100));
    assertFalse(avl_int_fromArr.insert(250));
    assertFalse(avl_int_fromArr.insert(130));

    avl_str_fromArr.insert("Z");

    MyDLL<String> avl_str_preOrder = avl_str_fromArr.preOrder();
    for (int i = 0; i < strTestSample.length; i++) {
      assertEquals(strTestSample[i], avl_str_preOrder.get(i), "avl_str Insert Array test");
    }

    assertTrue(avl_str_preOrder.size() == avl_str_fromArr.size() && avl_str_fromArr.size() == 14,
        "test size of tree created with Array");

    MyDLL<Integer> avl_int_preOrder = avl_int_fromArr.preOrder();
    for (int i = 0; i < intPreOrderSample.length; i++) {
      assertEquals(intPreOrderSample[i], avl_int_preOrder.get(i), "avl_int Insert Array test");
    }

    assertTrue(avl_int_preOrder.size() == avl_int_fromArr.size() && avl_int_fromArr.size() == 14,
        "test size of tree created with Array");
  }
}
