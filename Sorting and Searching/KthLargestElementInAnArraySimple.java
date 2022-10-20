
/*
     An overly simply solution for the Kth Largest Element in Array Problem
     using Arrays.sort
*/

import java.util.Arrays;
public class Main
{
    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        
         /**
         *  TEST SET 1
         * 
         *  {3, 2, 1, 5, 6, 4}
         * 
         *  1st Largest = 6
         *  2nd Largest = 5
         *  3rd Largest = 4
         * 
         */ 
         
        int[] inputSet1 = new int[]{3, 2, 1, 5, 6, 4};
        int KthLargestElementTest1 = 1; // Get the 1st Largest Element of the array
        System.out.println(KthLargestElementInAnArraySimpleSort(inputSet1, KthLargestElementTest1));
        
        int KthLargestElementTest2 = 2; // Get the 2nd Largest Element of the array
        System.out.println(KthLargestElementInAnArraySimpleSort(inputSet1, KthLargestElementTest2));
        
        int KthLargestElementTest3 = 3; // Get the 3rd Largest Element of the array
        System.out.println(KthLargestElementInAnArraySimpleSort(inputSet1, KthLargestElementTest3));
        
        /**
         *  TEST SET 2 
         *  {60, 20, 10, 80, 100, 50, 40, 90}
         * 
         *  1st Largest = 100
         *  2nd Largest = 90
         *  3rd Largest = 80
         *  4th Largest = 60
         */ 
         
        int[] inputSet2 = new int[]{60, 20, 10, 80, 100, 50, 40, 90};
         
        int KthLargestElementTest4 = 2; // Get the 2nd Largest Element of the array
        System.out.println(KthLargestElementInAnArraySimpleSort(inputSet2, KthLargestElementTest4));
        
        int KthLargestElementTest5 = 3; // Get the 3rd Largest Element of the array
        System.out.println(KthLargestElementInAnArraySimpleSort(inputSet2, KthLargestElementTest5));
        
        int KthLargestElementTest6 = 4; // Get the 4th Largest Element of the array
        System.out.println(KthLargestElementInAnArraySimpleSort(inputSet2, KthLargestElementTest6));
        
    }
    
    /**
     Returns the Kth Largest Element of a given array, where "K" is the ordinal position 
        (e.g. 2 = 2nd largest element   
              3 = 3rd largest element
    
        Examples:

        INPUT:  {3, 2, 1, 5, 6, 4}   KthLargestElement = 2 
        OUTPUT: 6
        
        INPUT:  {3, 2, 1, 5, 6, 4}   KthLargestElement = 3 
        OUTPUT: 4
        
        INPUT:  {3, 2, 1, 5, 6, 4}   KthLargestElement = 1 
        OUTPUT: 6
              
    INSIGHT:
        - Sort the input array from  smallest to largest number 
        - Return the element with "array length - kth" as the index 
              
    CONSTRAINTS:
        - The input array is a set of non-repeating integgers
        
    PERFORMANCE:
        Time Complexity : Summation of O(n log n) + O(1)
             -  Sorting: O(n log n)
             -  Constant time for direct access to array O(1) via index
            
        Space Complexity : O (n) 
             -  Arrays.sort is using a custom timsort (mergesort + insertion sort combo) with O (n) space complexity 
     
     */
     
    static int KthLargestElementInAnArraySimpleSort(int[] input, int KthLargestElement){
        
        Arrays.sort(input);
        return input[input.length-KthLargestElement];
        
    }
}

