package doubly_linked_list.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import doubly_linked_list.MyDLL;

public class ManualTest {
  /**
   * Manual tests for my MergeSort and Revers MyDLL algorithm.
   * 
   * @param args
   * 
   */
  public static void main(String[] args) {

    Random rand = new Random();
    Integer[] numbers = new Integer[21];

    for (int i = 0; i < 21; i++) {
      numbers[i] = rand.nextInt(100);
    }

    LinkedList<Integer> originLL = new LinkedList<>(Arrays.asList(numbers));
    MyDLL<Integer> myLL = new MyDLL<>(numbers);

    System.out.println("Before Sorting:");
    for (int i = 0; i < 21; i++) {
      System.out.println("Origin: " + originLL.get(i) + " My: " + myLL.get(i));
    }

    Collections.sort(originLL);
    myLL.mergeSort();

    System.out.println("After Sorting:");
    for (int i = 0; i < 21; i++) {
      String status;
      if (originLL.get(i) == myLL.get(i))
        status = "Passed";
      else
        status = "Failed";

      System.out.println("Origin: " + originLL.get(i) + " My: " + myLL.get(i) + " Status: " + status);
    }

    Collections.reverse(originLL);
    myLL.reverse();

    System.out.println("After Reversing:");
    for (int i = 0; i < 21; i++) {
      String status;
      if (originLL.get(i) == myLL.get(i))
        status = "Passed";
      else
        status = "Failed";

      System.out.println("Origin: " + originLL.get(i) + " My: " + myLL.get(i) + " Status: " + status);
    }

    Collections.reverse(originLL);
    myLL.reverse();

    System.out.println("After 2nd Reversing:");
    for (int i = 0; i < 21; i++) {
      String status;
      if (originLL.get(i) == myLL.get(i))
        status = "Passed";
      else
        status = "Failed";

      System.out.println("Origin: " + originLL.get(i) + " My: " + myLL.get(i) + " Status: " + status);
    }
  }
}
