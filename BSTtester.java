public class BSTtester {

    public static void main(String[] args) {

        // Create new binary search tree
        BST tree = new BST();
        BST tree2 = new BST();

        // tree tests

        // Test insert
        tree.insert(4);
        tree.insert(5);
        tree.insert(2);
        tree.insert(9);
        tree.insert(6);
        tree.insert(11);
        tree.insert(10);
        tree.insert(8);
        tree.insert(1);
        tree.insert(14);
	tree.insert(14);
        System.out.println("Example 1: preorder traversal");
        System.out.println("Expected:\t" + "4 2 1 5 9 6 8 11 10 14");
        System.out.print("Your Tree:\t");
        // Test preorder
        tree.preorder();


        System.out.println("\nExample 2: postorder traversal");
        System.out.println("Expected:\t" + "1 2 8 6 10 14 11 9 5 4");
        System.out.print("Your Tree:\t");
        // Test postorder
        tree.postorder();


        System.out.println("\nExample 3: inorder traversal");
        System.out.println("Expected:\t" + "1 2 4 5 6 8 9 10 11 14");
        System.out.print("Your Tree:\t");
        // Test inorder + delete
        tree.inorder();

	tree.delete(200);
	System.out.println("\nExample 4: preorder traversal after deleting a "
			   + "leaf");
	System.out.println("Expected:\t" + "4 2 1 5 9 6 8 11 10 14");
	System.out.print("Your Tree:\t");
	// Test preorder + delete
	tree.preorder();

        System.out.println();
        tree.delete(6);
        System.out.println();
        System.out.println("\nExample 5: preorder traversal after deleting a "
			   + "node with one child");
        System.out.println("Expected:\t" + "4 2 1 5 9 8 11 10 14");
        System.out.print("Your Tree:\t");
        tree.preorder();

        tree.delete(9);
        System.out.println("\nExample 6: preorder traversal after deleting a "
			   + "node with two children");
        System.out.println("Expected:\t" + "4 2 1 5 8 11 10 14");
        System.out.print("Your Tree:\t");
        tree.preorder();


        System.out.println("\nExample 7: size of the tree after insertions and "
			   + "deletions");
        System.out.println("Expected:\t" + "7");
        System.out.println("Your Tree:\t" + tree.size());

        // tree2 tests

        // Test insert
        tree2.insert(789);
        tree2.insert(1098);
        tree2.insert(34);
        tree2.insert(1);
        tree2.insert(90);
        tree2.insert(110);
        tree2.insert(2);
        tree2.insert(5690);
        tree2.insert(73);
        tree2.insert(14);
        System.out.println("Example 1: preorder traversal");
        System.out.println("Expected:\t" + "789 34 1 2 14 90 73 110 1098 5690");
        System.out.print("Your Tree:\t");
        // Test preorder
        tree2.preorder();


        System.out.println("\nExample 2: postorder traversal");
        System.out.println("Expected:\t" + "14 2 1 73 110 90 34 5690 1098 789");
        System.out.print("Your Tree:\t");
        // Test postorder
        tree2.postorder();


        System.out.println("\nExample 3: inorder traversal");
        System.out.println("Expected:\t" + "1 2 14 34 73 90 110 789 1098 5690");
        System.out.print("Your Tree:\t");
        // Test inorder + delete
        tree2.inorder();

        tree2.delete(110);
        System.out.println("\nExample 4: preorder traversal after deleting a "
			   + "leaf");
        System.out.println("Expected:\t" + "789 34 1 2 14 90 73 1098 5690");
        System.out.print("Your Tree2\t");
        // Test preorder + delete
        tree2.preorder();


        tree2.delete(34);
        System.out.println("\nExample 5: postorder traversal after deleting a "
			   + "node with one child");
        System.out.println("Expected:\t" + "2 1 73 90 14 5690 1098 789");
        System.out.print("Your Tree:\t");
        tree2.postorder();


        tree2.delete(789);
        System.out.println("\nExample 6: inorder traversal after deleting the "
			   + "root node");
        System.out.println("Expected:\t" + "1 2 14 73 90 1098 5690");
        System.out.print("Your Tree:\t");
        tree2.inorder();

	tree2.delete(90);
	System.out.println("\nExample 7: inorder traversal after deleting 90");
        System.out.println("Expected:\t" + "1 2 14 73 1098 5690");
        System.out.print("Your Tree:\t");
        tree2.inorder();
	
	tree2.delete(73);
	System.out.println("\nExample 8: inorder traversal after deleting 73");
        System.out.println("Expected:\t" + "1 2 14 1098 5690");
        System.out.print("Your Tree:\t");
        tree2.inorder();
	
	tree2.delete(1);
	System.out.println("\nExample 9: inorder traversal after deleting 1");
        System.out.println("Expected:\t" + "2 14 1098 5690");
        System.out.print("Your Tree:\t");
        tree2.inorder();
	
	tree2.delete(2);
	System.out.println("\nExample 10: inorder traversal after deleting 2");
        System.out.println("Expected:\t" + "14 1098 5690");
        System.out.print("Your Tree:\t");
        tree2.inorder();
	
	tree2.delete(5690);
	System.out.println("\nExample 11: inorder traversal after deleting 5690");
        System.out.println("Expected:\t" + "14 1098");
        System.out.print("Your Tree:\t");
        tree2.inorder();
	
	tree2.delete(1098);
	System.out.println("\nExample 12: inorder traversal after deleting 1098");
        System.out.println("Expected:\t" + "14");
        System.out.print("Your Tree:\t");
        tree2.inorder();
	
	tree2.delete(14);
	System.out.println("\nExample 13: inorder traversal after deleting 14");
        System.out.println("Expected:\t" + "");
        System.out.print("Your Tree:\t");
        tree2.inorder();
	
        System.out.println("\nExample 14: size of the tree after insertions and "
			   + "deletions");
        System.out.println("Expected:\t" + "0");
        System.out.println("Your Tree:\t" + tree2.size());
    } // main

} // BSTtester
