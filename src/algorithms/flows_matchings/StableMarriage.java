package algorithms.flows_matchings;

import java.util.ArrayDeque;
import java.util.Queue;

public class StableMarriage {
    private StableMarriage(){}

    static int[] stableMarriage(int[][] menPreffs, int[][] womenPreffs){
        final int N = menPreffs.length;

        int[][] mapWomanToMan = new int[N][N];
        int[] womanMatch = new int[N];
        int[] manMatch = new int[N];

        for (int i = 0; i < N; ++i){
            womanMatch[i] = -1;
            manMatch[i] = -1;
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                mapWomanToMan[i][ womenPreffs[i][j] ] = j;

        Queue<Integer> bachelors = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            bachelors.add(i);
        }

        while (!bachelors.isEmpty()){
            int man = bachelors.remove();

            for (int woman : menPreffs[man]){
                if (womanMatch[woman] == -1){
                    womanMatch[woman] = man;
                    manMatch[man] = woman;
                    break;
                }
                else{
                    int otherMan = womanMatch[woman];

                    if (mapWomanToMan[woman][man] < mapWomanToMan[woman][otherMan]){
                        bachelors.add(otherMan);
                        manMatch[otherMan] = -1;

                        womanMatch[woman] = man;
                        manMatch[man] = woman;
                        break;
                    }
                }
            }
        }

        return manMatch;
    }
}
