import com.sun.source.tree.Tree;

import java.util.NoSuchElementException;


public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**LLRB trees are good because:
     *    - Faster insertion and removal (fewer rotations)
     *    - Relaxed balancing
     *    - Only one bit of information needed per node
     *    - Used a lot in libraries
     *
     * LLRB trees are less good because:
     *    - Slower lookup than AVL trees
     *    - Less strict balancing
     *    - Less useful for databases
     */
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private boolean isRed(TreeNode x) {
        return x != null && x.color == RED;
    }

    private boolean isBlack(TreeNode x) {
        return x != null && x.color == BLACK;
    }

    // ====================================
    //            Insertion Code
    // ====================================


    public boolean add(T key) {
        super.add(key);
        root.color = BLACK;
        return true;
    }


    //For the rotates, don't forget to reassign colors. If you are unclear about
    //how to do this, you can try drawing ou examples and make sure you
    //maintain the requirements of a LLRB:
    //-All leaves have the same black distance
    //-No right red nodes
    //-No 2 red nodes in a row

    // make a left-leaning link lean to the right
    TreeNode<T> rotateRight(TreeNode<T> h) {
        // TODO
//        ONLY ROTATE RED LINKS TO MAINTAIN BLACK LINK BALANCE
        TreeNode<T> x = h.leftChild;
        h.leftChild = x.rightChild;
        x.rightChild = h;
        x.color = x.rightChild.color;
        x.rightChild.color = RED;
        return x;
    }

    // make a right-leaning link lean to the left
    TreeNode<T> rotateLeft(TreeNode<T> h) {
        // TODO
//        Literally the same thing as rotateRight but with the
//        directions flipped
        TreeNode<T> x = h.rightChild;
        h.rightChild = x.leftChild;
        x.leftChild = h;
        x.color = x.leftChild.color;
        x.leftChild.color = RED;
        return x;
    }

    // flip the colors of a TreeNode and its two children
    TreeNode<T> flipColors(TreeNode<T> h) {
        // TODO
//        Literally just change red to black and black to red
//        for all of h's links (including itself).
//        Used to make child links black and send red up
        h.color = !h.color;
        h.leftChild.color = !h.leftChild.color;
        h.rightChild.color = !h.rightChild.color;
        return h;
    }


    /**
     * fix three cases:
     *   1. h.right is red --> rotate h left
     *   2. h.left is red, and h.left.left is red --> rotate h right
     *   2. h.left and h.right are red --> flip colors
     * return balanced node
     */
    private TreeNode<T> balance(TreeNode<T> h) {
        // TODO
//        case 1
        if (isRed(h.rightChild)) {
            h=rotateLeft(h);
        }
//        case 2
        if (isRed(h.leftChild) && isRed(h.leftChild.leftChild)) {
            h=rotateRight(h);
        }
//        case 3
        if (isRed(h.rightChild) && isRed(h.leftChild)) {
            h=flipColors(h);
        }
        return h;
    }


    /**
     * Recursively insert a new node into the BST
     * Runtime: O(log(n))
     */
    @Override
    TreeNode<T> insert(TreeNode<T> h, T key) {
        h = super.insert(h, key);
        // TODO: use balance to correct for the three rotation cases
//        that's all folks, balance takes care of it all
        return balance(h);
    }


    // ====================================
    //            Deletion Code
    // ====================================


    /**
     * Removes the specified key from the tree
     * (if the key is in this tree).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean delete(T key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return false;

        // if both children of root are black, set root to red
        if (!isRed(root.leftChild) && !isRed(root.rightChild))
            root.color = RED;

        root = delete(root, key);
        size--;
        if (!isEmpty()) root.color = BLACK;
        return true;
    }


    // the smallest key in subtree rooted at x; null if no such key
    private TreeNode<T> min(TreeNode<T> x) {
        if (x.leftChild == null) return x;
        else return min(x.leftChild);
    }

    // delete the key-value pair with the minimum key rooted at h
    public void deleteMin() {
        root = deleteMin(root);
        root.color = BLACK;
    }

    TreeNode<T> deleteMin(TreeNode<T> h) {
        // OPTIONAL TODO: write this function and use it in delete(h, key)
        if (h.leftChild==null) {
            return null;
        }
        if (!isRed(h.leftChild) && !isRed(h.leftChild.leftChild)) {
            h = moveRedLeft(h);
        }
        h.leftChild = deleteMin(h.leftChild);
        return balance(h);
    }

    private TreeNode<T> moveRedLeft(TreeNode<T> h) {
        flipColors(h);
        if (isRed(h.rightChild.leftChild)) {
            h.rightChild=rotateRight(h.rightChild);
            h=rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    private TreeNode<T> moveRedRight(TreeNode<T> h) {
        flipColors(h);
        if (isRed(h.leftChild.leftChild)) {
            h=rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    // delete the key-value pair with the given key rooted at h
    TreeNode<T> delete(TreeNode<T> h, T key) {
        // OPTIONAL TODO
        int c = key.compareTo(h.key);
        if (c<0) {
            if (!isRed(h.leftChild) && !isRed(h.leftChild.leftChild)) {
                h = moveRedLeft(h);
            }
            h.leftChild = delete(h.leftChild,key);
        } else {
            if (isRed(h.leftChild)) {
                h = rotateRight(h);
            }
            if (c==0 && h.rightChild==null) {
                return null;
            }
            if (!isRed(h.rightChild) && !isRed(h.rightChild.leftChild)) {
                h = moveRedRight(h);
            }
            if (c==0) {
                h.key = min(h.rightChild).key;
                h.rightChild = deleteMin(h.rightChild);
            } else {
                h.rightChild = delete(h.rightChild,key);
            }
        }
        return balance(h);
    }

    // ====================================
    //          LLRB Verification
    // ====================================


    // TODO: understand how the following functions can be used to verify a valid LLRB

    public boolean is23() {
        return is23(root);
    }

    // return true if this LLRB is a valid 2-3 tree
    private boolean is23(TreeNode<T> n) {
        if (n == null) return true;
        if (isRed(n.rightChild)) return false;
        if (isRed(n.leftChild) && isRed(n.leftChild.leftChild)) return false;
        return is23(n.rightChild) && is23(n.leftChild);
    }

    public boolean isBalanced() {
        return isBalanced(root) != -1;
    }

    // return -1 if the tree is not balanced. Otherwise, return the black-height of the tree
    private int isBalanced(TreeNode<T> n) {
        if (n == null) return 0;
        int lBalanced = isBalanced(n.leftChild);
        int rBalanced = isBalanced(n.rightChild);
        if (lBalanced == -1 || rBalanced == -1) return -1;
        if (isBlack(n.leftChild)) lBalanced++;
        if (isBlack(n.rightChild)) rBalanced++;
        if (lBalanced != rBalanced) return -1;
        return lBalanced;
    }

}
