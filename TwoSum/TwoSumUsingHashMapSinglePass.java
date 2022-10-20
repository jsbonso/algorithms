/**
*
Two Sum Solution #2 - Using a HashMap and iterates the array in a single pass approach

Author: Jon Bonso
  
Goal: Get the two indices from the array that sums up to the value of the given target

MATH THEORY:

    - The sum is composed to two or more "addends" which has the following formula: 
                sum = number1 + number2
                
    - In this problem set, the sum is called the "target" so...
                target = number1 + number2
                
    - There are different equations that can be derived from the above formula 
        (e.g):
                target  = number1 + number2
                number1 = target  - number2
                number2 = target  - number1
                
    - We will use the (number2 = target  - number1) equation since 
      its standard formula (sum = number1 + number2) is running on a slow quadractic time O(n^2)

APPROACH
    - Instead of just using the "target = number1 + number2" condition, we can utilize one of the addends by using the
      "number2 = target  - number1" equation instead, to identify the value of the other addend. 
    - We will store the elements in a hashmap, where the key is the index of the array and the value is the array elements.
    - For every element, we will run the  "number2 = target  - number1" equation, where the number1 is the current Integer
      in the loop and the number2 variable is the missing addend that must match, in order to get the correct sum.
    
    
COMPLEXITY
    - Time complexity: Linear time – O(n) where n is the size of the array.
    - Space complexity: Linear time – O(n) where n is the size of the array.
    
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class TwoSumUsingHashMapSinglePass {
    
    public static void main(String args[]){
        int nums[] = {7,11,15,2,10,12,34,100};
        int target = 9;
        System.out.println("Target: " + target);
        int indices[] = twoSum(nums,target);
        System.out.println("Indices" + Arrays.toString(indices));
        System.out.println("The sum of : " + nums[indices[0]] + " + " + nums[indices[1]] + " is " + target );
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0; i < nums.length ;i++){
            
            /** the "addend" variable signifies the other part of the sum equation
                In theory:
                target = addend1 + addend2
                target = 9
            
                addend1 = 9 - nums[i]
                The added2 is equivalent to the current nums[i] value
                
                  Formula:  a = target = nums[i]
                  
                  Loop 1:   a = 9 - 7 (the addend must be 2)
                  Loop 2:   a = 9 - 11 (the addend must be -2)
                  Loop 3:   a = 9 - 15 (the addend must be -6)
                  Loop 4:   a = 9 - 2 (the addend must be 7, which we actually have on Loop 1)
            */
            
            
            int addend = target - nums[i];
            
            // checks if the item is already in the map
            /**
             * 
             * Remember that we only need to return the index. 
             *  KEY, VALUE
             *    7    0
             *    11   1
             *    15   2
             *     2   3
             */        
            System.out.println("Looking for " + addend);
            
            // We are using the "containsKey" method since the key contains the array number.
            if (map.containsKey(addend)){
                
                // We have found a match! No need to traverse other succeeding elements.
                // The added and the current item has a sum that is equivalent to the target
                // return the indices from the map and the variable iterator of this for loop ("i")
                
                return new int[]{ map.get(addend) , i }; 
            }
            System.out.println("Adding to the hashmap:  " + nums[i] +  " " + i);
            map.put(nums[i], i);

        }

        // returns an empty array if no match found
        System.out.println("No match found. Returning an empty int array.");
        return new int[]{};
    }
}
