package doubly_linked_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: Add JUnit Tests for size() and remove()
// TODO: Also contains() method should be added.

/**
 * A class that implements a doubly linked list
 * 
 * @author Nikki
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyDLL<E> implements Iterable<E> {

  /*
   * Inner Class is accesible by default only in package.
   * 
   * It's Constructor accessible by default only in package,
   * and only through instance of the Outer Class.
   * 
   * If access modifer set to private, Both accessible only in Outer Class.
   * 
   */
  private class LLNode implements Comparable<LLNode> {
    private LLNode prev;
    private LLNode next;
    private E data;

    private LLNode(E obj) {
      this.data = obj;
      this.prev = null;
      this.next = null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(LLNode other) {
      return ((Comparable<E>) this.data).compareTo(other.data);
    }
  }

  private LLNode head;
  private LLNode tail;
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
   * @param element The element to add
   */
  public boolean add(E element) {
    if (head == null) {
      head = new LLNode(element);
      tail = head;
      size++;
      return true;
    }
    tail.next = new LLNode(element);
    tail.next.prev = tail;
    tail = tail.next;
    size++;
    return true;
  }

  public void addLast(E element) {
    add(element);
  }

  public void addFirst(E element) {
    if (head == null) {
      head = new LLNode(element);
      tail = head;
      size++;
    }
    head.prev = new LLNode(element);
    head.prev.next = head;
    head = head.prev;
    size++;
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
    LLNode temp = head;

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
   */
  public void add(int index, E element) {
    if (index > size | index < 0)
      throw new IndexOutOfBoundsException();

    LLNode tmp = head;
    int i = 0;

    while (i < index) {
      tmp = tmp.next;
      i++;
    }

    if (index == 0 && size == 0) { // LIST IS EMPTY, INDEX ARGUMENT IS ZERO
      head = new LLNode(element);
      tail = head;
    } else if (index == size) { // LIST HAS AT LEAST ONE ELEMENT, NODE INSERTED AFTER ALL OF THEM
      tail.next = new LLNode(element);
      tail.next.prev = tail;
      tail = tail.next;
    } else if (index == 0 && size > 0) { // LIST HAS AT LEAST ONE ELEMENT, NODE INSERTED AS FIRST
      tmp.prev = new LLNode(element);
      tmp.prev.next = tmp;
      head = head.prev;
    } else { // ELEMENT CHAINS SHOULD BE REARANGED
      tmp.prev.next = new LLNode(element);
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

  public boolean isEmpty() {
    return this.size == 0;
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
    LLNode temp = head;

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

  public E remove() {
    return remove(0);
  }

  /**
   * Set an index position in the list to a new element
   * 
   * @param index   The index of the element to change
   * @param element The new element
   * @return The element that was replaced
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public E set(int index, E element) {
    // TODO: Implement this method
    return null;
  }

  @Override
  public String toString() {

    String resStr = "";
    LLNode tmp = head;

    while (tmp != null) {
      resStr += "data: " + tmp.data + "; prev: " + tmp.prev + "; next: " + tmp.next + "; address: " + tmp + "\n";

      tmp = tmp.next;
    }

    return resStr;
  }

  public void mergeSort() {
    if (head == null | head.next == null)
      return;

    LLNode tmp;

    head = divideAndConquer(head);
    tmp = head;
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tail = tmp;
  }

  private LLNode divideAndConquer(LLNode nodes) {
    if (nodes.next == null)
      return nodes;

    LLNode a = nodes;
    LLNode b = findMid(a);

    b = b.next;
    b.prev.next = null;
    b.prev = null;

    a = divideAndConquer(a);
    b = divideAndConquer(b);

    return merge(a, b);
  }

  private LLNode merge(LLNode a, LLNode b) {
    if (a == null)
      return b;
    if (b == null)
      return a;

    LLNode c;

    if (a.compareTo(b) < 0) {
      c = a;
      c.next = merge(a.next, b);
    } else {
      c = b;
      c.next = merge(a, b.next);
    }
    c.next.prev = c;

    return c;
  }

  private LLNode findMid(LLNode nodes) {

    LLNode slow = nodes;
    LLNode fast = nodes.next;

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

    LLNode tmp = tail;
    LLNode tmp_2 = tail;

    tail = head;
    head = tmp;

    while (tmp != null) {
      tmp_2 = tmp_2.prev;
      tmp.prev = tmp.next;
      tmp.next = tmp_2;
      tmp = tmp.next;
    }
  }

  private class MyDLLIterator implements Iterator<E> {

    private LLNode source;

    private MyDLLIterator() {
      this.source = head;
    }

    @Override
    public boolean hasNext() {
      return this.source != null;
    }

    @Override
    public E next() {
      if (!this.hasNext())
        throw new NoSuchElementException("MyDLL's Iterator has no elements left");
      LLNode curr = this.source;
      this.source = this.source.next;
      return curr.data;
    }

  }

  @Override
  public Iterator<E> iterator() {
    return new MyDLLIterator();
  }
}
