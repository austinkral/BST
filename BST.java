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

    //======================================================
    // Finds the inorder predecessor of predNode
    //======================================================
    private int inorderPred(Node predNode) {
        Node current = predNode;
        if (current.getRightChild() != null ) {
            return inorderPred(current.getRightChild());
        } // while
        return current.getKey();
    } // inorderPred

    //======================================================
    // Calls method to recursively insert a new element
    //======================================================
    public void insert(int element) {
	    Node current = this.root; 
	    if (root == null) {
	        root = new Node(element);
	        System.out.println("Root: " + root.getKey());
	    } else {
	      insertRec(current, element);
	    } // if
	    size++;
    } // insert

    //======================================================
    // Recursively inserts a new node in the BST with
    // key = element
    //======================================================
    private void insertRec(Node current, int element) {
        	Node insert = new Node(element);
	if (element < current.getKey()) {
	    if (current.getLeftChild() != null) {
		insertRec(current.getLeftChild(), element);
	    } else {
		current.setLeftChild(insert);
		insert.setParent(current);
		System.out.println("Inserted: " + insert.getKey());
		System.out.println("Inserted parent: " + insert.getParent().getKey());
	    } // if
	} else if (element > current.getKey()) {
	    if (current.getRightChild() != null) {
		insertRec(current.getRightChild(), element);
	    } else {
		current.setRightChild(insert);
		insert.setParent(current);
		System.out.println("Inserted: " + insert.getKey());
		System.out.println("Inserted parent: " + insert.getParent().getKey());
	    } // if
	} else {
	    System.out.println("Element is already in the tree!");
	} // if
    } // insertRec

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



  //======================================================
  // Calls method to recursively delete the node with
  // key = element if it exists in the BST; otherwise,
  // prints "Element not found!"
  //======================================================
  public void delete(int element) {
	  Node current = this.root;
	  if (find(current, element) == null) {
	    System.out.println("Element not found!");
	  } else {
	    deleteRec(current, element);
	    size--;
	  } // if
  } // delete

   //======================================================
   // Recursively deletes the node with key = element
   // and refactors BST
   //======================================================
  private void deleteRec(Node current, int element) {
	  if (current == null) return;
	  if (element < current.getKey()) {
	    deleteRec(current.getLeftChild(), element);
	  } else if (element > current.getKey()) {
	    deleteRec(current.getRightChild(), element);
	  } else {
	    if (current.getLeftChild() == null && current.getRightChild() == null) {
		    if (current == root) {
		      root = null;
		  } else if (current.getParent().getKey() > current.getKey()) {
		    Node parent = current.getParent();
		    parent.setLeftChild(current.getLeftChild());
		  } else if (current.getParent().getKey() < current.getKey()) {
		    Node parent = current.getParent();
		    parent.setRightChild(current.getRightChild());
		  } // if
	  } else if (current.getLeftChild() == null) {
		  if (current == root) {
		    root = current.getRightChild();
		  } else {
		    current.getParent().setRightChild(current.getRightChild());
		  } // if
	  } else if (current.getRightChild() == null) {
		  if (current == root) {
		    root = current.getLeftChild();
		  } else {
		    current.getParent().setLeftChild(current.getLeftChild());
		  } // if
	  } else {
		int pred = inorderPred(current.getLeftChild());
		current.setKey(pred);
	  deleteRec(current.getLeftChild(), pred);
	  } // if
	} // if
    } // deleteRec

    //======================================================
    // Calls recursive preorder method
    //======================================================
    public void preorder() {
        Node current = this.root;
        this.preorderHelper(current);
    } // preorder

    //======================================================
    // Recursively iterates through the BST preorder and
    // prints each element
    //======================================================
    private void preorderHelper(Node current) {
	if (current == null) return;
	System.out.print(current.key + " ");
        preorderHelper(current.leftChild);
        preorderHelper(current.rightChild);
    } // preorderHelper

    //======================================================
    // Calls recursive postorder method 
    //======================================================
    public void postorder() {
        Node current = this.root;
        this.postorderHelper(current);
    } // postorder

    //======================================================
    // Recursively iterates through the BST postorder and
    // prints each element
    //======================================================
    private void postorderHelper(Node current) {
        if (current == null) return;
        postorderHelper(current.leftChild);
        postorderHelper(current.rightChild);
	System.out.print(current.key + " ");
    } // postorderHelper

    //======================================================
    // Calls recursive inorder method
    //======================================================
    public void inorder() {
        Node current = this.root;
        this.inorderHelper(current);
    } // inorder

    //======================================================
    // Recursively iterates through the BST inorder and
    // prints each element
    //======================================================
    private void inorderHelper(Node current) {
        // recursively inorder the BST
        if (current == null) return;
        inorderHelper(current.leftChild);
	System.out.print(current.key + " ");
        inorderHelper(current.rightChild);
    } // inorderHelper

} // BST
