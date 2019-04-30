import java.util.Arrays;

public class SplitCoins {
//    Top-Down
    public static int splitCoins(int[] coins) {
        // TODO)
        int sum = 0;
        int n = coins.length;
        for(int i=0; i<coins.length; i++) {
            sum = sum + coins[i];
        }
        int[][] DP = new int[coins.length+1][sum];
        for(int i=0; i<DP.length; i++) {
            for(int j=0; j<DP[0].length; j++) {
                DP[i][j] = -1;
            }
        }
        return helper(coins,n,0,sum, DP);
    }
    private static int helper(int[] coins, int n, int calc, int sum, int[][] DP) {
        if(n==0) {
            return Math.abs(2*calc-sum);
        }
        if(DP[n-1][calc]==-1) {
            DP[n-1][calc] = Math.min(helper(coins,n-1,calc+coins[n-1],sum, DP), helper(coins,n-1,calc,sum, DP));
        } else {
            return DP[n-1][calc];
        }
        return DP[n-1][calc];
    }
}
