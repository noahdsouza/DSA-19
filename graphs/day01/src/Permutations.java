import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<Integer> unused = new ArrayList<>();
        for(int c : A) unused.add(c);
        List<List<Integer>> permutations = new LinkedList<>();
        pHelper(new ArrayList<>(),unused,permutations);
        return permutations;
    }

    private static void pHelper(List<Integer> curr, List<Integer> unused, List<List<Integer>> perm) {
        if(unused.size() == 0) {
            perm.add(curr);
        }
        for(Integer i : unused) {
            List<Integer> ccopy = new ArrayList<>(curr);
            List<Integer> ucopy = new ArrayList<>(unused);
            ccopy.add(i);
            ucopy.remove(i);
            pHelper(ccopy,ucopy,perm);
        }
    }

}
