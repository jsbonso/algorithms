

public class BasicPalindrome
{
    public static void main(String[] args) {
        
        String input = "ababa";
        String input1 = "mom";
        String input2 = "nono";
        String input3 = "A man, a plan, a canal: Panama!";
        String input4 = "Dammit I'm mad.";
        String input5 = "Philippines";
        
        System.out.println("Is the input: `" + input + "` a palindrome? " + isPalindrome(input));
        System.out.println("Is the input: `" + input1 + "` a palindrome? " + isPalindrome(input1));
        System.out.println("Is the input: `" + input2 + "` a palindrome? " + isPalindrome(input2));
        System.out.println("Is the input: `" + input3 + "` a palindrome? " + isPalindrome(input3));
        System.out.println("Is the input: `" + input4 + "` a palindrome? " + isPalindrome(input4));
        System.out.println("Is the input: `" + input5 + "` a palindrome? " + isPalindrome(input5));
    }

    /**
     *  Checks if a given string is a palindrome.
     * 
     *  Essentially, a palindrome is simply a string that is the same when reversed.
     * 
     *  e.g:    
     *          ababa = ababa
     *           mom  = mom
     *           noon = noon
     *           
     *  Approach: 
     *      - Reverse the string and check if it still the same. 
     */
    public static boolean isPalindrome(String input){
        
        // System.out.println("raw input: " + input); 
        input = input.replaceAll("[^a-zA-Z]", "");
        input = input.toLowerCase();
        // System.out.println("trimmed input: " + input); 
        
        char[] ch = input.toCharArray();
        int right = 0;
        right = ch.length - 1;
        
        for (int i=0;i < ch.length/2 ;i++){
            if (ch[i] != ch[right--]){
                return false;
            }
        }
        
        return true;
    }
}
