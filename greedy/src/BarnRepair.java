import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
        // TODO
        Arrays.sort(occupied);
        int stalls = occupied.length;
        List<Integer> gaps = new ArrayList<>();
        for(int i=1; i<occupied.length; i++) {
            gaps.add(occupied[i] - occupied[i-1] -1);
        }
        Collections.sort(gaps);
        int boards = gaps.size() + 1;
        while(boards > M) {
            int gap = gaps.remove(0);
            stalls += gap;
            boards--;
        }
        return stalls;
    }

}