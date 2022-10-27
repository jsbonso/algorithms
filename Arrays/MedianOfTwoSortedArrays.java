/**
 
  Median of Two Sorted Arrays

    Given two sorted arrays nums1 and nums2 of size m and n respectively, 
        return the median of the two sorted arrays.

    The overall run time complexity should be O(log (m+n)).


  Examples:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    
    
  Approach  

*/

class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int median = nums1.length;
      int nums2Length = nums2.length;
	    int left = (median + nums2Length + 1) / 2;
	    int right = (median + nums2Length + 2) / 2;
      
      // recursively fetch the media values
	    return (double)(getkth(nums1, 0, nums2, 0, left) + 
                      getkth(nums1, 0, nums2, 0, right)) / 2;
	}

    // Recursive function to traverse the arrays
    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
	    
        if (aStart > A.length - 1){ 
            return B[bStart + k - 1];
        }     

	    if (bStart > B.length - 1) {
            return A[aStart + k - 1];  
        }              
	    if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
	
	    int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;
	    if (aStart + k/2 - 1 < A.length){ 
            aMid = A[aStart + k/2 - 1]; 
        }
	    
        if (bStart + k/2 - 1 < B.length){
            bMid = B[bStart + k/2 - 1];  
        }      
	
	    if (aMid < bMid){
            // Check: aRight + bLeft 
	        return getkth(A, aStart + k/2, B, bStart, k - k/2);
        } else {
            // Check: bRight
	        return getkth(A, aStart,       B, bStart + k/2, k - k/2);
        }
    }
}
