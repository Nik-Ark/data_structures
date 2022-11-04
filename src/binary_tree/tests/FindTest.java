package binary_tree.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import binary_tree.MyBinaryTree;
import static binary_tree.tests.Samples.*;

public class FindTest {

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
    bst_int = new MyBinaryTree<>(intArr);
    bst_str_empty = new MyBinaryTree<>();
    bst_int_empty = new MyBinaryTree<>();
  }

  @Test
  public void testFindStr() {

    assertThrows(NullPointerException.class, () -> bst_str.find(null));

    assertFalse(bst_str_empty.find("A"));
    bst_str_empty.insert("A");
    assertTrue(bst_str_empty.find("A"));

    assertFalse(bst_str.find("m"));
    assertFalse(bst_str.find("n"));
    assertFalse(bst_str.find("W"));
    assertFalse(bst_str.find("F"));
    assertFalse(bst_str.find("Z"));

    bst_str.insert("Z");

    assertTrue(bst_str.find("Z"));
    assertTrue(bst_str.find("R"));
    assertTrue(bst_str.find("M"));
    assertTrue(bst_str.find("N"));
    assertTrue(bst_str.find("G"));
    assertTrue(bst_str.find("J"));
  }

  @Test
  public void testFindInt() {

    assertThrows(NullPointerException.class, () -> bst_int.find(null));

    assertFalse(bst_int_empty.find(8));
    bst_int_empty.insert(8);
    assertTrue(bst_int_empty.find(8));

    assertTrue(bst_int.find(100));
    assertTrue(bst_int.find(170));
    assertTrue(bst_int.find(25));
    assertTrue(bst_int.find(150));
    assertTrue(bst_int.find(90));

    assertFalse(bst_int.find(131));
    assertFalse(bst_int.find(0));
  }
}
