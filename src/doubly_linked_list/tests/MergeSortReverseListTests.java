package doubly_linked_list.tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import doubly_linked_list.DLL;

/**
 * @author Nikki
 *         Tests for two methods which demonstrates that all inherit links
 *         rearanged correctly after Sorting and after Reversing, including head
 *         and tail pointers.
 */
public class MergeSortReverseListTests {

  private static final int LIST_LENGTH_FOR_SORTING_TEST = 21;

  LinkedList<Integer> originIntLL;
  DLL<Integer> myIntLL;
  LinkedList<String> originStrLL;
  DLL<String> myStrLL;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {

    Random rand = new Random();
    Integer[] numbers = new Integer[LIST_LENGTH_FOR_SORTING_TEST];

    String[] words = { "zoom", "battle", "winner", "war", "Andrew", "andrew", "Andrew", "andrew", "apple", "window",
        "widow", "string", "sex", "love", "Love", "God", "evil", "Superior", "Goal", "struggle", "striver" };

    for (int i = 0; i < LIST_LENGTH_FOR_SORTING_TEST; i++) {
      numbers[i] = rand.nextInt(100);
    }

    originIntLL = new LinkedList<>(Arrays.asList(numbers));
    myIntLL = new DLL<>(numbers);

    originStrLL = new LinkedList<>(Arrays.asList(words));
    myStrLL = new DLL<>(words);

  }

  @Test
  public void testMergeSortAndReverseList() {

    for (int i = 0; i < LIST_LENGTH_FOR_SORTING_TEST; i++) {
      assertTrue("Lists have same elements: ", originIntLL.get(i) == myIntLL.get(i));
      assertTrue("Lists have same elements: ", originStrLL.get(i) == myStrLL.get(i));
    }

    Collections.reverse(originIntLL);
    Collections.reverse(originStrLL);
    myIntLL.reverse();
    myStrLL.reverse();

    for (int i = 0; i < LIST_LENGTH_FOR_SORTING_TEST; i++) {
      assertTrue("Lists after 1st reverse: ", originIntLL.get(i) == myIntLL.get(i));
      assertTrue("Lists after 1st reverse: ", originStrLL.get(i) == myStrLL.get(i));
    }

    Collections.sort(originIntLL);
    Collections.sort(originStrLL);
    myIntLL.mergeSort();
    myStrLL.mergeSort();

    for (int i = 0; i < LIST_LENGTH_FOR_SORTING_TEST; i++) {
      assertTrue("Lists after 1st sorting: ", originIntLL.get(i) == myIntLL.get(i));
      assertTrue("Lists after 1st sorting: ", originStrLL.get(i) == myStrLL.get(i));
    }

    Collections.reverse(originIntLL);
    Collections.reverse(originStrLL);
    myIntLL.reverse();
    myStrLL.reverse();

    for (int i = 0; i < LIST_LENGTH_FOR_SORTING_TEST; i++) {
      assertTrue("Lists after 2nd reverse: ", originIntLL.get(i) == myIntLL.get(i));
      assertTrue("Lists after 2nd reverse: ", originStrLL.get(i) == myStrLL.get(i));
    }

    Collections.sort(originIntLL);
    Collections.sort(originStrLL);
    myIntLL.mergeSort();
    myStrLL.mergeSort();

    for (int i = 0; i < LIST_LENGTH_FOR_SORTING_TEST; i++) {
      assertTrue("Lists after 2nd sorting: ", originIntLL.get(i) == myIntLL.get(i));
      assertTrue("Lists after 2nd sorting: ", originStrLL.get(i) == myStrLL.get(i));
    }
  }
}
