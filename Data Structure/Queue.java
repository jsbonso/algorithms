
/*
   Queue Example.
   
   INSIGHT:
        - A queue follows the concept of FIFO (First In, First Out)
        - The core operations of a queue are:
            1. Enqueue 
            2. Dequeue
            
        - This means that the first element that goes to the queue is also the first one to go out 
        - In Java, the Queue interface has the following operations:
            1.     add() - add an element to the queue
            2.  remove() - returns and removes the element from the queue based on its insertion order (FIFO)
            2.    peek() - only returns the current front element from the queue based on its insertion order (FIFO)
            3. isEmpty() - checks if the queue is empty
   
   CONSTRAINTS:
        - ArrayDeque does NOT support NULL values
*/

import java.util.*;

public class Queue{
    public static void main(String[] args) {
        
        Queue<Integer> queue = new LinkedList<>();
    
        // Check the initial content of the queue
        System.out.println("Queue: " + queue);
            
        // Push one element to the queue    
        queue.add(8);
        System.out.println("Queue: " + queue);
        
        // Push another element to the queue
        queue.add(2);
        System.out.println("Queue: " + queue);
        
        // Push multiple elements to the queue
        queue.add(4);
        queue.add(9);
        queue.add(7);
        System.out.println("Queue: " + queue);
        
        // Remove the front element to the queue
        // so since the first one we added was 8, this number will be deleted first.
        queue.remove();
        System.out.println("Queue: " + queue);
        
        // Let's iterate through the queue and remove the value
        // as long as it is NOT empty.
        
        while (!queue.isEmpty()){
            queue.remove();
            System.out.println("Is the queue empty? " + queue.isEmpty());
        }

    }
}
