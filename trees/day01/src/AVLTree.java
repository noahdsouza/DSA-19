public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    TreeNode<T> delete(TreeNode<T> n, T key) {
        n = super.delete(n, key);
        if (n != null) {
            // TODO
            // update the height of the tree using the height of the left and right child
            // return balance(n)
            n.height = Math.max(height(n.leftChild),height(n.rightChild))+1;
            return balance(n);
        }
        return null;
    }

    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override
    TreeNode<T> insert(TreeNode<T> n, T key) {
        n = super.insert(n, key);
        if (n != null) {
            // TODO
            // update the height of the tree using the height of the left and right child
            // return balance(n)
            //    what is super?
            //    calls something from a parent class
            //    this is gonna do some weird back and forth hanky panky bullshit
            n.height = Math.max(height(n.leftChild),height(n.rightChild))+1;
            return balance(n);
        }
        return null;
    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override
    TreeNode<T> deleteMin(TreeNode<T> n) {
        n = super.deleteMin(n);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(TreeNode<T> n) {
        // TODO
//        if n is null return -1
//        return max(height(n.left), height(n.right)) + 1
        if (n==null) {
            return -1;
        }
        return Math.max(height(n.leftChild),height(n.rightChild))+1;
    }

    public int height() {
        return Math.max(height(root), 0);
    }

    // Restores the AVL tree property of the subtree. Return the head of the new subtree
    TreeNode<T> balance(TreeNode<T> n) {
        // TODO: (if you're having trouble, use pseudocode provided in slides)
//        left rotate = anticlockwise
//        right rotate = clockwise
//        > 1 is right heavy
//        < -1 is left heavy
        if (balanceFactor(n) > 1) {
            if (balanceFactor(n.rightChild) <= -1) {
                n.rightChild = rotateRight(n.rightChild);
            }
            n = rotateLeft(n);
        }
        if (balanceFactor(n) < -1) {
            if (balanceFactor(n.leftChild) >= 1) {
                n.leftChild = rotateLeft((n.leftChild));
            }
            n = rotateRight(n);
        }
        return n;
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(TreeNode<T> n) {
        // TODO
//        n.balancefactor = n.right.height - n.left.height
//        when balancing, all nodes have to have a balance factor between -1 and 1
//        int r = (n.rightChild != null)?n.rightChild.height:0;
//        int l = (n.leftChild != null)?n.leftChild.height:0;
        return height(n.rightChild)-height(n.leftChild);
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateRight(TreeNode<T> n) {
        // TODO
        TreeNode<T> y = n.leftChild;
        TreeNode<T> b = y.rightChild;
        y.rightChild = n;
        n.leftChild = b;
        y.height = Math.max(height(y.leftChild),height(y.rightChild))+1;
        n.height = Math.max(height(n.leftChild),height(n.rightChild))+1;
        return y;
    }

    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateLeft(TreeNode<T> n) {
        // TODO
        TreeNode<T> y = n.rightChild;
        TreeNode<T> b = y.leftChild;
        y.leftChild = n;
        n.rightChild = b;
        y.height = Math.max(height(y.leftChild),height(y.rightChild))+1;
        n.height = Math.max(height(n.leftChild),height(n.rightChild))+1;
        return y;
    }
}
