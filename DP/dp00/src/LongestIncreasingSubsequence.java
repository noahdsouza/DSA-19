import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static int counter = 0;

    // Runtime: TODO
//    O(n^2)
    // Space: TODO
//    O(1)
    public static int LIS(int[] A) {
        // TODO
        int n = A.length;
        counter = 0;
        helper(A,n);
        return counter;
    }
    private static int helper(int[] A, int n) {
//        get dem base cases tho
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int res;
        int maxEnd = 1;
        for(int i=1; i<n; i++) {
            res = helper(A, i);
            if(A[i-1]<A[n-1] && res+1>maxEnd) {
                maxEnd = res+1;
            }
        }
        if(counter<maxEnd) {
            counter = maxEnd;
        }
        return maxEnd;
    }
}