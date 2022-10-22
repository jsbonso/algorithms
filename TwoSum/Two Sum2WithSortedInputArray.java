/**
Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.




 */

class Solution {

    public int[] twoSum(int[] nums, int target) {

        int left = 0;
        int midValue = nums[nums.length/2];

        /**
            - if the target is less than the mid value and the input array length is
              greater than 2 (since the minimum size to have a mid element is 3), then set the
              value of the right variable to the index of the middle. 
            - Else, use the right-most index for the right pointer.
            - This will possibly halve the running time if the 
         
         */
        int right = (target < midValue  && nums.length > 2) ? nums.length/2 : nums.length - 1;
           
	
        // Move the left and right pointer closer to the middle of the array
        // unitl their values are equals to the target
	    while (nums[left] + nums[right] != target) {
            //System.out.println(nums[left] + " " + nums[right] );
		    if (nums[left] + nums[right] < target) left++;
		    else right--;
	    }
        
        // Adding 1 to left and right variables since the requirement asks 
        // for the ordinal position (index+1) and not actual index 
	    return new int[] {left+1, right+1};
 
    }
}
