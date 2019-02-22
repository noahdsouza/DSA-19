import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        // TODO
        int count = 0;
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++) {
            int l = i+1;
            int r = arr.length-1;
            int x = arr[i];
            while (l<r) {
                if (x+arr[l]+arr[r] == sum) {
                    count++;
                    l++;
                    r--;
                } else if (x+arr[l]+arr[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }
}
