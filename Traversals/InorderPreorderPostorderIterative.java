
/*
 Depth-First Search (DFS) Inorder, Preorder and Postorder demo using an Iterative method
*/

import java.util.*;

class Node{
    int value;
    Node left, right;
    
    Node(int value){
        this.value = value;
        this.left = this.right = null;
    }
    
    Node(int value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
}

class BinarySearchTree{
    
    Node root;
    
    BinarySearchTree(){
        this.root = null; 
    }
    
    
    BinarySearchTree(int value){
        this.root = new Node(value); 
    }
    
    search(int value){
        
    }
    
    void insertNode(int value){
        this.root = insert(root, value);
    }
    
    Node insert(Node root, int value){
    
        if (root == null) return new Node(value);
        else if (value < root.value) root.left = insert(root.left, value);
        else if (value > root.value) root.right = insert(root.right, value);
        
        return root;
    }
    void inorder() {
        if (root == null) return;
  
  
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
  
        // traverse the tree
        while (current != null || stack.size() > 0)
        {
  
            /* Reach the left most Node of the
            curr Node */
            while (current !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                stack.push(current);
                current = current.left;
            }
  
            // Current must be NULL at this point 
            current = stack.pop();
  
            System.out.print(current.value + " ");
  
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            current = current.right;
        }
    }
    
    void preorder() {
         preorder(root); 
    }
    /**
     *  
     */
    void preorder(Node node) {
        
        if (node == null) return;
 
        // Create an empty stack and push root to it
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
 
        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (!stack.empty()) {
 
            // Pop the top item from stack and print it
            Node mynode = stack.peek();
            System.out.print(mynode.value + " ");
            stack.pop();
 
            // Push right and left children of the popped node to stack
            if (mynode.right != null)  stack.push(mynode.right);
            if (mynode.left != null) stack.push(mynode.left);
            
        }
    }
    
    void postorder() {
         postorder(root); 
    }
    /**
     *  
     */
    void postorder(Node node) {
         // create another stack to store postorder traversal
        LinkedList<Integer> result = new LinkedList<>();
        
	    Stack<Node> stack = new Stack<>();
	    if (root == null) return;
	
	    stack.push(root);
	    
	    while (!stack.isEmpty()) {
		    Node current = stack.pop();
		    result.push(current.value);
		    if (current.left != null) stack.push(current.left);
		    if (current.right != null) 	stack.push(current.right);
		 
	    }
	    
	    for (Integer p : result){
	        
		    System.out.print(p + " ");
	    }
    }    
    
    
    
 

    
}


public class InorderPreorderPostorderIterative
{
    public static void main(String[] args) {
        
        
        BinarySearchTree bst = new BinarySearchTree();
        
        /* Create the following tree structure
        Order of Insertion: 5 , 3 , 7 , 1, 4, 6, 9
        
                   5
                 /   \
                3      7
              /  \    /  \
             1   4   6    9
        */
        bst.insertNode(5);
        bst.insertNode(3);
        bst.insertNode(7);
        bst.insertNode(1);
        bst.insertNode(4);
        bst.insertNode(6);
        bst.insertNode(9);
        
        System.out.println("In order...");
        bst.inorder();
        
        System.out.println("\nPre order...");
        bst.preorder();
        
        System.out.println("\nPost order...");
        bst.postorder();
    }
}
