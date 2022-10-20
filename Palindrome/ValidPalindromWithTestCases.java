
import java.util.*;
import java.lang.Character;

public class ValidPalindromWithTestCases
{
    public static void main(String[] args) {
        
        String input = "ababa";
        String input1 = "mom";
        String input2 = "nono";
        String input3 = "A man, a plan, a canal: Panama!";
        String input4 = "Dammit I'm mad.";
        String input5 = "Philippines";
        
        boolean test1 = isPalindrome(input);
        System.out.println("Is the input: `" + input + "` a palindrome? "  + test1 +  " " + ((test1 == true) ? "\n ✅ PASS " :  "\n❌FAILED" ));
        System.out.println();
        
        boolean test2 = isPalindrome(input1);
        System.out.println("Is the input: `" + input1 + "` a palindrome? " + test2 +  " " + ((test2 == true) ? "\n ✅ PASS " : "\n❌FAILED" ));
        System.out.println();
        
        boolean test3 = isPalindrome(input2);
        System.out.println("Is the input: `" + input2 + "` a palindrome? " + test3 +  " " + ((test3 == false)  ? "\n ✅ PASS " : "\n❌FAILED" ));
        System.out.println();
        
        boolean test4 = isPalindrome(input3);
        System.out.println("Is the input: `" + input3 + "` a palindrome? " + test4 +  " " + ((test4 == true) ? "\n ✅ PASS " :  "\n❌FAILED" ));
        System.out.println();
        
        boolean test5 = isPalindrome(input4);
        System.out.println("Is the input: `" + input4 + "` a palindrome? " + test5 +  " " + ((test5 == true) ? "\n ✅ PASS " :  "\n❌FAILED" ));
        System.out.println();
       
        boolean test6 = isPalindrome(input5);
        System.out.println("Is the input: `" + input5 + "` a palindrome? " + test6 +  " " + ((test6 == false) ? "\n ✅ PASS " :  "\n❌FAILED" ));
        System.out.println();
        
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
     *
     *      - Use two pointers: "left" on the beginning of the array and "right" at the end of the array, 
     *      - Move the "left" and "right" pointers of the array one set inwards the center of the array, comparing their values.
     *      - The input is not a palindrome if the two pointers are not same. Else, the input is a palindrome 
     */
    public static boolean isPalindrome(String input){
        
        System.out.println("Input: " + input);
        System.out.println("Number of characters: " + input.length());
        
        // Format the input to only include numbers and letters
        String formattedInput = "";
        for (char ch : input.toCharArray()){
            if (Character.isDigit(ch)|| Character.isLetter(ch)){
                formattedInput += ch;
            }
        }
        formattedInput = formattedInput.toLowerCase();
        
        // Use two pointers that starts from the outer boundaries of the array and traverse inwards towards the middle.
        int left = 0;
        int right = formattedInput.length() - 1;
        int steps =0;
        while (left < (formattedInput.length()/2)){
            
            steps++; // Not related to the algorightm. Only used for counting the steps to determine the Time Complexity
            
            if (formattedInput.charAt(left) != formattedInput.charAt(right) ){
                System.out.println("Number of Steps: " + steps);
                return false;
            }
            left++;
            right--;
            
            
        }
        
        System.out.println("Number of Steps: " + steps);
        return true;
    }
}
