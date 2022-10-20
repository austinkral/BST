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

    //finder method that finds a node based on its element in the tree and returns it
    //returns -1 if the element is not found
    private Node finder (Node r, int element) {
        if (r == null) {
            Node newNode = new Node();
            newNode.leftChild = null;
            newNode.rightChild = null;
            newNode.key = -1;
            return newNode;
        } //if
        if (element < r.key) {
            return finder(r.leftChild, element);
        } else if (element > r.key) {
            return finder(r.rightChild, element);
        } else {
            return r;
        } //if
    } //finder

    //insert method that inserts an element into the BST in the correct posiiton
    //if the element is already in the tree, it prints a message to the user
    public void insert(int element) {
        //if  the tree is empty, make the element the root
        if (root == null) {
            //creating the new node to be inserted
            Node temp = new Node(element);
            temp.leftChild = null;
            temp.rightChild = null;
            root = temp;
            size++;
            return;
        } //if

        //creating the new node to be inserted
        Node temp = new Node(element);
        temp.leftChild = null;
        temp.rightChild = null;

        //if element is already in tree, print message to user
        Node found = finder(root, element);
        if (finder(root,element).key != -1) {
            System.out.println("Element is already in the tree!");
            return;
        } //if

        Node temproot = root;
        Node leaf = root;
        while (temproot != null) {
            leaf = temproot;
            if (element > temproot.key) {
                temproot = temproot.rightChild;
            } else {
                temproot = temproot.leftChild;
            } //if
        } //while

        //inserting the new node as a child of the appropriate leaf
        if (element < leaf.key) {
            leaf.leftChild = temp;
        } else {
            leaf.rightChild = temp;
        } //else
        size++;
    } // insert

    //delete method that removes the specified element from the tree
    //if the element is not in the tree, it prints a message to the user
    public void delete(int element) {
        Node temp = finder(root, element);
        if (temp.key == -1) {
            System.out.println("Element not found!");
            return;
        } //if
        temp.key = -1;
        size--;
    } // delete


    //calls the helper method to print out the tree in the preorder traversal order
    public void preorder() {
        Node current = this.root;
        this.preorderHelper(current);
    } // preorder

    //prints out the elements in the tree according to their order in a preorder traversal
    //node, left, right
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

    //calls the helper method to print out the tree in the postorder traversal order
    public void postorder() {
        Node current = this.root;
        this.postorderHelper(current);
    } // postorder

    //prints out the elements in the tree according to their order in a postorder traversal
    //left,right,node
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
