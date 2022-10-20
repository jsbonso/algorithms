/**
*

Two Sum Solution #1 - Brute Force Approach
  
  Approach
    - Brute force approach by using a nested loop
    - Create the two loops to process the array, wherein the second loop is one step ahead of the previous loop and traversing the array elements in a quadratic manner
    - The first loop uses the variable i to hold the first index while the second loop uses the variable j to hold the latter one.
    - Compare the values of the i and j indices. If they are the same, return the indices as output
    - Return an empty integer array if no match was found

Complexity
    - Time complexity: O(n^2)
    - Space complexity: O(1)

*/

class TwoSumBruteForce {

    public int[] twoSum(int[] nums, int target) {

        for (int i=0; i < nums.length ;i++){

            for (int j=i+1; j < nums.length ;j++){
                if ((nums[i] + nums[j]) == target){
                   return new int[]{i,j};
                }
            }
        }

        // returns an empty array if no match found
        return new int[]{};
    }
}
