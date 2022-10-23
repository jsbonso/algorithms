
/*
   Stack Example.
   
   INSIGHT:
        - A stack follows the concept of LIFO (Last In, First Out)
        - The core operations of a stack are:
            1. push 
            2. pop
            
        - This means that the last element that goes to the stack is also the first one to go out
        - In Java, the Stack interface has the following operations:
            1.    push() - add an element to the stack
            2.     pop() - returns and removes the element from the stack based on its insertion order (LIFO)
            3.    peek() - only returns the current top element from the stack based on its insertion order (LIFO)
            4.   empty() - checks if the stack is empty
            5. search(o) - searches the object (o) from the stack
   
   CONSTRAINTS:
        - ArrayDeque does NOT support NULL values
*/

import java.util.*;

public class Stack{
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
    
        // Check the initial content of the queue
        System.out.println("Stack: " + stack);
            
        // Push one element to the stack    
        stack.push(8);
        System.out.println("Stack: " + stack);
        
        // Push another element to the stack
        stack.push(2);
        System.out.println("Stack: " + stack);
        
        // Push multiple elements to the stack
        stack.push(4);
        stack.push(9);
        stack.push(7); // last element to be added
        System.out.println("Stack: " + stack);
        
        // Remove the top element to the stack
        // so since the last one we added was 7, this number will be deleted first as per the LIFO concept.
        stack.pop();
        System.out.println("Stack: " + stack);
        
        // Let's iterate through the stack and remove the value
        // as long as it is NOT empty.
        
        while (!stack.empty()){
            stack.pop();
            System.out.println("Is the queue stack? " + stack.empty());
        }

    }
}
