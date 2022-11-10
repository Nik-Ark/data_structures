package avl_tree.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import static avl_tree.tests.Samples.*;

public class FindTest {

  private static MyAVLTree<String> avl_str;
  private static MyAVLTree<Integer> avl_int;
  private static MyAVLTree<String> avl_str_empty;
  private static MyAVLTree<Integer> avl_int_empty;

  @Before
  public void setUp() {
    avl_str = new MyAVLTree<>(strArr);
    avl_int = new MyAVLTree<>(intArrAVL);
    avl_str_empty = new MyAVLTree<>();
    avl_int_empty = new MyAVLTree<>();
  }

  @Test
  public void testFindStr() {

    assertThrows(NullPointerException.class, () -> avl_str.find(null));

    assertFalse(avl_str_empty.find("A"));
    avl_str_empty.insert("A");
    assertTrue(avl_str_empty.find("A"));

    assertFalse(avl_str.find("m"));
    assertFalse(avl_str.find("n"));
    assertFalse(avl_str.find("W"));
    assertFalse(avl_str.find("F"));
    assertFalse(avl_str.find("Z"));

    avl_str.insert("Z");

    assertTrue(avl_str.find("Z"));
    assertTrue(avl_str.find("R"));
    assertTrue(avl_str.find("M"));
    assertTrue(avl_str.find("N"));
    assertTrue(avl_str.find("G"));
    assertTrue(avl_str.find("J"));
  }

  @Test
  public void testFindInt() {

    assertThrows(NullPointerException.class, () -> avl_int.find(null));

    assertFalse(avl_int_empty.find(8));
    avl_int_empty.insert(8);
    assertTrue(avl_int_empty.find(8));

    assertTrue(avl_int.find(100));
    assertTrue(avl_int.find(170));
    assertTrue(avl_int.find(25));
    assertTrue(avl_int.find(150));
    assertTrue(avl_int.find(90));

    assertFalse(avl_int.find(131));
    assertFalse(avl_int.find(0));
  }
}
