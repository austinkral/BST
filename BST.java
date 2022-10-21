//======================================================
// BST defines a binary search tree implementation
//======================================================
public class BST {
    
    //======================================================
    // Node defines a node subclass of BST
    //======================================================
    public class Node {

	//======================================================
	// Node instance variables
	//======================================================
	private int key;
	private Node parent;
	private Node leftChild;
	private Node rightChild;

	//======================================================
	// Constructs a node with key = -1
	//======================================================
	public Node() {
	    this.key = -1;
	    this.parent = null;
	    this.leftChild = null;
	    this.rightChild = null;
	} // Node

	//======================================================
	// Constructs a node with key = key
	//======================================================
	public Node(int key) {
	    this.key = key;
	    this.parent = null;
	    this.leftChild = null;
	    this.rightChild = null;
	} // Node

	//======================================================
	// Constructs a node with key = key, parent = parent,
	// leftChild = leftChild, and rightChild = rightChild
	//======================================================
	public Node(int key, Node parent, Node leftChild, Node rightChild) {
	    this.key = key;
	    this.parent = parent;
	    this.leftChild = leftChild;
	    this.rightChild = rightChild;
	} // Node

	//======================================================
	// Sets node's key = key
	//======================================================
	private void setKey(int key) {
	    this.key = key;
	} // setKey

	//======================================================
	// Returns node's key
	//======================================================
	public int getKey() {
	    return key;
	} // getKey

	//======================================================
	// Sets node's parent = parent
	//======================================================
	private void setParent(Node parent) {
	    this.parent = parent;
	} // setParent

	//======================================================
	// Returns node's parent
	//======================================================
	public Node getParent() {
	    return parent;
	} // getParent

	//======================================================
	// Sets node's left child = leftChild
	//======================================================
	private void setLeftChild(Node leftChild) {
	    this.leftChild = leftChild;
	} // setLeftChild

	//======================================================
	// Returns node's left child
	//======================================================
	public Node getLeftChild() {
	    return leftChild;
	} // getLeftChild

	//======================================================
	// Sets node's right child = rightChild
	//======================================================
	private void setRightChild(Node rightChild) {
	    this.rightChild = rightChild;
	} // setRightChild

	//======================================================
	// Returns node's right child
	//======================================================
	public Node getRightChild() {
	    return rightChild;
	} // getRightChild

    } // Node

    //======================================================
    // BST instance variables
    //======================================================
    private Node root;
    private int size;


    //======================================================
    // Constructs an empty BST
    //======================================================
    public BST() {
        this.root = null;
        this.size = 0;
    } // BST

    //======================================================
    // Returns BST's size (number of nodes)
    //======================================================
    public int size() {
        return this.size;
    } // size

    //======================================================
    // Finds the node in the BST with key = element if it
    // exists and returns it; otherwise, returns null
    //======================================================
    private Node find(Node current, int element) {
        if (element < current.getKey()) {
            if (current.getLeftChild() != null) {
                find(current.getLeftChild(), element);
            } else {
		System.out.println("Element not found!");
                return null;
            } // if
        } else if (element > current.getKey()) {
            if (current.getRightChild() != null) {
                find(current.getRightChild(), element);
            } else {
		System.out.println("Element not found!");
                return null;
            } // if
        } // if
        return current;
    } // find

    //======================================================
    // Finds the inorder predecessor of predNode
    //======================================================
    private Node findMax(Node current) {
	while (current.getRightChild() != null) {
	    current = current.getRightChild();
	} // while
	return current;
    } // findMin

    //======================================================
    // Calls method to recursively insert a new element
    //======================================================
    public void insert(int element) {
	root = insertRec(this.root, element);
    } // insert

    //======================================================
    // Recursively inserts a new node in the BST with
    // key = element
    //======================================================
    private Node insertRec(Node current, int element) {
	if (current == null) {
	    size++;
	    return new Node(element);
	} // if
	if (element < current.getKey()) {
	    current.setLeftChild(insertRec(current.getLeftChild(), element));
	} else if (element > current.getKey()) {
	    current.setRightChild(insertRec(current.getRightChild(), element));
	} else {
	    System.out.println("Element is already in the tree!");
	} // if
	return current;
    } // insertRec

    //======================================================
    // Calls method to recursively delete the node with
    // key = element if it exists in the BST; otherwise,
    // prints "Element not found!"
    //======================================================
    public void delete(int element) {
	if (find(this.root, element) != null) {
	    deleteRec(this.root, element);
	    size--;
	} // if
    } // delete

    //======================================================
    // Recursively deletes the node with key = element
    // and refactors BST
    //======================================================
    private Node deleteRec(Node current, int element) {
	if (current == null) {
	    return null;
	} // if
	if (element < current.getKey()) {
	    current.setLeftChild(deleteRec(current.getLeftChild(), element));
	} else if (element > current.getKey()) {
	    current.setRightChild(deleteRec(current.getRightChild(), element));
	} else {
	    if (current.getLeftChild() == null) {
		return current.getRightChild();
	    } else if (current.getRightChild() == null) {
		return current.getLeftChild();
	    } //if
	    Node min = findMax(current.getLeftChild());
	    current.setKey(min.getKey());
	    current.setLeftChild(deleteRec(current.getLeftChild(), min.getKey()));
	} // if
	return current;
    } // deleteRec

    //======================================================
    // Calls recursive preorder method'
    //======================================================
    public void preorder() {
        preorderHelper(this.root);
    } // preorder

    //======================================================
    // Recursively iterates through the BST preorder and
    // prints each element
    //======================================================
    private void preorderHelper(Node current) {
	if (current != null && size() > 0) {
	    System.out.print(current.getKey() + " ");
	    preorderHelper(current.getLeftChild());
	    preorderHelper(current.getRightChild());
	} // if
    } // preorderHelper

    //======================================================
    // Calls recursive postorder method 
    //======================================================
    public void postorder() {
        postorderHelper(this.root);
    } // postorder

    //======================================================
    // Recursively iterates through the BST postorder and
    // prints each element
    //======================================================
    private void postorderHelper(Node current) {
        if (current != null && size() > 0) {
	    postorderHelper(current.getLeftChild());
	    postorderHelper(current.getRightChild());
	    System.out.print(current.getKey() + " ");
	} // if
    } // postorderHelper

    //======================================================
    // Calls recursive inorder method
    //======================================================
    public void inorder() {
        inorderHelper(this.root);
    } // inorder

    //======================================================
    // Recursively iterates through the BST inorder and
    // prints each element
    //======================================================
    private void inorderHelper(Node current) {
        if (current != null && size() > 0) {
	    inorderHelper(current.getLeftChild());
	    System.out.print(current.getKey() + " ");
	    inorderHelper(current.getRightChild());
	} // if
    } // inorderHelper

} // BST
