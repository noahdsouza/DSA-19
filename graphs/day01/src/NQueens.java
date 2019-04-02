import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NQueens {


    /**
     * Checks the 45° and 135° diagonals for an existing queen. For example, if the board is a 5x5
     * and you call checkDiagonal(board, 3, 1), The positions checked for an existing queen are
     * marked below with an `x`. The location (3, 1) is marked with an `o`.
     *
     * ....x
     * ...x.
     * x.x..
     * .o...
     * .....
     *
     * Returns true if a Queen is found.
     *
     * Do not modify this function (the tests use it)
     */
    public static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
        return false;
    }

//    private static boolean safe(char[][] board, int r, int c) {
//        boolean diag = checkDiagonal(board,r,c);
////        boolean horz = true;
//        boolean vert = true;
//
//        for(int i=0; i<c; i++) {
//            if(board[r][i]=='Q') {
//                vert = false;
//            }
//        }
//        if(diag && vert) {
//            return true;
//        } else {
//            return false;
//        }
//    }


    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }


    public static List<char[][]> nQueensSolutions(int n) {
        // TODO
//        blank = '.', Queen = 'Q'
//        one queen per row
//        use each column only ONCE
//        quit if a queen violates checkDiagonal
        List<char[][]> answers = new ArrayList<>();
        HashMap<Integer, Boolean> r = new HashMap<>();
        for(int k=0; k<n; k++) {
            r.put(k,false);
        }
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board,answers,r,0);
        return answers;
    }

    /* don't be convinced that you are right */
    private static void helper(char[][] board, List<char[][]> perm, HashMap<Integer,Boolean> r, int cnum) {
        int n = board.length;
        if(cnum==board.length) {
            perm.add(copyOf(board));
            return;
        }
        for(int i=0; i<n; i++) {
            if(!r.get(i) && !checkDiagonal(board, cnum, i)) {
                board[cnum][i] = 'Q';
                r.replace(i, true);
                helper(board,perm,r,cnum+1);
                board[cnum][i] = '.';
                r.replace(i,false);
            }
        }
    }

}
