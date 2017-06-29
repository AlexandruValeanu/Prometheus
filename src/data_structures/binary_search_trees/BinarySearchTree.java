package data_structures.binary_search_trees;

import data_structures.binary_search_trees.nodes.Node;
import data_structures.interfaces.iSortedMap;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BinarySearchTree<K, V> implements iSortedMap<K, V> {
    private final Comparator<? super K> comparator;

    public BinarySearchTree(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Optional<K> floor(K key) {
        return null;
    }

    @Override
    public Optional<K> ceiling(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public Optional<K> select(int k) {
        return null;
    }

    @Override
    public int countRange(K low, K high) {
        return 0;
    }

    @Override
    public Optional<K> deleteFirstKey() {
        return null;
    }

    @Override
    public Optional<K> deleteLastKey() {
        return null;
    }

    @Override
    public Iterable<K> keys(K low, K high) {
        return null;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    @Override
    public Comparator<? super K> comparator() {
        return null;
    }

    @NotNull
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;
    }

    @NotNull
    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }

    @NotNull
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }

    @Override
    public K firstKey() {
        return null;
    }

    @Override
    public K lastKey() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        return get(root, (K)key);
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /* Implementation below */

    private Node<K, V> root = null;

    private int size(Node<K, V> node){
        if (node == null)
            return 0;
        else
            return node.size;
    }

    @SuppressWarnings("unchecked")
    private V get(Node node, K key){
        if (node == null)
            return null;

        int cmp = comparator.compare(key, (K)node.getKey());

        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return (V)node.getValue();
    }
/*
    private Node<K, V> insert(Node<K, V> node, Map.Entry<K, V> entry){
        if (node == null)
            return new Node<>(entry);
        else if ()
    }*/
}
