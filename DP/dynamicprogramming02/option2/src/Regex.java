public class Regex {
//    Runtime: O(s.length * p.length)

    public static boolean isMatch(String s, String p) {
        // TODO
        boolean[][] DP = new boolean[s.length()+1][p.length()+1];
        DP[0][0] = true;
        for(int i=1; i<p.length()+1; i++) {
            if(p.charAt(i-1) == '*') {
                DP[0][i] = DP[0][i-2];
            }
        }
        return helper(s, p, DP);
    }
    private static boolean helper(String s, String p, boolean[][] DP) {
        for(int i=1; i<=s.length(); i++) {
            for(int j=1; j<=p.length(); j++) {
                if(DP[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1)) {
                    DP[i][j] = true;
                } else if(p.charAt(j-1) == '.' && DP[i-1][j-1]) {
                    DP[i][j] = true;
                } else if(p.charAt(j-1) == '*') {
                    DP[i][j] = DP[i][j-2];
                    if(p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) {
                        if(DP[i-1][j] || DP[i][j]) {
                            DP[i][j] = true;
                        }
                    }
                } else {
                    DP[i][j] = false;
                }
            }
        }
        return DP[s.length()][p.length()];
    }
}
