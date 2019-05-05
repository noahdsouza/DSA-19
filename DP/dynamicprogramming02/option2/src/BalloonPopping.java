import java.util.Arrays;

public class BalloonPopping {

    public static int maxPoints(int[] B) {
        // TODO
        int[] A = new int[B.length+2];
        A[0] = 1;
        A[A.length-1] = 1;
        for(int i=0; i<B.length; i++) {
            A[i+1] = B[i];
        }
        int[][] DP = new int[A.length][A.length];
        for(int j=0; j<A.length; j++) {
            for(int k=0; k<A.length; k++) {
                DP[j][k] = 0;
            }
        }
        for(int m=1; m<A.length-1; m++) {
            for(int n=m; n>=1; n--) {
                for(int o=n; o<=m; o++) {
                    int choice1 = A[n-1]*A[o]*A[m+1] + DP[n][o-1] + DP[o+1][m];
                    int choice2 = DP[n][m];
                    DP[n][m] = Math.max(choice1, choice2);
                }
            }
        }
//        System.out.println(Arrays.deepToString(DP));
        return DP[1][A.length-2];
    }
}
