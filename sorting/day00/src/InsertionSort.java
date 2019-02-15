
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * TODO
     * Best-case runtime: O(n) when the list is already sorted
     * Worst-case runtime: O(n^2) when the list is sorted in reverse
     * Average-case runtime: O(n^2) again, just less time if it's not the worst case
     *
     * Space-complexity: O(1) since no new arrays are made
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        int i = 1;
        while (i < array.length) {
            int x = array[i];
            int j = i-1;
            while (j>=0 && array[j]>x) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = x;
            i++;
        }
        return array;
    }
}
