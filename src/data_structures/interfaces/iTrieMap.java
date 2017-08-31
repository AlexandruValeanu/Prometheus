package data_structures.interfaces;

public interface iTrieMap<Value> {
    void put(CharSequence key, Value value);
    Value get(CharSequence key);
    Value remove(CharSequence key);
    boolean contains(CharSequence key);

    int countOccurrences(CharSequence seq);
    int countStartWith(CharSequence seq);

    int longestPrefixOf(CharSequence seq);

    Iterable<CharSequence> keysWithPrefix(CharSequence seq);
    Iterable<CharSequence> keys();

    boolean isEmpty();
    int size();
}
