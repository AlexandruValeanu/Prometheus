package data_structures.triple;

import data_structures.triple.immutable.ImmutableTriple;
import data_structures.triple.mutable.MutableTriple;
import org.jetbrains.annotations.NotNull;

public interface Triple<T, S, U> {

    T getFirst();

    void setFirst(T first);

    S getSecond();

    void setSecond(S second);

    U getThird();

    void setThird(U third);

    @NotNull
    static <T1, T2, T3> Triple<T1, T2, T3> valueOf(@NotNull org.apache.commons.lang3.tuple.Triple<T1, T2, T3> apacheTriple){
        return new MutableTriple<>(apacheTriple.getLeft(), apacheTriple.getMiddle(), apacheTriple.getRight());
    }

    @NotNull
    static <T1, T2, T3> Triple<T1, T2, T3> valueOfImmutable(@NotNull org.apache.commons.lang3.tuple.Triple<T1, T2, T3> apacheTriple){
        return new ImmutableTriple<>(apacheTriple.getLeft(), apacheTriple.getMiddle(), apacheTriple.getRight());
    }

    @NotNull
    static  <T1, T2, T3> Triple<T1, T2, T3> valueOf(T1 firstElement, T2 secondElement, T3 thirdElement){
        return new MutableTriple<>(firstElement, secondElement, thirdElement);
    }

    @NotNull
    static  <T1, T2, T3> Triple<T1, T2, T3> valueOfImmutable(T1 firstElement, T2 secondElement, T3 thirdElement){
        return new ImmutableTriple<>(firstElement, secondElement, thirdElement);
    }

    default org.apache.commons.lang3.tuple.Triple<T, S, U> toApacheTriple(){
        return new org.apache.commons.lang3.tuple.MutableTriple<>(getFirst(), getSecond(), getThird());
    }

    default org.apache.commons.lang3.tuple.Triple<T, S, U> toApacheTripleImmutable(){
        return new org.apache.commons.lang3.tuple.ImmutableTriple<>(getFirst(), getSecond(), getThird());
    }
}
