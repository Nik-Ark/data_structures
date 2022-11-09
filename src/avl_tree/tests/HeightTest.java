package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import static avl_tree.tests.Samples.*;

public class HeightTest {

  private static MyAVLTree<Integer> bst_empty;
  private static MyAVLTree<Integer> bst_int;
  private static MyAVLTree<String> bst_str;

  @Before
  public void setUp() {
    bst_int = new MyAVLTree<>(intArr);
    bst_empty = new MyAVLTree<>();
    bst_str = new MyAVLTree<>(strArr);
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
