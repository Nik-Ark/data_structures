package hash_table;

import java.util.LinkedList;

public class myHashTable<K extends Comparable<? super K>, V> {

  class HashElement<K, V> {
    private K key;
    private V value;
    private int hash;

    public HashElement(K key, V value, int hash) {
      this.key = key;
      this.value = value;
      this.hash = hash;
    }
  }

  private int tableSize;
  private int size;
  private double loadFactor;
  private double MAX_LOAD_FACTOR;
  private LinkedList<HashElement<K, V>> hashTable[];

  public myHashTable(int tableSize, double maxLoadFactor) {
    this.tableSize = tableSize;
    this.size = 0;
    this.loadFactor = 0;
    this.MAX_LOAD_FACTOR = maxLoadFactor;
    this.hashTable = new LinkedList[tableSize]; // Unnecessary type casting: (LinkedList<HashElement<K, V>>[])
  }

  public myHashTable() {
    this(13, 3);
  }

  private int hashFunction(String str) {
    int gPrime = 31;
    int hash = 0;
    for (int i = 0; i < str.length(); i++)
      hash = gPrime * hash + str.charAt(i);
    return hash;
  }

  private int getHash(K key) {
    int hash = hashFunction(key.toString());
    return hash & 0x7fffffff;
  }

  private boolean rehash() {
    // TODO: Implement this method.
    System.out.println("This load factor is out of max bound: " + this.loadFactor);
    System.out.println("This size: " + this.size);
    return true;
  }

  private HashElement<K, V> getChainNodeByKey(LinkedList<HashElement<K, V>> chainRoot, K key) {
    for (HashElement<K, V> element : chainRoot) {
      if (element.key.compareTo(key) == 0)
        return element;
    }
    return null;
  }

  public myHashTable<K, V> put(K key, V value) {
    if (key == null | value == null)
      throw new IllegalArgumentException("Can't accept null as one of arguments");

    // SHOULD I ALWAYS CALL TOSTRING() ON KEYS IN THE FIRST PLACE ?

    if (this.loadFactor >= this.MAX_LOAD_FACTOR)
      rehash();

    int hash = getHash(key);
    int index = hash % this.tableSize;

    HashElement<K, V> elementToAdd = new HashElement<>(key, value, hash);
    LinkedList<HashElement<K, V>> chainRoot = this.hashTable[index];
    if (chainRoot == null) {
      LinkedList<HashElement<K, V>> newChain = new LinkedList<>();
      newChain.add(elementToAdd);
      this.hashTable[index] = newChain;
    } else {
      HashElement<K, V> node = getChainNodeByKey(chainRoot, key);
      if (node != null) {
        node.value = value;
        return this;
      } else {
        chainRoot.addLast(elementToAdd);
      }
    }
    this.size++;
    this.loadFactor = (double) this.size / this.tableSize;
    return this;
  }

  private HashElement<K, V> getNode(K key) {
    int hash = getHash(key);
    int index = hash % this.tableSize;

    LinkedList<HashElement<K, V>> chainRoot = this.hashTable[index];
    if (chainRoot != null) {
      HashElement<K, V> node = getChainNodeByKey(chainRoot, key);
      if (node != null)
        return node;
    }
    return null;
  }

  public V get(K key) {
    if (key == null)
      throw new IllegalArgumentException("Can't accept null as argument");

    // java.util implementation:
    HashElement<K, V> element;
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

  /* Manual test: */
  public static void main(String[] args) {
    myHashTable<String, Integer> dict = new myHashTable<>();

    dict.put("one", 1);
    dict.put("two", 2);
    dict.put("three", 3);
    dict.put("four", 4);

    System.out.println(dict.size());

    System.out.println(dict.get("one"));
    System.out.println(dict.get("two"));
    System.out.println(dict.get("three"));
    System.out.println(dict.get("four"));
    System.out.println(dict.get("five"));

    dict.put("one", 100);
    dict.put("two", 200);
    dict.put("three", 300);
    dict.put("four", 400);

    System.out.println(dict.size());

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

    System.out.println(dict.size());
  }
}
