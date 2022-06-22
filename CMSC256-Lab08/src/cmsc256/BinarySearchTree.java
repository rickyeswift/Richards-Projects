/*
* CMSC256-Lab08
* BinarySearchTree.java
* Richard Elliott Jr
* 06/21/2022
 */
package cmsc256;

import jdk.nashorn.internal.ir.BinaryNode;

//BinarySearchTree class to represent Binary Search Tree
public class BinarySearchTree<E extends Comparable<? super E>> {
    /**
     * Inner class to represent node of Binary search tree
     */
    public class BinaryNode<E> {
        protected E value; // value
        protected BinaryNode<E> right; // right child
        protected BinaryNode<E> left; // left child

        /**
         * No argument constructor
         *
         * @param valueln
         */
        public BinaryNode(E valueln) {
            this.value = valueln;
        }

        /**
         * Getter for value
         *
         * @return value
         */
        public E getValue() {
            return this.value;
        }
    }

    private int size; // attribute for size of tree
    private BinaryNode<E> root; // Root of BST

    /**
     * recursive method to add node to parent node
     *
     * @param parentNode
     * @param addNode
     * @return if added or not
     */
    private boolean addToParent(BinaryNode<E> parentNode, BinaryNode<E> addNode) {
        int compare = addNode.value.compareTo(parentNode.value); // compare parent value and addNode value
        boolean wasAdded = false;
        // if value to be added is less than value of parent
        if (compare < 0) {
            // if parent left is null, add to parent's left
            if (parentNode.left == null) {
                parentNode.left = addNode;
                wasAdded = true;
            }
            // if parent left is not null, recursive call to addToParent
            else {
                wasAdded = addToParent(parentNode.left, addNode);
            }
        }
        // if value to be added is greater than value of parent
        else if (compare > 0) {
            // if parent right is null, add to parent's right
            if (parentNode.right == null) {
                parentNode.right = addNode;
                wasAdded = true;
            }
            // if parent right is not null, recursive call to addToParent
            else {
                wasAdded = addToParent(parentNode.right, addNode);
            }
        }
        // return if added or not
        return wasAdded;
    }

    /**
     * add method adds value in BST
     *
     * @param inValue
     * @return if added or not
     */
    public boolean add(E inValue) {
        BinaryNode<E> node = new BinaryNode<E>(inValue);
        boolean wasAdded = true;
        // if root is null
        if (root == null) {
            // set root to node
            root = node;
        }
        else {
            // place call to addToParent
            wasAdded = addToParent(root, node);
        }
        // if added increment size by 1
        if (wasAdded) {
            this.size += 1;
        }
        // return wasAdded
        return wasAdded;
    }

    /**
     * remove takes removeValue and removes that from BST, if removeValue is not is
     * BST it returns false, otherwise true
     *
     * @param removeValue
     * @return if removed or not
     */
    public boolean remove(E removeValue) {
        // if root is null, return false
        if (root == null) {
            return false;
        }
        // if value to be removed is root
        if (removeValue.compareTo(root.value) == 0) {
            // if root's left is null, make root right
            if (root.left == null) {
                root = root.right;
            }
            // if root's right is null make root left
            else if (root.right == null) {
                root = root.left;
            }
            // if neither of root's child is null, make left as root and call addToParent
            else {
                // for root's former right
                BinaryNode<E> formerRight = root.right;
                root = root.left;
                addToParent(root, formerRight);
            }
            // decrement the size
            size--;
            return true;
        }
        // call to removeSubNode if node to be removed is not root
        return removeSubNode(root, removeValue);
    }

    /**
     * removeSubNode is recursive method that removes value from BST
     *
     * @param parent
     * @param removeValue
     * @return if removed
     */
    private boolean removeSubNode(BinaryNode<E> parent, E removeValue) {
        // compare value to be removed and parent's value
        int compareParent = removeValue.compareTo(parent.value);
        BinaryNode<E> subTree = null;
        // if value to be removed > parent, set subTree as parent.right
        if (compareParent > 0) {
            subTree = parent.right;
        }
        // if value to be removed <>> parent, set subTree as parent.left
        else {
            subTree = parent.left;
        }
        // if subTree is null return false
        if (subTree == null) {
                return false;
        }
        // if subTree value and value to be removed is same
        if (subTree.value.compareTo(removeValue) == 0) {
            BinaryNode<E> replacement;
            // if subTree left is null
            if (subTree.left == null) {
                replacement = subTree.right;
            }
            // if subTree right is null
            else if (subTree.right == null) {
                replacement = subTree.left;
            }
            // if either is null
            else {
                BinaryNode<E> formerRight = subTree.right;
                replacement = subTree.left;
                // call to add root's former right to replacement
                addToParent(replacement, formerRight);
            }

            if (compareParent > 0) {
                // assign replacement to parent's right
                parent.right = replacement;
            }
            else {
                // assign replacement to parent's left
                parent.left = replacement;
            }
            // decrement the size
            size--;
            return true;
        }
        // recursive call to removeSubNode
        return removeSubNode(subTree, removeValue);
        }

    /*
     * Getter for root
     *
     * @return rootNode
     */
    public BinaryNode<E> getRoot() {
        return this.root;
    }

    /**
     * integer for size
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * method that clears variable root and size
     */
    public void clear() {
        root = null;
        size = 0;
    }

}
