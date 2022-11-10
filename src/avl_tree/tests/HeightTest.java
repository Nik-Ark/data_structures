package avl_tree.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import avl_tree.MyAVLTree;
import static avl_tree.tests.Samples.*;

public class HeightTest {

  private static MyAVLTree<Integer> avl_empty;
  private static MyAVLTree<Integer> avl_int;
  private static MyAVLTree<String> avl_str;

  @Before
  public void setUp() {
    avl_int = new MyAVLTree<>(intArrAVL);
    avl_empty = new MyAVLTree<>();
    avl_str = new MyAVLTree<>(strArr);
  }

  @Test
  public void testHeight() {

    assertEquals(-1, avl_empty.height());

    avl_empty.insert(100);
    assertEquals(0, avl_empty.height());

    avl_empty.insert(150);
    assertEquals(1, avl_empty.height());

    avl_empty.insert(50);
    assertEquals(1, avl_empty.height());

    avl_empty.insert(170);
    assertEquals(2, avl_empty.height());

    avl_empty.insert(30);
    assertEquals(2, avl_empty.height());

    // rebalance occurs
    avl_empty.insert(180);
    assertEquals(2, avl_empty.height());

    assertEquals(3, avl_int.height());
  }

  @Test
  public void testRemovalImpactOnHeight() {
    // IMPORTANT !
    // This test fails if after node's removal parent of removed node wasn't reset
    // or nulled, if node takes place of the root (being child of the root before).
    // Also rebalace impacts Tree's height.

    assertEquals(4, avl_str.height());

    // rebalance occurs
    avl_str.remove("J");
    assertEquals(3, avl_str.height());

    avl_str.remove("K");
    assertEquals(3, avl_str.height());
  }
}
