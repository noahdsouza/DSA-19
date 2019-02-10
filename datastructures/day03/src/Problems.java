import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        // TODO: your code here
        Stack<Integer> big_chungus = new Stack();
        int len = A.length;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            while (!big_chungus.isEmpty() && A[i] < big_chungus.peek() && count<k) {
                big_chungus.pop();
                count++;
            }
            if (big_chungus.size() < len-k) {
                big_chungus.push(A[i]);
            }

        }
        return big_chungus;
    }

    public static boolean isPalindrome(Node n) {
        // TODO: your code here
        if (n==null || n.next==null) {
            return true;
        }

        Node fast_boi = n;
        Node slow_boi = n;
        while (fast_boi.next != null && fast_boi.next.next != null) {
            fast_boi = fast_boi.next.next;
            slow_boi = slow_boi.next;
        }
        Node n2 = slow_boi.next;
        slow_boi.next = null;

        Node fo = n2;
        Node be = fo.next;
        while(fo != null && be != null) {
            Node temp = be.next;
            be.next = fo;
            fo = be;
            be = temp;
        }
        n2.next = null;

        Node left;
        if (be==null) {
            left = fo;
        } else {
            left = be;
        }
        Node rite = n;
        while (left != null){
            if (left.val != rite.val){
                return false;
            }
            left = left.next;
            rite = rite.next;
        }
        return true;
    }

    public static String infixToPostfix(String s) {
        // TODO
        Stack pars = new Stack();
        String fin = new String();
        s = s.replaceAll(" ","");

        for (int i = 0; i < s.length(); i++) {
            Character schar = s.charAt(i);
            if (Character.isDigit(schar)) {
                fin = fin + schar;
            }
            if (schar.equals('+') || schar.equals('*')) {
                pars.push(schar);
            }
            if (schar.equals(')')) {
                fin = fin + pars.pop();
            }
        }
        return fin.replace(""," ").trim();
    }

}
