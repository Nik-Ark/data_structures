package hash_table;

import doubly_linked_list.MyDLL;

public class myHashTable<K extends Comparable<? super K>, V> implements myHashTableI<K, V> {

  private class HashElement {
    private K key;
    private V value;
    private int hash;

    private HashElement(K key, V value, int hash) {
      this.key = key;
      this.value = value;
      this.hash = hash;
    }

    @Override
    public String toString() {
      return "[key: " + this.key.toString() + ", value: " + this.value + " ]";
    }
  }

  // TODO: Consider adding next methods: clear(), keys(), values()

  // Predifined Array of Prime numbers for tableSize of hashTable:
  private static final int[] primes = { 13, 29, 61, 131, 271, 547, 1097, 2207, 4409, 8807, 17609, 35221 };
  private static final double MAX_LOAD_FACTOR = 0.75; // default in Java API and is 0.75
  private int mod;
  private int tableSize; // Use Prime numbers for better node's distribution. By default 16 in Java API.
  private int size;
  private double loadFactor;
  private MyDLL<HashElement>[] hashTable;

  @SuppressWarnings("unchecked")
  public myHashTable() {
    this.mod = 0;
    this.tableSize = primes[this.mod];
    this.size = 0;
    this.loadFactor = 0;
    this.hashTable = new MyDLL[tableSize]; // Unnecessary type casting: (MyDLL<HashElement>[])

    for (int i = 0; i < this.tableSize; i++) {
      this.hashTable[i] = new MyDLL<>();
    }
  }

  // It would be most effective to use key.hashCode(). (Java API version)
  // Method which is present by default (or implemented by creator of Class)
  // for every type (Class) in Java.
  // Here I rewrite the Java's hashCode() method for Strings.
  // Example: hashFunction(K key) { return key.hashCode() & 0x7fffffff }
  private int hashFunction(String str) {
    int gPrime = 31;
    int hash = 0;
    for (int i = 0; i < str.length(); i++)
      hash = gPrime * hash + str.charAt(i);
    return hash;
  }

  // This function can be ommited. (Exists for explicit display of logic steps)
  private int getHash(K key) {
    int hash = hashFunction(key.toString());
    return hash & 0x7fffffff; // to make negative int positive, and positive won't be modifed.
  }

  private boolean resize() {
    // TODO: Implement this method.
    System.out.println("This load factor is out of max bound: " + this.loadFactor);
    System.out.println("This size: " + this.size);
    return true;
  }

  private HashElement getChainNodeByKey(MyDLL<HashElement> chainRoot, K key) {
    for (HashElement element : chainRoot) {
      if (element.key.compareTo(key) == 0)
        return element;
    }
    return null;
  }

  public myHashTable<K, V> put(K key, V value) {
    if (key == null | value == null)
      throw new IllegalArgumentException("Can't accept null as one of arguments");

    // SHOULD I ALWAYS CALL TOSTRING() ON KEYS IN THE FIRST PLACE ?
    // The answer is No, beacuse creator of the Class will be forced to create
    // compareTo() method for comparing Keys.

    int hash = getHash(key);
    int index = hash % this.tableSize;

    MyDLL<HashElement> chainRoot = this.hashTable[index];
    HashElement node = getChainNodeByKey(chainRoot, key);

    if (node != null) {
      node.value = value;
      return this;
    }

    chainRoot.addLast(new HashElement(key, value, hash));
    this.size++;
    this.loadFactor = this.size / this.tableSize;

    if (this.loadFactor >= MAX_LOAD_FACTOR)
      resize();

    return this;
  }

  private HashElement getNode(K key) {
    int hash = getHash(key);
    int index = hash % this.tableSize;

    MyDLL<HashElement> chainRoot = this.hashTable[index];
    HashElement node = getChainNodeByKey(chainRoot, key);
    if (node != null)
      return node;

    return null;
  }

  public V get(K key) {
    if (key == null)
      throw new IllegalArgumentException("Can't accept null as argument");

    // java.util implementation:
    HashElement element;
    return (element = getNode(key)) == null ? null : element.value;
  }

  public boolean containsKey(K key) {
    if (key == null)
      throw new IllegalArgumentException("Can't accept null as argument");

    // java.util implementation:
    return getNode(key) != null;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public V remove(K key) {
    if (key == null)
      throw new NullPointerException();

    int hash = getHash(key);
    int index = hash % this.tableSize;

    MyDLL<HashElement> chainRoot = this.hashTable[index];
    HashElement nodeToRemove = null;

    int i = 0;
    for (HashElement chainNode : chainRoot) {
      if (chainNode.key.compareTo(key) == 0) {
        nodeToRemove = chainNode;
        break;
      }
      i++;
    }

    if (nodeToRemove == null)
      return null;

    this.size--;
    this.loadFactor = this.size / this.tableSize;
    return chainRoot.remove(i).value;
  }

  public void drawMe() {
    for (int i = 0; i < this.tableSize; i++) {
      MyDLL<HashElement> chain = this.hashTable[i];
      System.out.println("HashTable[" + i + "]:");

      /*
       * The Same effect in this For Loop as in Enhanced For Loop in code beneath :
       * for (int j = 0; j < chain.size(); j++) {
       * System.out.print(chain.get(j));
       * System.out.print("; ");
       * }
       */

      for (HashElement node : chain) {
        System.out.print(node);
        System.out.print("; ");
        System.out.print("\n");
      }
      System.out.print("\n");
    }
  }
}
