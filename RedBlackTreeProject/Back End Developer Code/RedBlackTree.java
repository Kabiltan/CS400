
// --== CS400 File Header Information ==--
// Name: Aaron Stephenson
// Email: astephenson2@ewisc.edu
// Team: MB
// TA: Harit Vishwakarma
// Lecturer: Florian Heimerlr
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Binary Search Tree implementation with a Node inner class for representing
 * the nodes within a binary search tree. You can use this class' insert method
 * to build a binary search tree, and its toString method to display the level
 * order (breadth first) traversal of values in that tree.
 */
public class RedBlackTree<T extends Comparable<T>> {
	public int size = 0;

	/**
	 * This class represents a node holding a single value within a binary tree the
	 * parent, left, and right child references are always be maintained.
	 */
	protected static class Node<T> {
		public T data;
		public Node<T> parent; // null for root node
		public Node<T> leftChild;
		public Node<T> rightChild;
		public boolean isBlack = false;
		public String songName;

		public Node(T data) {
			this.data = data;
		}

		/**
		 * @return true when this node has a parent and is the left child of that
		 *         parent, otherwise return false
		 */
		public boolean isLeftChild() {
			return parent != null && parent.leftChild == this;
		}

		/**
		 * This method performs a level order traversal of the tree rooted at the
		 * current node. The string representations of each data value within this tree
		 * are assembled into a comma separated string within brackets (similar to many
		 * implementations of java.util.Collection).
		 * 
		 * @return string containing the values of this tree in level order
		 */
		@Override
		public String toString() { // display subtree in order traversal
			String output = "[";
			LinkedList<Node<T>> q = new LinkedList<>();
			q.add(this);
			while (!q.isEmpty()) {
				Node<T> next = q.removeFirst();
				if (next.leftChild != null)
					q.add(next.leftChild);
				if (next.rightChild != null)
					q.add(next.rightChild);
				output += next.data.toString();
				if (!q.isEmpty())
					output += ", ";
			}
			return output + "]";
		}
	}

	protected Node<T> root; // reference to root node of tree, null when empty

	/**
	 * Performs a naive insertion into a binary search tree: adding the input data
	 * value to a new node in a leaf position within the tree. After this insertion,
	 * no attempt is made to restructure or balance the tree. This tree will not
	 * hold null references, nor duplicate data values.
	 * 
	 * @param data to be added into this binary search tree
	 * @throws NullPointerException     when the provided data argument is null
	 * @throws IllegalArgumentException when the tree already contains data
	 */
	public void insert(T data, String songName) throws NullPointerException, IllegalArgumentException {
		// null references cannot be stored within this tree
		if (data == null)
			throw new NullPointerException("This RedBlackTree cannot store null references.");

		Node<T> newNode = new Node<>(data);
		newNode.songName = songName;
		if (root == null) {
			root = newNode;
			root.isBlack = true;
			this.size++;
		} // add first node to an empty tree
		else
			insertHelper(newNode, root); // recursively insert into subtree
	}

	/**
	 * Recursive helper method to find the subtree with a null reference in the
	 * position that the newNode should be inserted, and then extend this tree by
	 * the newNode in that position.
	 * 
	 * @param newNode is the new node that is being added to this tree
	 * @param subtree is the reference to a node within this tree which the newNode
	 *                should be inserted as a descendant beneath
	 * @throws IllegalArgumentException when the newNode and subtree contain equal
	 *                                  data references (as defined by
	 *                                  Comparable.compareTo())
	 */
	private void insertHelper(Node<T> newNode, Node<T> subtree) {
		int compare = newNode.data.compareTo(subtree.data);
		// do not allow duplicate values to be stored within this tree
		if (compare == 0)
			throw new IllegalArgumentException("This RedBlackTree already contains that value.");

		// store newNode within left subtree of subtree
		else if (compare < 0) {
			if (subtree.leftChild == null) { // left subtree empty, add here
				subtree.leftChild = newNode;
				newNode.parent = subtree;
				this.size++;
				enforceRBTreePropertiesAfterInsert(newNode);
				// otherwise continue recursive search for location to insert
			} else
				insertHelper(newNode, subtree.leftChild);
		}

		// store newNode within the right subtree of subtree
		else {
			if (subtree.rightChild == null) { // right subtree empty, add here
				subtree.rightChild = newNode;
				newNode.parent = subtree;
				this.size++;
				enforceRBTreePropertiesAfterInsert(newNode);
				// otherwise continue recursive search for location to insert
			} else
				insertHelper(newNode, subtree.rightChild);
		}
	}

	/**
	 * This method performs a level order traversal of the tree. The string
	 * representations of each data value within this tree are assembled into a
	 * comma separated string within brackets (similar to many implementations of
	 * java.util.Collection, like java.util.ArrayList, LinkedList, etc).
	 * 
	 * @return string containing the values of this tree in level order
	 */
	@Override
	public String toString() {
		return root.toString();
	}

