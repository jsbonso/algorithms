class LongestPalindromicSubstringViaBruteForce {
    /*
        Longest Palindromic Substring

        Given a string s, return the longest palindromic substring in s.

        A string is called a palindrome string if the reverse of that 
            string is the same as the original string.

    Example 1:

        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.

    Example 2:

        Input: s = "cbbd"
        Output: "bb"
 

    Constraints:

        1 <= s.length <= 1000
        s  consist of only digits and English letters.


        Insights:
            - Traverse

            1 -  b 
                    a b a d 
            2 -  a 
                    b a d 
            3 -  b 
                    a d                  

    */
    public String longestPalindrome(String s) {
    
        char[] stringArray = s.toCharArray();
        boolean hasPalindrome = false;
        
        // a map sorted in a decreasing order based on the key (palindrome's character length)
        // We used "Collections.reverseOrder()" to make the order descending
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

        for (int i=0; i < stringArray.length; i++){
            String str = stringArray[i]+"";
            for (int j=i+1; j < stringArray.length; j++){
                str += stringArray[j];

                // do palindrome check
                if (palindrome(str)){
                     hasPalindrome = true;
                     map.put((Integer)str.length(), str);
                }
            
            }
        
        }

        return map.isEmpty() ? stringArray[0]+"" : map.firstEntry().getValue();
    }

    boolean palindrome (String input){
        int left = 0;
        int right = input.length()-1;
        char[] c = input.toCharArray();

        while (right >= input.length()/2){
            if (c[left] != c[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
