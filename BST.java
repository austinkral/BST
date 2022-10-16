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

    private Node root;
    private int size;

    public BST() {
	this.root = null;
	this.size = 0;
    } // BST

    public int size() {
	return this.size;
    } // size

    public void insert(int element) {
	boolean isInserted = false;
	while (!isInserted) {
	    if (element > this.root.key) {} // do shit to the right
	    if (element < this.root.key) {} // do shit to the left
	} // while
    } // insert

    public void delete(int element) {
	while (root.key != element) {} // do shit
    } // delete

    public void preorder() {
	Node current = this.root;
	this.preorderHelper(current);
    } // preorder

    private void preorderHelper(Node current) {
	// recursively preorder the BST
    } // preorderHelper
    
    public void postorder() {
	Node current = this.root;
	this.postorderHelper(current);
    } // postorder

    private void postorderHelper(Node current) {
	// recursively postorder the BST
    } // postorderHelper
    
    public void inorder() {
	Node current = this.root;
	this.inorderHelper(current);
    } // inorder

    private void inorderHelper(Node current) {
	// recursively inorder the BST
    } // inorderHelper
    
} // BST
