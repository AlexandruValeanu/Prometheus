import interview_questions.MajorityElement;
import org.junit.Test;

import java.util.OptionalInt;

import static org.junit.Assert.*;

public class MajorityElementTest {
    @Test
    public void compute() throws Exception {
        int[] a = {2, 2, 3, 5, 2, 2, 6};
        assertEquals(MajorityElement.compute(a), OptionalInt.of(2));

        int[] b = {1, 1, 2, 2};
        assertEquals(MajorityElement.compute(b), OptionalInt.empty());

        int c[] = new int[]{2,2,2,2,5,5,2,3,3};
        assertEquals(MajorityElement.compute(c), OptionalInt.of(2));
    }

    @Test
    public void compute1() throws Exception {
        int[] a = {1, 2, 2, 3, 1, 1};
        assertEquals(MajorityElement.compute(a, 1, 4), OptionalInt.of(2));
        assertEquals(MajorityElement.compute(a, 1, 5), OptionalInt.empty());
    }

}