package data_structures.interfaces;

import java.util.Optional;
import java.util.SortedMap;

public interface iSortedMap<K, V> extends SortedMap<K, V> {
    // All keys must be unique.
    // Values cannot be null.

    Optional<K> floor(K key);   // largest key less than or equal to key
    Optional<K> ceiling(K key); // smallest key greater than or equal to key

    int rank(K key);            // number of keys less than key
    Optional<K> select(int k);  // key of rank k

    int countRange(K low, K high); // number of keys in [low..high]

    Optional<K> deleteFirstKey(); // delete smallest key
    Optional<K> deleteLastKey();  // largest key

    Iterable<K> keys(K low, K high); // keys in [lo..hi] , in sorted order
    Iterable<K> keys();              // all keys in the table, in sorted order
}
