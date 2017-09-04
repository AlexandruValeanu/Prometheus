package algorithms.arrays;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class ArrayBoxingUnboxing {
    private ArrayBoxingUnboxing(){}

    // Unboxed: for example int[] -> Integer[]

    public static int[] unbox(Integer[] array){
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    public static long[] unbox(Long[] array){
        return Arrays.stream(array).mapToLong(Long::longValue).toArray();
    }

    public static double[] unbox(Double[] array){
        return Arrays.stream(array).mapToDouble(Double::doubleValue).toArray();
    }

    // Boxed: for example int[] -> Integer[]

    public static Integer[] boxed(int[] array){
        return Arrays.stream(array).boxed().toArray(Integer[]::new);
    }

    public static Long[] boxed(long[] array){
        return Arrays.stream(array).boxed().toArray(Long[]::new);
    }

    public static Double[] boxed(double[] array){
        return Arrays.stream(array).boxed().toArray(Double[]::new);
    }

    // Wrappers over org.apache.commons.lang3.ArrayUtils.toPrimitive

    public static byte[] unbox(Byte[] byteArray){
        return ArrayUtils.toPrimitive(byteArray);
    }

    public static boolean[] unbox(Boolean[] booleanArray){
        return ArrayUtils.toPrimitive(booleanArray);
    }

    public static char[] unbox(Character[] charArray){
        return ArrayUtils.toPrimitive(charArray);
    }

    public static short[] unbox(Short[] shortArray){
        return ArrayUtils.toPrimitive(shortArray);
    }

    public static float[] unbox(Float[] floatArray){
        return ArrayUtils.toPrimitive(floatArray);
    }

    // Wrappers over org.apache.commons.lang3.ArrayUtils.toObject

    public static Byte[] boxed(byte[] byteArray){
        return ArrayUtils.toObject(byteArray);
    }

    public static Boolean[] boxed(boolean[] booleanArray){
        return ArrayUtils.toObject(booleanArray);
    }

    public static Character[] boxed(char[] charArray){
        return ArrayUtils.toObject(charArray);
    }

    public static Short[] boxed(short[] shortArray){
        return ArrayUtils.toObject(shortArray);
    }

    public static Float[] boxed(float[] floatArray){
        return ArrayUtils.toObject(floatArray);
    }
}
