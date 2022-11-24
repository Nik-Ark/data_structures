package hash_table.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hash_table.myHashTable;

public class RemoveTest {

  myHashTable<String, Integer> dict = new myHashTable<>();
  myHashTable<TestClass, String> dict_obj = new myHashTable<>();

  TestClass testClassObject_1 = new TestClass(1);
  TestClass testClassObject_2 = new TestClass(2);
  TestClass testClassObject_3 = new TestClass(3);
  TestClass testClassObject_4 = new TestClass(4);

  @BeforeEach
  public void setUp() {

    dict
        .put("one", 1)
        .put("two", 2)
        .put("three", 3)
        .put("four", 4);

    dict_obj
        .put(testClassObject_1, "First Object")
        .put(testClassObject_2, "Second Object")
        .put(testClassObject_3, "Third Object")
        .put(testClassObject_4, "Fourth Object");
  }

  @Test
  public void testRemovefromHashTable() {

    /**************************************************************************/
    /******************* myHashTable<String, Integer> *************************/
    /**************************************************************************/

    assertEquals(dict.get("one"), 1);
    assertEquals(dict.remove("one"), 1);
    assertTrue(dict.get("one") == null);

    assertEquals(dict.get("three"), 3);
    assertEquals(dict.remove("three"), 3);
    assertTrue(dict.get("three") == null);

    /*************************************************************************/
    /******************* myHashTable<TestClass, String> **********************/
    /*************************************************************************/

    assertEquals(dict_obj.get(testClassObject_1), "First Object");
    assertEquals(dict_obj.remove(testClassObject_1), "First Object");
    assertTrue(dict_obj.get(testClassObject_1) == null);

    assertEquals(dict_obj.get(testClassObject_3), "Third Object");
    assertEquals(dict_obj.remove(testClassObject_3), "Third Object");
    assertTrue(dict_obj.get(testClassObject_3) == null);
  }
}
