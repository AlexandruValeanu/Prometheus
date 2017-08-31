package algorithms.strings;

public class ZAlgorithm {
    private ZAlgorithm(){}

    public static int[] compute(CharSequence str) {
        int L = 0, R = 0;
        int n = str.length();

        int[] z = new int[n];

        for (int i = 1; i < n; ++i) {
            if (i <= R)
                z[i] = Math.min(R - i + 1, z[i - L]);

            while (i + z[i] < n && str.charAt(z[i]) == str.charAt(i + z[i])) 
                z[i]++;

            if (i + z[i] - 1 > R) {
                L = i;
                R = i + z[i] - 1;
            }
        }

        z[0] = n;
        return z;
    }
}
