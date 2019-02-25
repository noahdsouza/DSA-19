import java.util.Arrays;
import java.util.Collections;

public class CountingSort {

    /**
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO
     * Time Complexity is O(n)
     * Space Complexity is O(k)
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        // TODO
        int k = 0;
        for (int i=0; i<A.length; i++) {

        }
//        get max #
//        make new array with size max+1
//        each index corresponds to a possible number in the input
//        the value at each index is how many times the number appears
//        replace numbers in old array based on the frequency array
//
//        k = max(A)
//        counts = new int[k+1]
//        for i in A
//          counts[i]++
//        i=0
//        for j from 0 --> k+1
//          while count[j] = 0
//              A[i] = j
//              count[j]--
//              i++
//
//        technically O(3n+k), which is just O(n)
//        this jawn don't work for negative numbers or decimals, and is hella inefficient for large arrays

    }

}
