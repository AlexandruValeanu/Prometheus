package test;

import algorithms.divide_conquer.NumberOfInversions;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfInversionsTest {
    @Test
    public void countInversions() throws Exception {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(NumberOfInversions.countInversions(a), a.length * (a.length - 1) / 2);

        int[] b = {3, 4, 1, 2, 5};
        assertEquals(NumberOfInversions.countInversions(b), 4);

        int[] c = {1, 20, 6, 4, 5};
        assertEquals(NumberOfInversions.countInversions(c), 5);

        int d[] = {8, 4, 2, 1};
        assertEquals(NumberOfInversions.countInversions(d), 6);

        int e[] = {1, 1, 1, 2, 2};
        assertEquals(NumberOfInversions.countInversions(e), 0);

        int f[] = {2, 1, 3, 1, 2};
        assertEquals(NumberOfInversions.countInversions(f), 4);
    }

    @Test
    public void countInversionsRange() throws Exception {
        int[] a = {1, 3, 2, 5, 4};
        assertEquals(NumberOfInversions.countInversions(a, 1, 4), 1);
        assertEquals(NumberOfInversions.countInversions(a, 1, a.length), 2);

        int[] b = {3, 2, 2, 2, 1, 5};
        assertEquals(NumberOfInversions.countInversions(b, 1, 5), 3);
    }

}