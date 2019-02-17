public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        // TODO
//        if A[i] > both kids
//            stop
//        else
//            idx = max(A[i]'s kids')
//            swap i and idx
//            sink(A,idx)
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            // TODO
        }
//        for i = len(A)/2 -1 to 0
//            sink(A,i)
    }

    /**
     * Best-case runtime: O(n log(n))
     * Worst-case runtime: O(n log(n))
     * Average-case runtime: O(n log(n))
     *
     * Space-complexity: O(1)
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);

        for (int i=size-1; i>0; i--) {
            // TODO
        }

//        heapify(array);
//        for i=size-1 to 1
//            swap(array[1],array[0]);
//            size--;
//            sink(0)

        return heap;
    }
}
