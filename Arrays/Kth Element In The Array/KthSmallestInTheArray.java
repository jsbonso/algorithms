import java.util.Random;

class Solution {

  public int KthSmallestInTheArray.java(int[] nums, int k) {

        // The PriorityQueue implements a MAX heap structure, in which the "root"
        // or the first element in the array is always the maximum/highest value
        // of the entire heap

        PriorityQueue<Integer> heap =
            // To get the Kth SMALLEST Element in an Array
            new PriorityQueue<Integer>(Comparator.reverseOrder());

        // keep k largest elements in the heap
        for (int n: nums) {

          System.out.println("Current head: " + heap.peek());
          System.out.println("Adding: " + n);
          heap.add(n);
         
          System.out.println("New head: " + heap.peek());
           if (heap.size() > k){
              System.out.println("Poll the queue (remove): " + heap.peek());
             
              // To get the Kth SMALLEST Element in an Array 
              heap.remove();
           }
          
          System.out.println("Current Size: " + heap.size());
          System.out.println(Arrays.toString(heap.toArray()));
          System.out.println("Final head: " + heap.peek());
          System.out.println();
         
        }

        return heap.peek();    
  }
}
