/**
 This tracks the Elapsed Time for the 2 Solutions for the Classic Two Sum Problem
 
 You will discover how immensely better an (O)n solution is (twoSumOptimized) 
 than a brute force (O)n^2 solution (twoSumBruteForce) by checking the start and end 
 times of both methods
*/


import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class TwoSumMethodsPerformanceChecks
{
    public static long optimizedElapsedTime = 0L;
    public static long bruteForceElapsedTime = 0L;
    
    public static void main(String[] args) {
        
        int arr[] = { 15, 10, 4, 12, 11, 8, 6, 5 };
        int target = 10;
        
        // Expected Result:  [2, 6]
        // ( arr[2] = 4 ) + ( arr[4] = 6 )
        
        System.out.println("Brute Force Method Result: " + Arrays.toString(twoSumBruteForce(arr, target)));
        System.out.println();
        System.out.println("Optimized Method Result: " + Arrays.toString(twoSumOptimized(arr, target)));
        System.out.println();
        System.out.println("Brute Force Elapsed Time: " + bruteForceElapsedTime + " milliseconds");
        System.out.println("Optimized  Elapsed  Time:   " + optimizedElapsedTime + " milliseconds");
        System.out.println();
        long perfDiff = (bruteForceElapsedTime / optimizedElapsedTime);
        System.out.println("The Optimized Method is "  + perfDiff + "% faster than the Brute Force Method");
        
        
        

    }
    
    /**
     * An optimized method of getting the indices of two numbers 
     * in an array whose sum is equals to the given target.
     * 
     *  Time Complexity: Linear Time (O)n
     *  Space Complexity: Constant Time (O)1 since no other data structure was used.
     * 
     */
    public static int[] twoSumOptimized(int num[], int target){
        
        long startTime = System.currentTimeMillis();
        System.out.println("Optimized Method START: " + System.currentTimeMillis());
        
        // Create a Hashmap with the key = number input; value = index
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // Loop the array and populate the map. 
        for (int i = 0; i < num.length; i++){
            
            /** target = num1 + num2 
            *   num1 = target - num2
            *   -5    =  10 - 15
            *    0    =  10 - 10
            *    6    =  10 - 4
            */
            
            int addend = target - num[i];
            
            // Check if the addend is in the map
            if (map.containsKey(addend)){
                // we found a match! return the indices
    
                optimizedElapsedTime = System.currentTimeMillis() - startTime;
                
                System.out.println("Optimized Method END  : " + System.currentTimeMillis());
                return new int[]{map.get(addend),i};
            }
            // Add the array number as the key, and the index as the value
            map.put(num[i],i);
            
        }
        System.out.println("Optimized Method END  : " + System.currentTimeMillis());
        optimizedElapsedTime = System.currentTimeMillis() - startTime;
        // return empty array
        return new int[]{};
        
    }
    
    /**
     * A brute force method to get the indices of two numbers 
     * in an array whose sum is equals to the given target.
     * 
     *  Time Complexity: Quadratic Time (O)n^2
     *  Space Complexity: Linear Time (O)n since no other data structure was used.
     * 
     */
    public static int[] twoSumBruteForce(int num[], int target){
        
        long startTime = System.currentTimeMillis();
        System.out.println("Brute Force START: " + System.currentTimeMillis());
        
        
        // input:     15, 10, 4, 12, 11, 8, 6, 5
        // target:    10
    
        /**
         *   1:   outer loop - 15 (compare all 8 numbers below)
         *        inner loop - 15, 10, 4, 12, 11, 8, 6, 5
         * 
         *   2:   outer loop -     10  (compare all 8 numbers below)
         *        inner loop - 15, 10, 4, 12, 11, 8, 6, 5
         * 
         *   3:   outer loop -         4 (compare to all 8 numbers below)
         *        inner loop - 15, 10, 4, 12, 11, 8, 6, 5
         */
        
        
        for (int i = 0; i<num.length ;i++){
            for (int j = 0; j<num.length; j++){
                // check if the sum of the two numbers matches the target
                if ((num[i] + num[j]) == target){
                    // return the indices only, not the value
                    
                    System.out.println("Brute Force END  : " + System.currentTimeMillis());
                    //System.out.println("Brute Force Elapsed Time: " + (System.currentTimeMillis() - startTime) + " milliseconds");
                    bruteForceElapsedTime = System.currentTimeMillis() - startTime;
                    return new int[]{i,j};
                }
              }
        }
        
        System.out.println("Brute Force END  : " + System.currentTimeMillis());
        //System.out.println("Brute Force Elapsed Time: " + (System.currentTimeMillis() - startTime) + " milliseconds");
        // return empty array
        bruteForceElapsedTime = System.currentTimeMillis() - startTime;
        return new int[]{};
        
    }
}
