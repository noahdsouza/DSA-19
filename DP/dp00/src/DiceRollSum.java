import java.util.HashMap;

public class DiceRollSum {

    // Runtime: TODO
        // Pretty sure this is O(n*c)
    // Space: TODO
        // O(n)
    public static int diceRollSum(int N) {
        return helper(N,new HashMap<Integer, Integer>());
    }

    private static int helper(int N, HashMap<Integer, Integer> subs) {
//        subs is a Hashmap with the current, iterated value of N as the key
//        the number of solution found for that N is the value

        /** Start subproblems */
//        base case
        if(subs.containsKey(N)) {
            return subs.get(N);
        }
//        easy shit where you can do 0 to N dice
        if(N <= 6) {
            int permutation = (int) Math.pow(2, N-1);
            if(N<=0) {
                subs.put(N, 1);
            } else {
                subs.put(N, permutation);
            }
        }
//        less easy shit where N is a thicc boi
        else {
            int counter = 0;
            for(int i=1; i<=6; i++) {
//                woot woot recursion ooh baby
//                this'll give every solution underneath N until we hit the earlier cases
                /** Memoize, bitch */
                counter += helper(N-i, subs);
            }
            subs.put(N, counter);
        }
        return subs.get(N);
    }

}
