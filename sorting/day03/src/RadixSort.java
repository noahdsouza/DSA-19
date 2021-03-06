import java.util.Arrays;
import java.util.LinkedList;

public class RadixSort {

    /**
     * @param n the digit number, 0 is least significant
     * @return
     */
    private static int getNthDigit(int number, int base, int n) {
        return number / ((int) Math.pow(base, n)) % base;
    }


    /**
     * Use counting sort to sort the integer array according to a digit
     *
     * @param b The base used in radix sort
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByDigit(int[] A, int b, int n) {
        LinkedList<Integer>[] L = new LinkedList[b];
        for (int i = 0; i < b; i++)
            L[i] = new LinkedList<>();

        for (int i : A) {
            // TODO: Extract the relevant digit from i, and add i to the corresponding Linked List.
            int reldig = getNthDigit(i,b,n);
            L[reldig].add(i);

//            create base structure (0 to 9 keyset)
//            if ones place of digit matches key, then it goes with that key
//            then sort by tens place digit after outputting that hashmap to an array
//            then do it again by the hundreds place and so on
//            also, it's not a hashmap. It's a linked list of linked lists because fuck you.
//
//            k = max(A)
//            w = logb(k)
//            for i from 0 to w
//              countingsortbydigit(A,b,i)
        }
        int j = 0; // index in A to place numbers
        for (LinkedList<Integer> list : L) {
            // TODO: Put all numbers in the linked lists into A
            for (int k : list) {
                A[j] = k;
                if (j<A.length-1) {
                    j++;
                }
            }
        }
    }

    /**
     * Runtime: TODO: Express your runtime in terms of n, b, and w
     *
     * O(n), but technically O(w*(n+b))
     *
     * n: length of array
     * w: word length of integers A in base b (equal to log base b of k (log_b k) )
     *
     * @param b The base to use for radix sort
     */
    static void radixSort(int[] A, int b) {
        // Calculate the upper-bound for numbers in A
        int k = A[0] + 1;
        for (int i = 1; i < A.length; i++)
            k = (A[i] + 1 > k) ? A[i] + 1 : k;
        int w = (int) Math.ceil(Math.log(k) / Math.log(b)); // w = log base b of k, word length of numbers
        // TODO: Perform radix sort
        for (int m=0; m<w; m++) {
            countingSortByDigit(A,b,m);
        }
    }

}
