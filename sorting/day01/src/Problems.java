import java.util.*;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size() / 2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size() / 2 - 1)) / 2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad (sad)! We provide it here for testing purposes
    public static double[] runningMedianReallySlowly(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        System.out.println("out" + Arrays.toString(out));
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        // TODO
        PriorityQueue<Integer> mins = minPQ(); // add larg bois here
        PriorityQueue<Integer> maxs = maxPQ(); // add smol bois here
        double last_med = 0;
        if (inputStream.length != 0) {
            runningMedian[0] = inputStream[0];
        }
        for (int k=0; k<inputStream.length; k++) {
            if (inputStream[k]>=last_med) {
                mins.offer(inputStream[k]);
            } else {
                maxs.offer(inputStream[k]);
            }
            if (mins.size() > maxs.size()+1) {
                maxs.offer(mins.poll());
            }
            if (maxs.size() > mins.size()) {
                mins.offer(maxs.poll());
            }
            if (mins.size() > maxs.size()) {
                last_med = mins.peek();
            }
            if (mins.size() == maxs.size()) {
                last_med = ((((((((((((double) mins.peek())+ ((double)maxs.peek()))/2)))))))));
            }
            runningMedian[k] = last_med;
        }
        System.out.println("oof" + Arrays.toString(runningMedian));
        return runningMedian;
    }
}
