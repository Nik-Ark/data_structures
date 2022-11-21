package hash_table.tests;

public class TestClass implements Comparable<TestClass> {
  private int id;

  public TestClass(int id) {
    this.id = id;
  }

  @Override
  public int compareTo(TestClass other) {
    return this.hashCode() - other.hashCode();
    // It could be also compared by id.
  }
}
