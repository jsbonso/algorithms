class RemoveDuplicatesInSortedArray {
    
    /*
        Input: sorted array 
        Outputs: 1. The K length of the unique numbers
                 2. Modified the array where the first part is the list of unique characters
                 
        
        Example #1: 
        Input: nums = [1,1,2]
        Output: 
                2, 
                nums = [1,2,_]
                
        Example #2: 
        Input: nums =  [0,0,1,1,1,2,2,3,3,4]
        Output: 
                2, 
                nums = [0,1,2,3,4,_,_,_,_,_]
        
        
        Constraints: 
            - Sorted Array
            - The length of the input array should still be the same.
            - No extra data structure
            
        Strategy: Use sliding window 

        Approach:

            - The left pointer will add the unique characters
            - The right pointer will traverse and compare the characters 
        
              if the current and next items are equal with each other.
        
        
    */
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;

        System.out.println("original: " + Arrays.toString(nums));
        while ( right < nums.length){
            
            if (nums[left] == nums[right]){
                right++;
            } else { 
                left++;
                nums[left]=nums[right];
            }
            

        }

        System.out.println("modified: " + Arrays.toString(nums));
        // Return the length of the unique character set
        return left+1;
    }
}
