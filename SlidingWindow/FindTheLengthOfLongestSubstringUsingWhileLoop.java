class FindTheLengthOfLongestSubstringUsingWhileLoop {
    public int lengthOfLongestSubstring(String s) {
        
        /**
            Examples: 
          
              #1 - 
                eabcdabcbb = 4
                "abcd" is the longest substring
                4 is the length of "abcd"

              #2 -             
              bbbbb = 1
              "b" is the longest substring
              1 is the length of the substring "b" (which is just one character)

              #3 -                
              pwwkew = 3
              "pww" is the longest substring
              3 is the length of "pww"

         */

         Map<Character, Integer> map = new HashMap<Character, Integer>();
         int result = 0;

        /**
            Sliding Window technique with an (O)n time complexity performance
            that uses a while loop
        */
        int left=0;
        int right=0;
        while (right < s.length()){
            // check map if it already contains the character
            if (map.containsKey(s.charAt(right))){
                int indexOfExistingChar = map.get(s.charAt(right));
                // Update the value of the left pointer
                // to the index of the matched character, 
                // or to its current value, whichever is greater. 
                left = Math.max(indexOfExistingChar, left);    
            }

            // Update the result value by getting the difference 
            // of the right and left pointer plus 1 (as per the requirement)
            // or to its current value, whichever is greater
            result = Math.max(right - left + 1, result);

            // Put the Character as the key and the index as the value
            map.put(s.charAt(right), right+1);
            right++; 

        }

        return result;

    }



}
