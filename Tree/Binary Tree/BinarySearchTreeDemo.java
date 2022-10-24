class Node{
    
    String value;
    Node left, right;
    
    Node(String value){
        this.value = value;
        left = right = null;
    }
    
        Node(String value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    
}
public class BinarySearchTreeDemo
{
    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        
        Node root = new Node("3");
        root.left = new Node("4");
        root.right = new Node("5");
        
    }
}
