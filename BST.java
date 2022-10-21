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

    private Node find(Node n, int element) {
	Node current = n;
	if (element < current.getKey()) {
	    if (current.getLeftChild() != null) {
		find(current.getLeftChild(), element);
	    } else {
		return null;
	    } // if
	} else if (element > current.getKey()) {
	    if (current.getRightChild() != null) {
		find(current.getRightChild(), element);
	    } else {
		return null;
	    } // if
	} // if
	return current;
    } // find
    
    private int inorderPred(Node replace) {
	Node current = replace;
	int pred = current.getKey();
	while (current.getRightChild() != null ) {
	    current = current.getRightChild();
	    pred = current.getKey();
	} // while
	return pred;
    } // inorderPred

    public void insert(int element) {
	Node current = this.root;
	if (root == null) {
	    root = new Node(element);
	} else {
	    insertRec(current, element);
	} // if
	size++;
    } // insert

    private void insertRec(Node current, int element) {
	if (element < current.getKey()) {
	    if (current.getLeftChild() != null) {
		insertRec(current.getLeftChild(), element);
	    } else {
		current.setLeftChild(new Node(element));
	    } // if
	} else if (element > current.getKey()) {
	    if (current.getRightChild() != null) {
		insertRec(current.getRightChild(), element);
	    } else {
		current.setRightChild(new Node(element));
	    } // if
	} else {
	    System.out.println("Element is already in the tree!");
	} // if
    } // insertRec
    
    public void delete(int element) {
	Node current = this.root;
	if (root == null || find(current, element) == null) {
	    System.out.println("Element not found!");
	} else {
	    deleteRec(current, element);
	} // if
	size--;
    } // delete

    private void deleteRec(Node current, int element) {
	if (element < current.getKey()) {
	    if (current.getLeftChild() != null ) {
		deleteRec(current.getLeftChild(), element);
	    } // if
	} else if (element > current.getKey()) {
	    if (current.getLeftChild() != null) {
		deleteRec(current.getRightChild(), element);
	    } // if
	} else {
	    if (current.getLeftChild() == null && current.getRightChild() == null) {
		current = null;
	    } else if (current.getLeftChild() == null) {
		current.getParent().setRightChild(current.getRightChild());
	    } else if (current.getRightChild() == null) {
		current.getParent().setLeftChild(current.getLeftChild());
	    } else {
		current.setKey(inorderPred(current));
		deleteRec(current, inorderPred(current));
	    } // if
	} // if
    } // deleteRec
    
    public void preorder() {
        Node current = this.root;
        this.preorderHelper(current);
    } // preorder

    private void preorderHelper(Node current) {
        // recursively preorder the BST
        if (current == null) {
            return;
        } //if
        if (current.key != -1) {
            System.out.print(current.key + " ");
        } //if
        preorderHelper(current.leftChild);
        preorderHelper(current.rightChild);
    } // preorderHelper

    public void postorder() {
        Node current = this.root;
        this.postorderHelper(current);
    } // postorder

    private void postorderHelper(Node current) {
        // recursively postorder the BST
        if (current == null) {
            return;
        } //if
        postorderHelper(current.leftChild);
        postorderHelper(current.rightChild);
        if (current.key != -1) {
            System.out.print(current.key + " ");
        } //if
    } // postorderHelper

    public void inorder() {
        Node current = this.root;
        this.inorderHelper(current);
    } // inorder

    private void inorderHelper(Node current) {
        // recursively inorder the BST
        if (current == null) {
            return;
        } //if
        inorderHelper(current.leftChild);
        if (current.key != -1) {
            System.out.print(current.key + " ");
        } //if
        inorderHelper(current.rightChild);
    } // inorderHelper

} // BST
