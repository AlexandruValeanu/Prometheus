package interview_questions;

import java.util.OptionalInt;

public class MajorityElement {
    private MajorityElement(){}

    public static OptionalInt compute(int[] array){
        return compute(array, 0, array.length);
    }

    public static OptionalInt compute(int[] array, int from, int to){
        if (array == null || from >= to)
            return OptionalInt.empty();

        int elem = array[from];
        int cnt = 1;

        for (int i = from + 1; i < to; i++) {
            if (array[i] == elem)
                cnt++;
            else
                cnt--;

            if (cnt == 0){
                elem = array[i];
                cnt = 1;
            }
        }

        cnt = 0;
        for (int i = from; i < to; i++) {
            if (array[i] == elem)
                cnt++;
        }

        if (2 * cnt > (to - from))
            return OptionalInt.of(elem);
        else
            return OptionalInt.empty();
    }
}