	/**
	 * Performs the rotation operation on the provided nodes within this BST. When
	 * the provided child is a leftChild of the provided parent, this method will
	 * perform a right rotation (sometimes called a left-right rotation). When the
	 * provided child is a rightChild of the provided parent, this method will
	 * perform a left rotation (sometimes called a right-left rotation). When the
	 * provided nodes are not related in one of these ways, this method will throw
	 * an IllegalArgumentException.
	 * 
	 * @param child  is the node being rotated from child to parent position
	 *               (between these two node arguments)
	 * @param parent is the node being rotated from parent to child position
	 *               (between these two node arguments)
	 * @throws IllegalArgumentException when the provided child and parent node
	 *                                  references are not initially (pre-rotation)
	 *                                  related that way
	 */
	private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
		if (parent.rightChild != child && parent.leftChild != child) {
			throw new IllegalArgumentException("This is not the left or right child");
		}

		if (parent.equals(root)) {
			// if parent is the root and there is no grandparent
			if (child.isLeftChild()) { // right rotation
				parent.leftChild = child.rightChild;
				child.rightChild = parent;
				parent.parent = child;
				root = child;
				child.parent = null;
				return;
			} // left rotation
			parent.rightChild = child.leftChild;
			child.leftChild = parent;
			parent.parent = child;
			root = child;
			child.parent = null;
			return;
		}

		if (parent.isLeftChild()) {
			if (child.isLeftChild()) { // right rotation
				parent.parent.leftChild = parent.rightChild;
				parent.rightChild = parent.parent;
				parent.parent.parent = parent;
				root = parent;
				return;
			}
			// left-right rotation
			parent.parent.leftChild = child.rightChild;
			child.rightChild = parent.parent;
			parent.rightChild = child.leftChild;
			child.leftChild = parent;
			root = child;
			return;
		}

		// parent is right child
		if (child.isLeftChild()) { // right-left rotation
			parent.parent.rightChild = child.leftChild;
			child.leftChild = parent.parent;
			parent.leftChild = child.rightChild;
			child.rightChild = parent;
			root = child;
			return;
		}
		// left rotation
		parent.parent.rightChild = parent.leftChild;
		parent.leftChild = parent.parent;
		parent.parent.parent = parent;
		root = parent;
		return;

	}

	// Red-Black Tree Rules:
	// -Root must be black
	// -Red nodes must have black children
	// -Every path from the root to the null child must have the same number of
	// black nodes
	//
	// Child's parent is red:
	// If parent's sibling is red:
	// - set grandparent to red
	// - set parent and sibling to black
	// - leave the child red
	// If parent's sibling is black or null:
	// - Rotate and re-color
	/**
	 * This method checks that there are no black violations or red-red violations
	 * within the tree. If there is a violation it evaluates what case it is and the
	 * necessary move to fix it
	 * 
	 * @param n - the node being inserted into the Red-black tree
	 */
	private void enforceRBTreePropertiesAfterInsert(Node n) {
		Node sibling = null;

		if (n.parent.parent != null) {
			// create sibling
			if (n.parent.isLeftChild()) {
				sibling = n.parent.parent.rightChild;
			} else {
				sibling = n.parent.parent.leftChild;
			}
		}

		// parent is red
		if (!n.parent.isBlack) {
			// if parent's sibling is black or null
			if (sibling == null || sibling.isBlack) {

				if (n.parent.isLeftChild()) {
					if (n.isLeftChild()) {// right rotation
						rotate(n, n.parent);
						n.parent.isBlack = true;
						n.parent.rightChild.isBlack = false;
						return;
					}
					// left-right rotation
					rotate(n, n.parent);
					n.isBlack = true;
					n.rightChild.isBlack = false;
					return;
				}

				if (n.isLeftChild()) { // right-left rotation
					rotate(n, n.parent);
					n.isBlack = true;
					n.leftChild.isBlack = false;
					return;
				}
				// left rotation
				rotate(n, n.parent);
				n.parent.isBlack = true;
				n.parent.leftChild.isBlack = false;
				return;
			}
			// parent's sibling is red
			n.parent.parent.isBlack = false; // set grand parent to red
			n.parent.isBlack = true;
			sibling.isBlack = true;
			root.isBlack = true;
		}

	}

	/***
	 * This method clears the tree of any data
	 */
	public void clear() {
		root = null;
		this.size = 0;
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**
	 * this method searches through the tree for a certain node within the tree
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public boolean containsKey(Node<T> node, T key) {
		if(node == null) {
			throw new IllegalArgumentException("node passed in the method was null");
		}
		if(key == null) {
			return false;
		}
		
		Node currNode = root;
		
		while(currNode.leftChild != null || currNode.rightChild != null) {
			if(currNode.equals(node)) {
				return true;
			}
			if(key.compareTo(node.data) < 0) {
				currNode = currNode.leftChild;
				continue;
			} else {
				currNode = currNode.rightChild;
				continue;
			}
		}
		return false;

	}

	/**
	 * 
	 * @param node
	 * @param key
	 * @return
	 * @throws NoSuchElementException
	 */
	public String get(Node<T> node, T key) throws NoSuchElementException {
		if (node == null) {
			throw new NoSuchElementException("A node with that key doesn't exixst within the tree");
		}
		if (key == null) {
			throw new IllegalArgumentException("The key entered was null");
		}
		
		Node currNode = root;
		
		while(currNode.leftChild != null || currNode.rightChild != null) {
			if(currNode.songName.equals(node.songName)) {
				return currNode.songName;
			}
			if(key.compareTo(node.data) < 0) {
				currNode = currNode.leftChild;
				continue;
			} else {
				currNode = currNode.rightChild;
				continue;
			}
		}
		throw new NoSuchElementException("there is no node in the tree that contains that key");
	}

}
