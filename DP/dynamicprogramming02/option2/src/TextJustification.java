import java.util.LinkedList;
import java.util.List;

public class TextJustification {

    private static double cost(String[] words, int lo, int hi, int m) {
        if (hi <= lo)
            throw new IllegalArgumentException("Hi must be higher than Lo");
        int length = hi-lo-1; // account for spaces;
        for (int i = lo; i < hi; i++) {
            length += words[i].length();
        }
        if (length > m)
            return Double.POSITIVE_INFINITY;
        return Math.pow(m-length, 3);
    }

    public static List<Integer> justifyText(String[] w, int m) {
        // TODO
        int n = w.length;
        int[][] DP = new int[n+1][n+1];
        int[][] line_cost = new int[n+1][n+1];
        int[] opt = new int[n+1];
        int[] solution = new int[n+1];

        for(int i=1; i<=n; i++) {
            DP[i][i] = m;
        }

        return null;
    }

}