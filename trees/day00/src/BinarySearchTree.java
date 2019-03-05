import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
* Adding things in is O(log(n))
* follow right down to get max
* follow left down to get min
* getmax(root)
*   while root RC != null
*       root = root RC
*    return root
 */

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean contains(T key) {
        return find(root, key) != null;
    }

    /**
     * Add a node to the BST. Internally calls insert to recursively find the new node's place
     */
    public boolean add(T key) {
        if (find(root, key) != null) return false;
        root = insert(root, key);
        size++;
        return true;
    }

    public void addAll(T[] keys) {
        for (T k : keys)
            add(k);
    }

    public List<T> inOrderTraversal() {
        // TODO
//        1. traverse(root LC)
//        2. print(root val)
//        3. traverse(root RC)
        List<T> son = new ArrayList<>();
        useMeDaddy(son,root);
        return son;
    }
//    Make a helper function and recurse with it????
    private void useMeDaddy(List<T> son, TreeNode<T> bob) {
        if (bob != null) {
            useMeDaddy(son,bob.leftChild);
            son.add(bob.key);
            useMeDaddy(son,bob.rightChild);
        }
    }

    /**
     * Deletes a node from the BST using the following logic:
     * 1. If the node has a left child, replace it with its predecessor
     * 2. Else if it has a right child, replace it with its successor
     * 3. If it has no children, simply its parent's pointer to it
     */
    public boolean delete(T key) {
        TreeNode<T> toDelete = find(root, key);
        if (toDelete == null) {
            System.out.println("Key does not exist");
            return false;
        }
        TreeNode<T> deleted = delete(toDelete);
        if (toDelete == root) {
            root = deleted;
        }
        size--;
        return true;
    }

    private TreeNode<T> delete(TreeNode<T> n) {
        // Recursive base case
        if (n == null) return null;

        TreeNode<T> replacement;

        if (n.isLeaf())
            // Case 1: no children
            replacement = null;
        else if (n.hasRightChild() != n.hasLeftChild())
            // Case 2: one child
            replacement = (n.hasRightChild()) ? n.rightChild : n.leftChild; // replacement is the non-null child
        else {
            // Case 3: two children
            // TODO
            replacement = findSuccessor(n);
            delete(replacement);
            replacement.moveChildrenFrom(n);
        }

        // Put the replacement in its correct place, and set the parent.
        n.replaceWith(replacement);
        return replacement;
    }

    public T findPredecessor(T key) {
        // finds and returns the TreeNode with key = key if such a TreeNode exists in the tree
        TreeNode<T> n = find(root, key);
        if (n != null) {
            // get the predecessor TreeNode by calling the function you will implement below
            TreeNode<T> predecessor = findPredecessor(n);
            // return the key of predecessor TreeNode
            if (predecessor != null)
                return predecessor.key;
        }
        return null;
    }

    public T findSuccessor(T key) {
        // finds and returns the TreeNode with key = key if such a TreeNode exists in the tree
        TreeNode<T> n = find(root, key);
        if (n != null) {
            // get the successor TreeNode by calling the function you will implement below
            TreeNode<T> successor = findSuccessor(n);
            // return the key of successor TreeNode
            if (successor != null)
                return successor.key;
        }
        return null;
    }

    private TreeNode<T> findPredecessor(TreeNode<T> n) {
        // TODO
        if (n.hasLeftChild()) {
            n = n.leftChild;
            while (n.hasRightChild()) {
                n = n.rightChild;
            }
            return n;
        }
        else {
            TreeNode par = n.parent;
            TreeNode kid = n;
            while (par != null && kid != null && kid == par.leftChild) {
                kid = par;
                par = kid.parent;
            }
            return par;
        }
    }

    private TreeNode<T> findSuccessor(TreeNode<T> n) {
        // TODO
        if (n.hasRightChild()) {
            n = n.rightChild;
            while (n.hasLeftChild()) {
                n = n.leftChild;
            }
            return n;
        }
        else {
            TreeNode par = n.parent;
            TreeNode kid = n;
            while (par != null && kid != null && kid == par.rightChild) {
                kid = par;
                par = kid.parent;
            }
            return par;
        }
    }

    /**
     * Returns a node with the given key in the BST, or null if it doesn't exist.
     */
    private TreeNode<T> find(TreeNode<T> currentNode, T key) {
        if (currentNode == null)
            return null;
        int cmp = key.compareTo(currentNode.key);
        if (cmp < 0)
            return find(currentNode.leftChild, key);
        else if (cmp > 0)
            return find(currentNode.rightChild, key);
        return currentNode;
    }

    /**
     * Recursively insert a new node into the BST
     */
    private TreeNode<T> insert(TreeNode<T> node, T key) {
        if (node == null) return new TreeNode<>(key);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftChild = insert(node.leftChild, key);
            node.leftChild.parent = node;
        } else {
            node.rightChild = insert(node.rightChild, key);
            node.rightChild.parent = node;
        }
        return node;
    }
}
