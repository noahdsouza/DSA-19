package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    private LinkedList<Integer> ll = new LinkedList();

    public void enqueue(int item) {
        // TODO
        ll.addLast(item);
    }

    /**
     * Return and remove the largest item on the queue.
     * Should be O(n)???
     */
    public int dequeueMax() {
        // TODO
        int runs = 0;
        int large = 0;
        while (runs < ll.size()) {
            if (ll.get(runs) > large) {
                large = ll.get(runs);
            }
            runs = runs+1;
        }
        ll.remove(ll.indexOf(large));
        return large;
    }

}