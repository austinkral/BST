public class BST {
    //node class
    public class Node {

        //instance variables for the key, parent, leftChild, and rightChild
        private int key;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        //constructor for Node
        public Node() {
            this.key = -1;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        } // Node

        //constructor for Node given the key
        public Node(int key) {
            this.key = key;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        } // Node

        //constructor for Node given all variables that a Node contains
        public Node(int key, Node parent, Node leftChild, Node rightChild) {
            this.key = key;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        } // Node

        //sets the key for the Node
        private void setKey(int key) {
            this.key = key;
        } // setKey

        //gets the key for the Node
        public int getKey() {
            return key;
        } // getKey

        //sets the parent for the Node
        private void setParent(Node parent) {
            this.parent = parent;
        } // setParent

        //gets the parents for the Node
        public Node getParent() {
            return parent;
        } // getParent

        //sets the Left Child of the Node
        private void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        } // setLeftChild

        //gets the Left Child of the Node
        public Node getLeftChild() {
            return leftChild;
        } // getLeftChild

        //sets the Right Child of the Node
        private void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        } // setRightChild

        //gets the Right Child of the Node
        public Node getRightChild() {
            return rightChild;
        } // getRightChild

    } // Node


    //variables that keep track of the root and the size
    private Node root;
    private int size;


    //constructor for the BST
    public BST() {
        this.root = null;
        this.size = 0;
    } // BST

    //size method that returns the size of the tree
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

    private int inorderPred(Node predNode) {
        Node current = predNode;
        if (current.getRightChild() != null ) {
            return inorderPred(current.getRightChild());
        } // while
        return current.getKey();
    } // inorderPred

    //insert method that inserts an element into the BST in the correct posiiton
    //if the element is already in the tree, it prints a message to the user
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


    //calls the helper method to print out the tree in the preorder traversal order
    public void delete(int element) {
        Node current = this.root;
        if (find(current, element) == null) {
            System.out.println("Element not found!");
        } else {
            deleteRec(current, element);
            size--;
        } // if
    } // delete



    private Node deleteRec(Node current, int element) {
	if (current == null) return current;
	if (element < current.getKey()) {
	    current.setLeftChild(deleteRec(current.getLeftChild(), element));
	} else if (element > current.getKey()) {
	    current.setRightChild(deleteRec(current.getRightChild(), element));
	} else {
	    if (current.getLeftChild() == null && current.getRightChild() == null) {
            return null;
	    } else if (current.getLeftChild() == null) {
            return current.getRightChild();
	    } else if (current.getRightChild() == null) {
            return current.getLeftChild();
	    } else {
            int pred = inorderPred(current.getLeftChild());
            current.setKey(pred);
	        deleteRec(current.getRightChild(), pred);
	    } // if
	} // if
	return current;
} // deleteRec

>>>>>>> 62156c95ed1ca87fa1aadf9fe1a00b320de73101
public void preorder() {
    Node current = this.root;
    this.preorderHelper(current);
} // preorder

//prints out the elements in the tree according to their order in a preorder traversal
//node, left, right
private void preorderHelper(Node current) {
	if (current == null) {
	    return;
	} else if (current.getKey() != -1) {
		System.out.print(current.key + " ");
	} // if
    preorderHelper(current.leftChild);
    preorderHelper(current.rightChild);
} // preorderHelper

//calls the helper method to print out the tree in the postorder traversal order
public void postorder() {
    Node current = this.root;
    this.postorderHelper(current);
} // postorder

//prints out the elements in the tree according to their order in a postorder traversal
//left,right,node
private void postorderHelper(Node current) {
    if (current == null) {
        return;
    } //if
    postorderHelper(current.leftChild);
    postorderHelper(current.rightChild);
    if (current.key != -1) {
        System.out.print(current.key + " ");
    } //if
} // postorderHelper

//calls the helper method to print out the tree in the inorder traversal order
public void inorder() {
    Node current = this.root;
    this.inorderHelper(current);
} // inorder

//prints out the elements in the tree according to their order in an inorder traversal
//left,node,right
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
