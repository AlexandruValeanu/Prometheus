package algorithms.number_theory;

public class GreatestCommonDivisor {
    private GreatestCommonDivisor(){}

    public static int gcd(int x, int y){
        x = Math.abs(x);
        y = Math.abs(y);

        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }

        return x;
    }

    public static long gcd(long x, long y){
        x = Math.abs(x);
        y = Math.abs(y);

        while (y != 0) {
            long r = x % y;
            x = y;
            y = r;
        }

        return x;
    }

    public static int lcm(int x, int y){
        return x * y / gcd(x, y);
    }

    public static int lcmExact(int x, int y){
        return Math.multiplyExact(x, y) / gcd(x, y);
    }

    public static long lcm(long x, long y){
        return x * y / gcd(x, y);
    }

    public static long lcmExact(long x, long y){
        return Math.multiplyExact(x, y) / gcd(x, y);
    }

    public static int binaryGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == b)
            return a;

        if (a == 0 || b == 0)
            return a + b;

        if ((~a & 1) == 1) { /// a is even
            if ((b & 1) == 1) ///b is odd
                return gcd(a >> 1, b);
            else
                return gcd(a >> 1, b >> 1) << 1;
        }
        else { ///a is odd
            if ((~b & 1) == 1) ///b is even
                return gcd(a, b >> 1);
        }

        if (a > b)
            return gcd((a - b) >> 1, b);
        else
            return gcd((b - a) >> 1, a);
    }

    public static long binaryGCD(long a, long b) {
        if (a == b)
            return a;

        if (a == 0 || b == 0)
            return a + b;

        if ((~a & 1) == 1) { /// a is even
            if ((b & 1) == 1) ///b is odd
                return gcd(a >> 1, b);
            else
                return gcd(a >> 1, b >> 1) << 1;
        }
        else { ///a is odd
            if ((~b & 1) == 1) ///b is even
                return gcd(a, b >> 1);
        }

        if (a > b)
            return gcd((a - b) >> 1, b);
        else
            return gcd((b - a) >> 1, a);
    }
}
