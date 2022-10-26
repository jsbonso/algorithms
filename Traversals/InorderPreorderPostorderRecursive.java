
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

    
    void insertNode(int value){
        this.root = insert(root, value);
    }
    
    Node insert(Node root, int value){
    
        if (root == null) return new Node(value);
        else if (value < root.value) root.left = insert(root.left, value);
        else if (value > root.value) root.right = insert(root.right, value);
        
        return root;
    }
    void inorder(){
        inorder(this.root);
    }
    
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
        
  
    }
    
    void preorder() {
         preorder(root); 
    }
    /**
     *  
     */
    void preorder(Node node) {
        
        if (root == null) return;
        
        System.out.print(root.value + " ");
        inorder(root.left);
        inorder(root.right);
            
        
    }
    
    void postorder() {
         postorder(root); 
    }
    /**
     *  
     */
    void postorder(Node node) {
        if (root == null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.value + " ");
    }    
    
}


public class InorderPreorderPostorderRecursive
{
    public static void main(String[] args) {
        
        
        BinarySearchTree bst = new BinarySearchTree();
         a
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
