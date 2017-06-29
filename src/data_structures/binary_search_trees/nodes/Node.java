package data_structures.binary_search_trees.nodes;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

public class Node<K, V> {
    final private Map.Entry<K, V> entry;
    final public Node<K, V> left, right;
    public int size;

    public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
        this.entry = new AbstractMap.SimpleImmutableEntry<>(key, value);
        this.left = left;
        this.right = right;
        this.size = 1;

        update();
    }

    public Node(Map.Entry<K, V> entry, Node<K, V> left, Node<K, V> right) {
        this.entry = entry;
        this.left = left;
        this.right = right;

        update();
    }

    public Node(K key, V value){
        this(key, value, null, null);
    }

    public Node(Map.Entry<K, V> entry){
        this(entry, null, null);
    }

    public K getKey() {
        return entry.getKey();
    }

    public V getValue() {
        return entry.getValue();
    }

    public void update(){
        this.size = 1;

        if (left != null)
            this.size += left.size;

        if (right != null)
            this.size += right.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(entry, node.entry) &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entry, left, right);
    }
}
