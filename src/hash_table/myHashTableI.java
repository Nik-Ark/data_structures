package hash_table;

public interface myHashTableI<K extends Comparable<? super K>, V> {
  public myHashTable<K, V> put(K key, V value);
}
