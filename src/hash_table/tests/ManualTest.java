package hash_table.tests;

import hash_table.myHashTable;

/**
 * @author Nikki
 * 
 * @category Manual Tests for myHashTable Class
 */
public class ManualTest {
  public static void main(String[] args) {
    myHashTable<String, Integer> dict = new myHashTable<>();

    dict.put("one", 1)
        .put("two", 2)
        .put("three", 3)
        .put("four", 4);

    System.out.println(dict.get("one"));
    System.out.println(dict.get("two"));
    System.out.println(dict.get("three"));
    System.out.println(dict.get("four"));
    System.out.println(dict.get("five"));

    dict.put("one", 100);
    dict.put("two", 200);
    dict.put("three", 300);
    dict.put("four", 400);

    System.out.println(dict.get("one"));
    System.out.println(dict.get("two"));
    System.out.println(dict.get("three"));
    System.out.println(dict.get("four"));

    dict.put("a", 100);
    dict.put("b", 200);
    dict.put("c", 300);
    dict.put("d", 400);
    dict.put("e", 100);
    dict.put("f", 200);
    dict.put("g", 300);
    dict.put("h", 400);
    dict.put("i", 100);
    dict.put("g", 200);
    dict.put("k", 300);
    dict.put("l", 400);
    dict.put("m", 100);
    dict.put("n", 200);
    dict.put("o", 300);
    dict.put("p", 400);
    dict.put("q", 100);
    dict.put("r", 200);
    dict.put("s", 300);
    dict.put("t", 400);
    dict.put("u", 100);
    dict.put("v", 200);
    dict.put("x", 300);
    dict.put("y", 400);
    dict.put("z", 100);
    dict.put("aa", 200);
    dict.put("bb", 300);
    dict.put("cc", 400);
    dict.put("dd", 100);
    dict.put("ee", 200);
    dict.put("ff", 200);
    dict.put("gg", 200);
    dict.put("hh", 200);
    dict.put("ii", 200);
    dict.put("jj", 200);
    dict.put("kk", 200);
    dict.put("ll", 200);

    dict.drawMe();

    myHashTable<TestClass, Integer> dict_obj = new myHashTable<>();

    TestClass t_1 = new TestClass(1);
    TestClass t_2 = new TestClass(2);
    TestClass t_3 = new TestClass(3);
    TestClass t_4 = new TestClass(4);
    TestClass t_5 = new TestClass(5);
    TestClass t_6 = new TestClass(6);
    TestClass t_7 = new TestClass(7);
    TestClass t_8 = new TestClass(8);
    TestClass t_9 = new TestClass(9);
    TestClass t_10 = new TestClass(10);

    dict_obj.put(t_1, 11);
    dict_obj.put(t_2, 22);

    System.out.println(dict_obj.get(t_1));
    System.out.println(dict_obj.get(t_2));

    dict_obj.put(t_1, 1);
    dict_obj.put(t_2, 2);

    System.out.println(dict_obj.get(t_1));
    System.out.println(dict_obj.get(t_2));

    dict_obj.put(t_3, 3);
    dict_obj.put(t_4, 4);
    dict_obj.put(t_5, 5);
    dict_obj.put(t_6, 6);
    dict_obj.put(t_7, 7);
    dict_obj.put(t_8, 8);
    dict_obj.put(t_9, 9);
    dict_obj.put(t_10, 10);

    dict_obj.drawMe();
  }
}
