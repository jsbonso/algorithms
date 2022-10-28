class LongestPalindromicSubstringUsingSlidingWindow {
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
            - Traverse every element, and do an expanding sliding window from that element as the center
            
        Visualization:
        
        Input: babad
          
            1:  <b> a b a d 
                1.1   -- expandingWindow won't run
                
            2:  b <a> b a d 
                2.1   b <a> b
                2.2   Found a palindrome. Note the start and index.
              
            3:  b a <b> a d 
                2.1   a <b> a
                2.2   b _ <b> _ d
                2.2   No palindrome.
                 
    */
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
