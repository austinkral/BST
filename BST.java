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

    //finder method that finds a node based on its element in the tree and returns it
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
        /*
        boolean isInserted = false;
        while (!isInserted) {
            if (element > this.root.key) {} // do shit to the right
            if (element < this.root.key) {} // do shit to the left
        } // while
        */
    } // insert

    public void delete(int element) {
        Node temp = finder(root, element);
        temp.key = -1;
        size--;
        //while (r.key != element) {} // do shit
    } // delete

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
