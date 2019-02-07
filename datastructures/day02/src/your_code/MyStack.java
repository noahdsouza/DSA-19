package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    LinkedList <Integer> maxes = new LinkedList();

    public MyStack() {
        ll = new LinkedList<>();
    }


    @Override
    public void push(Integer e) {
        ll.addFirst(e);
        if (ll.size() == 1) {
            maxes.addFirst(e);
        } else if (e > (int) maxes.getFirst()) {
            maxes.addFirst(e);
        }
    }

    @Override
    public Integer pop() {
        if (ll.getFirst() == maxes.getFirst()) {
            maxes.removeFirst();
        }
        Integer pop = ll.removeFirst();
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        // TODO
        return maxes.getFirst();
    }
}
