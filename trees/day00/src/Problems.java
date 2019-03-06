import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        // TODO
        Collections.sort(values);
        BinarySearchTree<Integer> oof = new BinarySearchTree<>();
        hamburgerHelper(0,values.size(),values,oof);
        return oof;
    }
    public static BinarySearchTree<Integer> hamburgerHelper(int start,int end, List<Integer> vals, BinarySearchTree<Integer> oof) {
//        its like my BST helper function but recursively uses
//        the median of a sublist as a parent
        if (start == end) {
            return oof;
        }
        List<Integer> temp = vals.subList(start,end);
        int median = (temp.size())/2;
        if (median == 0) {
            oof.add(temp.get(0));
            return oof;
        }
        oof.add(temp.get(median));
//        idk why I named this function hamburger helper
//        I'm delirious
        hamburgerHelper(0,median,temp,oof);
        hamburgerHelper(median,temp.size(),temp,oof);
        return oof;
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        // no.
        return false;
    }
}
