package binary_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import binary_tree.MyBinaryTree;
import static binary_tree.tests.Samples.*;

public class HeightTest {

  private static MyBinaryTree<Integer> bst_empty;
  private static MyBinaryTree<Integer> bst_int;
  private static MyBinaryTree<String> bst_str;

  @Before
  public void setUp() {
    bst_int = new MyBinaryTree<>(intArr);
    bst_empty = new MyBinaryTree<>();
    bst_str = new MyBinaryTree<>(strArr);
  }

  @Test
  public void testHeight() {

    assertEquals(-1, bst_empty.height());

    bst_empty.insert(100);
    assertEquals(0, bst_empty.height());

    bst_empty.insert(101);
    assertEquals(1, bst_empty.height());

    bst_empty.insert(99);
    assertEquals(1, bst_empty.height());

    bst_empty.insert(98);
    assertEquals(2, bst_empty.height());

    bst_empty.insert(102);
    assertEquals(2, bst_empty.height());

    bst_empty.remove(102);
    assertEquals(2, bst_empty.height());

    bst_empty.remove(98);
    assertEquals(1, bst_empty.height());

    bst_empty.remove(99);
    assertEquals(1, bst_empty.height());

    bst_empty.remove(101);
    assertEquals(0, bst_empty.height());

    bst_empty.remove(100);
    assertEquals(-1, bst_empty.height());

    assertEquals(3, bst_int.height());
  }

  @Test
  public void testRemovalImpactOnHeight() {
    // IMPORTANT !
    // This test fails if after node's removal parent of removed node wasn't reset
    // or nulled, if node takes place of the root (being child of the root before).

    assertEquals(4, bst_str.height());

    bst_str.remove("J");
    assertEquals(4, bst_str.height());

    bst_str.remove("K");
    assertEquals(3, bst_str.height());

    bst_str.remove("G");
    bst_str.remove("T");
    bst_str.remove("V");
    assertEquals(3, bst_str.height());

    bst_str.remove("L");
    assertEquals(2, bst_str.height());
  }
}
