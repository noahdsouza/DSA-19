import java.util.Arrays;
import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        // TODO
        int neg_count = 0;
        for (int i : A) {
            if (i<0) {
                neg_count++;
            }
        }
        int[] negs = new int[neg_count];
        int[] poss = new int[A.length-neg_count];
        int neg_counter = 0;
        int pos_counter = 0;
        for (int j : A) {
            if (j<0) {
                negs[neg_counter] = j*-1;
                neg_counter++;
            }
            else {
                poss[pos_counter] = j;
                pos_counter++;
            }
        }
        RadixSort.radixSort(negs, 10);
        RadixSort.radixSort(poss, 10);
        for(int k = 0; k < negs.length/2; k++) {
            int temp = negs[k];
            negs[k] = negs[negs.length-k-1];
            negs[negs.length-k-1] = temp;
        }
        for (int m=0; m<negs.length; m++) {
            negs[m] = negs[m]*-1;
        }
        System.arraycopy(negs, 0, A, 0, negs.length);
        System.arraycopy(poss, 0, A, negs.length, poss.length);
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        // TODO
        LinkedList<String>[] L = new LinkedList[26];
        for (int i = 0; i < 26; i++)
            L[i] = new LinkedList<>();

        for (String i : A) {
            // TODO: Extract the relevant digit from i, and add i to the corresponding Linked List.
            int reldig = getNthCharacter(i,n);
            L[reldig].add(i);
        }
        int j = 0; // index in A to place numbers
        for (LinkedList<String> list : L) {
            // TODO: Put all numbers in the linked lists into A
            for (String k : list) {
                A[j] = k;
                if (j<A.length-1) {
                    j++;
                }
            }
        }
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        // TODO
        for (int m=0; m<stringLength; m++) {
            countingSortByCharacter(S,m);
        }
    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {
        // TODO
        return 0;
    }

}
