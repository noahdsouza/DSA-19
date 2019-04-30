public class EditDistance {

    public static int minEditDist(String a, String b) {
        // TODO: Your code here
//        This is literally just Levenshtein Distance but okay
//        Bottom-up
        int DP[][] = new int[a.length()+1][b.length()+1];
        for(int i=0; i<=a.length(); i++) {
            for(int j=0; j<=b.length(); j++) {
                if(i==0) {
                    DP[i][j] = j;
                } else if(j==0) {
                    DP[i][j] = i;
                } else {
                    int temp1 = DP[i - 1][j - 1] + subCost(a.charAt(i - 1),b.charAt(j - 1));
                    int temp2 = DP[i - 1][j] + 1;
                    int temp3 = DP[i][j - 1] + 1;
                    DP[i][j] = Math.min(temp1,Math.min(temp2,temp3));
                }
            }
        }
        return DP[a.length()][b.length()];
    }

    private static int subCost(char A, char B) {
        if(A==B) {
            return 0;
        } else {
            return 1;
        }
    }
}
