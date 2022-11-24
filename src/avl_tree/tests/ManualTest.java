package avl_tree.tests;

import java.util.LinkedList;

import avl_tree.MyAVLTree;

public class ManualTest {
  static final Integer intArr[] = { 100, 200, 50, 90, 30, 40, 99, 25, 70, 150, 170, 230, 130, 250 };
  static final String strArr[] = { "N", "H", "U", "X", "K", "R", "E", "G", "L", "J", "T", "V", "M" };

  public static void main(String[] args) {

    /* It is possible to add null into LinkedList data structure */
    LinkedList<String> strL = new LinkedList<>();
    strL.add(null);
    strL.add(null);
    strL.add(null);
    strL.add(null);

    for (String el : strL) {
      System.out.println(el);
    }

    MyAVLTree<Integer> avl_int = new MyAVLTree<>(intArr);
    avl_int.drawMe();

    avl_int.remove(100);
    avl_int.drawMe();

    avl_int.remove(50);
    avl_int.drawMe();

    avl_int.remove(70);
    avl_int.drawMe();

    avl_int.remove(30);
    avl_int.drawMe();

    avl_int.remove(200);
    avl_int.drawMe();

    avl_int.remove(150);
    avl_int.drawMe();
  }
}
