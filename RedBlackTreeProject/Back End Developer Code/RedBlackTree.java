// --== CS400 File Header Information ==--
// Name: Nathaniel Tate
// Email: ntate@wisc.edu
// Team: MB
// TA: Harit 
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Binary Search Tree implementation with a Node inner class for representing
 * the nodes within a binary search tree.  You can use this class' insert
 * method to build a binary search tree, and its toString method to display
 * the level order (breadth first) traversal of values in that tree.
 */
public class RedBlackTree<T extends Comparable<T>> {

    /**
     * This class represents a node holding a single value within a binary tree
     * the parent, left, and right child references are always be maintained.
     */
    protected static class Node<T> {
        public T data;
        public Node<T> parent; // null for root node
        public Node<T> leftChild; 
        public Node<T> rightChild; 
        public String songName;
        public boolean isBlack = false;
        public Node(T data) { this.data = data; }
        /**
         * @return true when this node has a parent and is the left child of
         * that parent, otherwise return false
         */
        public boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }
        /**
         * This method performs a level order traversal of the tree rooted
         * at the current node.  The string representations of each data value
         * within this tree are assembled into a comma separated string within
         * brackets (similar to many implementations of java.util.Collection).
         * @return string containing the values of this tree in level order
         */
        @Override
        public String toString() { // display subtree in order traversal
            String output = "[";
            LinkedList<Node<T>> q = new LinkedList<>();
            q.add(this);
            while(!q.isEmpty()) {
                Node<T> next = q.removeFirst();
                if(next.leftChild != null) q.add(next.leftChild);
                if(next.rightChild != null) q.add(next.rightChild);
                output += next.data.toString();
                if(!q.isEmpty()) output += ", ";
            }
            return output + "]";
        }
    }

    protected Node<T> root; // reference to root node of tree, null when empty

    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree.  After  
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     * @param data to be added into this binary search tree
     * @throws NullPointerException when the provided data argument is null
     * @throws IllegalArgumentException when the tree already contains data
     */
    public void insert(T data, String songName) throws NullPointerException,
				      IllegalArgumentException {
        // null references cannot be stored within this tree
        if(data == null) throw new NullPointerException(
            "This RedBlackTree cannot store null references.");

        Node<T> newNode = new Node<>(data);
        newNode.songName = songName;
        if(root == null) {
             root = newNode; // add first node to an empty tree
             root.isBlack = true;   // set the root node to be black
        } 
        else insertHelper(newNode,root); // recursively insert into subtree
    }

    /** 
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the 
     *      newNode should be inserted as a descenedent beneath
     * @throws IllegalArgumentException when the newNode and subtree contain
     *      equal data references (as defined by Comparable.compareTo())
     */
    private void insertHelper(Node<T> newNode, Node<T> subtree) {
        int compare = newNode.data.compareTo(subtree.data);
        // do not allow duplicate values to be stored within this tree
        if(compare == 0) throw new IllegalArgumentException(
            "This RedBlackTree already contains that value.");

        // store newNode within left subtree of subtree
        else if(compare < 0) {
            if(subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
            // otherwise continue recursive search for location to insert
            } else insertHelper(newNode, subtree.leftChild);
        }

        // store newNode within the right subtree of subtree
        else { 
            if(subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
            // otherwise continue recursive search for location to insert
            } else insertHelper(newNode, subtree.rightChild);
        }
    }

    private void enforceRBTreePropertiesAfterInsert(Node<T> newNode) {
        Node<T> nNPSibling; // the new node parent's sibling
        while(newNode.parent.isBlack == false) {
            if (newNode.parent.parent == null) {
                break;
            }
            if (newNode.parent == newNode.parent.parent.rightChild) {   // if the parent node is the rightchild of the grandparent node
                nNPSibling = newNode.parent.parent.leftChild;   // assigns the sibling node to be the other child of the grandparent node
                if (nNPSibling != null && nNPSibling.isBlack == false) {  //if the sibling is red and not null, then recoloring must occur
                    nNPSibling.isBlack = true;
                    newNode.parent.isBlack = true;
                    newNode.parent.parent.isBlack = false;
                    newNode = newNode.parent.parent;
                } else {    // if the sibling is black or null, then rotations must be made
                    if (newNode == newNode.parent.leftChild) {  // for the case when the child node is the left child of the parent
                        newNode = newNode.parent;
                        rotate(newNode.leftChild,newNode);
                    }
                    newNode.parent.isBlack = true;
                    newNode.parent.parent.isBlack = false;
                    rotate(newNode.parent, newNode.parent.parent);
                }
            } else {    // only hits else when the parent node is the leftchild of the grandparent node
                nNPSibling = newNode.parent.parent.rightChild;  // assigns the sibling node to be the other child of the grandparent node
                if (nNPSibling != null && nNPSibling.isBlack == false) {  // if the sibling is red and is not null, then recoloring must occur
                    nNPSibling.isBlack = true;
                    newNode.parent.isBlack = true;
                    newNode.parent.parent.isBlack = false;
                    newNode = newNode.parent.parent;
                } else {    // if the sibling is black or null, then rotations must be made
                    if (newNode == newNode.parent.rightChild) { // for the case when the child node is the right child of the parent
                        newNode = newNode.parent;
                        rotate(newNode.rightChild,newNode);
                    }
                    newNode.parent.isBlack = true;
                    newNode.parent.parent.isBlack = false;
                    rotate(newNode.parent, newNode.parent.parent);
                }
            }
            if (newNode == root) {  // if newNode is the root then stop enforcing the Red Black Tree Properties
                break;
            }
        }
        root.isBlack = true;    // ensure that the root of the tree is black
    }

    /**
     * This method performs a level order traversal of the tree. The string 
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations 
     * of java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * @return string containing the values of this tree in level order
     */
    @Override
    public String toString() { return root.toString(); }

    /**
     * Performs the rotation operation on the provided nodes within this BST.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation (sometimes called a left-right 
     * rotation).  When the provided child is a rightChild of the provided 
     * parent, this method will perform a left rotation (sometimes called a 
     * right-left rotation).  When the provided nodes are not related in one 
     * of these ways, this method will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent)
	throws IllegalArgumentException {
        Node<T> newParent = new Node<>(child.data);
        Node<T> childchildL = child.leftChild;
        Node<T> childchildR = child.rightChild;
        Node<T> grandParent = parent.parent;
        boolean parentLeftChild = parent.isLeftChild();
        if (child == parent.leftChild) {
            newParent.leftChild = childchildL;
            newParent.rightChild = parent;
            parent.parent = newParent;
            if (childchildR != null) {
                newParent.rightChild.leftChild = childchildR;
            } else {
                newParent.rightChild.leftChild = null;
            }
            if (grandParent != null){
                if (parentLeftChild) {
                    grandParent.leftChild = newParent;
                    newParent.parent = grandParent;
                } else {
                    grandParent.rightChild = newParent;
                    newParent.parent = grandParent;
                }
            } else {
                root = newParent;
            }
        } else if(child == parent.rightChild) {
            newParent.rightChild = childchildR;
            newParent.leftChild = parent;
            parent.parent = newParent;
            if (childchildL != null) {
                newParent.leftChild.rightChild = childchildL;
            } else {
                newParent.leftChild.rightChild = null;
            }
            if (grandParent != null) {
                if (parentLeftChild) {
                    grandParent.leftChild = newParent;
                    newParent.parent = grandParent;
                } else {
                    grandParent.rightChild = newParent;
                    newParent.parent = grandParent;
                }
            } else {
                root = newParent;
            }
        } else {
            throw new IllegalArgumentException("The child node passed is not a child of the parent node passed");
        }   
    }
    
    /***
     * This method clears the tree of any data
     */
    public void clearTree() {
        root = null;
    }

    /***
     * This goes through a branch of the tree and counts the black nodes
     * @return blackCount - the number of black nodes down the left branch
     */
    public int size() {
        Node<T> currentNode = root;
        int blackCount = 0;
        while(currentNode != null) {
            if (currentNode.isBlack == true) {
                blackCount++;
            }
            currentNode = currentNode.leftChild;
        }
        return blackCount;
    }

    /***
     * This method recursively traverses the tree until either the currentNode's data is equal to 
     * the key passed or the currentNode is equal to null
     * 
     * @param currentNode
     * @param key
     * @return songName of the node that's data is equal to key
     */
    public String get(Node<T> currentNode, T key) throws NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException("A key of null was passed");
        }
        if (currentNode == null) {
            throw new NoSuchElementException("A node with that key doesn't exixst within the tree");
        }
        if (key.compareTo(currentNode.data) < 0) { // Check the left subtree for the key
            return get(currentNode.leftChild, key);
        } else if (key.compareTo(currentNode.data) > 0) {   // Check the right subtree for the key
            return get(currentNode.rightChild, key);
        } else {    // Returns the songName associated to the key passed
            return currentNode.songName;
        }
    }

    /***
     * This method recursively traverses the tree until either the currentNode's data is equal to 
     * the key passed or the currentNode is equal to null
     * 
     * @param currentNode
     * @param key
     * @return true if the tree contains the key, false otherwise
     */
    public boolean containsKey(Node<T> currentNode, T key) {
        if (key == null) {
            throw new IllegalArgumentException("A key of null was passed1");
        }
        if (currentNode == null) { // If currentNode equals null then the key doesn't exist within the tree
            return false;
        }
        if (key.compareTo(currentNode.data) < 0) {  // Check the left subtree for the key
            return containsKey(currentNode.leftChild, key);
        } else if (key.compareTo(currentNode.data) > 0) {    // Check the right subtree for the key
            return containsKey(currentNode.rightChild, key);
        } else {
            return true;
        }
    }
}
