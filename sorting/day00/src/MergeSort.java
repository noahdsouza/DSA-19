import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime: O(n log(n)) since it divides in half recursively and the linearly sorts from there
     * Worst-case runtime: ""
     * Average-case runtime: ""
     *
     * Space-complexity: O(n) cause that feel right
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        if (array.length <= INSERTION_THRESHOLD) {
            InsertionSort insort = new InsertionSort();
            return insort.sort(array);
        } else {
            int mp = array.length/2;

            int[] left = new int[mp];
            System.arraycopy(array,0,left,0,mp);

            int[] right = new int[array.length-mp];
            System.arraycopy(array,mp,right,0,array.length-mp);

            int[] outleft = sort(left);
            int[] outright = sort(right);
//            System.out.println(Arrays.toString(merge(outleft,outright)));
            return merge(outleft,outright);
        }
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
        // TODO
        int[] ab = new int[a.length+b.length];
        int aind = 0;
        int bind = 0;
        int abind = 0;
        while (abind<a.length+b.length) {
            if (bind == b.length) {
                ab[abind] = a[aind];
                aind++;
                abind++;
            } else if (aind == a.length) {
                ab[abind] = b[bind];
                bind++;
                abind++;
            } else if (a[aind] <= b[bind]) {
                ab[abind] = a[aind];
                aind++;
                abind++;
            } else {
                ab[abind] = b[bind];
                bind++;
                abind++;
            }
        }
        return ab;
    }

}
