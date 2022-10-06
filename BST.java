public class BST {

    public class Node {
	private int key;
	private Node parent;
	private Node leftChild;
	private Node rightChild;

	public Node() {
	    this.key = -1;
	    this.parent = null;
	    this.leftChild = null;
	    this.rightChild = null;
	} // Node

	public Node(int key) {
	    this.key = key;
	    this.parent = null;
	    this.leftChild = null;
	    this.rightChild = null;
	} // Node

	public Node(int key, Node parent, Node leftChild, Node rightChild) {
	    this.key = key;
	    this.parent = parent;
	    this.leftChild = leftChild;
	    this.rightChild = rightChild;
	} // Node

	private void setKey(int key) {
	    this.key = key;
	} // setKey

	public int getKey() {
	    return key;
	} // getKey

	private void setParent(Node parent) {
	    this.parent = parent;
	} // setParent

	public Node getParent() {
	    return parent;
 	} // getParent

	private void setLeftChild(Node leftChild) {
	    this.leftChild = leftChild;
	} // setLeftChild

	public Node getLeftChild() {
	    return leftChild;
	} // getLeftChild

	private void setRightChild(Node rightChild) {
	    this.rightChild = rightChild;
	} // setRightChild

	public Node getRightChild() {
	    return rightChild;
	} // getRightChild
	
    } // Node

} // BST
