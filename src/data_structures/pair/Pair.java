package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface Pair<T, S> {

    T getFirst();

    void setFirst(T first);

    S getSecond();

    void setSecond(S second);

    Map.Entry<T, S> toMapEntry();
    Map.Entry<T, S> toMapEntryImmutable();

    @NotNull
    static <U, V> Pair<U, V> valueOf(@NotNull org.apache.commons.lang3.tuple.Pair<U, V> apachePair){
        return new MutablePair<>(apachePair.getLeft(), apachePair.getRight());
    }

    @NotNull
    static  <U, V> Pair<U, V> valueOfImmutable(@NotNull org.apache.commons.lang3.tuple.Pair<U, V> apachePair){
        return new ImmutablePair<>(apachePair.getLeft(), apachePair.getRight());
    }

    @NotNull
    static  <U, V> Pair<U, V> valueOf(U firstElement, V secondElement){
        return new MutablePair<>(firstElement, secondElement);
    }

    @NotNull
    static  <U, V> Pair<U, V> valueOfImmutable(U firstElement, V secondElement){
        return new ImmutablePair<>(firstElement, secondElement);
    }

    default org.apache.commons.lang3.tuple.Pair<T, S> toApachePair(){
        return new org.apache.commons.lang3.tuple.MutablePair<>(getFirst(), getSecond());
    }

    default org.apache.commons.lang3.tuple.Pair<T, S> toApachePairImmutable(){
        return new org.apache.commons.lang3.tuple.ImmutablePair<>(getFirst(), getSecond());
    }
}
