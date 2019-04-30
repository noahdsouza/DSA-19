public class DungeonGame {

    public static int minInitialHealth(int[][] map) {
        // TODO: Your code here
//        Bottom-up
        int m = map.length;
        int n = map[0].length;

        int DP[][] = new int[m][n];

        if(map[m-1][n-1] > 0) {
            DP[m-1][n-1] = 1;
        }
        else {
            DP[m-1][n-1] = Math.abs(map[m-1][n-1])+1;
        }
        for(int i=m-2; i>=0; i--) {
            DP[i][n-1] = Math.max(DP[i+1][n-1] - map[i][n-1], 1);
        }
        for(int j=n-2; j>=0; j--) {
            DP[m-1][j] = Math.max(DP[m-1][j+1] - map[m-1][j], 1);
        }
        for(int k=m-2; k>=0; k--) {
            for(int p=n-2; p>=0; p--) {
                int ex = Math.min(DP[k+1][p], DP[k][p+1]);
                DP[k][p] = Math.max(ex - map[k][p], 1);
            }
        }
        return DP[0][0];
    }
}
