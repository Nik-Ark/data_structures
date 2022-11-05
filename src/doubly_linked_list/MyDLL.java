package doubly_linked_list;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

// TODO: Add JUnit Tests for size() and remove()

/**
 * A class that implements a doubly linked list
 * 
 * @author Nikki
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyDLL<E extends Comparable<? super E>> extends AbstractList<E> {
  private LLNode<E> head;
  private LLNode<E> tail;
  private int size;

  public MyDLL() {
    head = null;
    tail = null;
    size = 0;
  }

  public MyDLL(E[] array) {
    this();

    for (int i = 0; i < array.length; i++) {
      add(array[i]);
    }
  }

  /**
   * Appends an element to the end of the list
   * 
   * @throws NullPointerException if null was set as a value
   * @param element The element to add
   */
  public boolean add(E element) {
    if (element == null)
      throw new NullPointerException();
    if (head == null) {
      head = new LLNode<E>(element);
      tail = head;
      size++;
      return true;
    }

    tail.next = new LLNode<E>(element);
    tail.next.prev = tail;
    tail = tail.next;

    size++;
    return true;
  }

  /**
   * Get the element at position index
   * 
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  public E get(int index) {
    if (index < 0 | index >= size)
      throw new IndexOutOfBoundsException();

    int i = 0;
    LLNode<E> temp = head;

    while (i < index) {
      temp = temp.next;
      i++;
    }

    return temp.data;
  }

  /**
   * Add an element to the list at the specified index
   * 
   * @param index   The index where the element should be added
   * @param element The element to add
   * 
   * @throws IndexOutOfBoundsException if the index is out of bounds
   * @throws NullPointerException      if null was set as a value.
   */
  public void add(int index, E element) {
    if (element == null)
      throw new NullPointerException();
    if (index > size | index < 0)
      throw new IndexOutOfBoundsException();

    LLNode<E> tmp = head;
    int i = 0;

    while (i < index) {
      tmp = tmp.next;
      i++;
    }

    if (index == 0 && size == 0) { // LIST IS EMPTY, INDEX ARGUMENT IS ZERO
      head = new LLNode<E>(element);
      tail = head;
    } else if (index == size) { // LIST HAS AT LEAST ONE ELEMENT, NODE INSERTED AFTER ALL OF THEM
      tail.next = new LLNode<E>(element);
      tail.next.prev = tail;
      tail = tail.next;
    } else if (index == 0 && size > 0) { // LIST HAS AT LEAST ONE ELEMENT, NODE INSERTED AS FIRST
      tmp.prev = new LLNode<E>(element);
      tmp.prev.next = tmp;
      head = head.prev;
    } else { // ELEMENT CHAINS SHOULD BE REARANGED
      tmp.prev.next = new LLNode<E>(element);
      tmp.prev.next.prev = tmp.prev;
      tmp.prev.next.next = tmp;
      tmp.prev = tmp.prev.next;
    }

    size++;
  }

  /** Return the size of the list */
  public int size() {
    return size;
  }

  /**
   * Remove a node at the specified index and return its data element.
   * 
   * @param index The index of the element to remove
   * @return The data element removed
   * @throws IndexOutOfBoundsException If index is outside the bounds of the list
   * 
   */
  public E remove(int index) {
    if (index < 0 | index >= size)
      throw new IndexOutOfBoundsException();

    int i = 0;
    LLNode<E> temp = head;

    while (i < index) {
      temp = temp.next;
      i++;
    }

    if (size > 1) { // AT LEAST TWO ELEMENTS ARE IN THE CHAIN
      if (temp.prev == null) { // FIRST ELEMENT IN THE CHAIN
        temp.next.prev = null;
        head = temp.next;
      } else if (temp.next == null) { // LAST ELEMENT IN THE CHAIN
        temp.prev.next = null;
        tail = temp.prev;
      } else { // IT IS MIDDLE ELEMENT IN THE CHAIN OF MORE THAN TWO ELEMENTS
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
      }
    } else { // ONLY ONE ELEMENT IN THE CHAIN
      head = null;
      tail = null;
    }

    size--;
    return temp.data;
  }

  /**
   * Set an index position in the list to a new element
   * 
   * @param index   The index of the element to change
   * @param element The new element
   * @return The element that was replaced
   * @throws IndexOutOfBoundsException if the index is out of bounds
   * @throws NullPointerException      if null was set as a value.
   */
  public E set(int index, E element) {
    // TODO: Implement this method
    return null;
  }

  @Override
  public String toString() {

    String resStr = "";
    LLNode<E> tmp = head;

    while (tmp != null) {
      resStr += "data: " + tmp.data + "; prev: " + tmp.prev + "; next: " + tmp.next + "; address: " + tmp + "\n";

      tmp = tmp.next;
    }

    return resStr;
  }

  public void mergeSort() {
    if (head == null | head.next == null)
      return;

    LLNode<E> tmp;

    head = divideAndConquer(head);
    tmp = head;
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tail = tmp;
  }

  private LLNode<E> divideAndConquer(LLNode<E> nodes) {
    if (nodes.next == null)
      return nodes;

    LLNode<E> a = nodes;
    LLNode<E> b = findMid(a);

    b = b.next;
    b.prev.next = null;
    b.prev = null;

    a = divideAndConquer(a);
    b = divideAndConquer(b);

    return merge(a, b);
  }

  private LLNode<E> merge(LLNode<E> a, LLNode<E> b) {
    if (a == null)
      return b;
    if (b == null)
      return a;

    LLNode<E> c;

    E dataA = a.data;
    E dataB = b.data;

    if (dataA.compareTo(dataB) < 0) {
      c = a;
      c.next = merge(a.next, b);
    } else {
      c = b;
      c.next = merge(a, b.next);
    }
    c.next.prev = c;

    return c;
  }

  private LLNode<E> findMid(LLNode<E> nodes) {

    LLNode<E> slow = nodes;
    LLNode<E> fast = nodes.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  /**
   * My reverse list algorithm
   */
  public void reverse() {
    if (head == null | head.next == null)
      return;

    LLNode<E> tmp = tail;
    LLNode<E> tmp_2 = tail;

    tail = head;
    head = tmp;

    while (tmp != null) {
      tmp_2 = tmp_2.prev;
      tmp.prev = tmp.next;
      tmp.next = tmp_2;
      tmp = tmp.next;
    }
  }

  /**
   * Tests for my MergeSort and Revers MyDLL algorithm.
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

class LLNode<E> {
  LLNode<E> prev;
  LLNode<E> next;
  E data;

  LLNode(E e) {
    this.data = e;
    this.prev = null;
    this.next = null;
  }
}
