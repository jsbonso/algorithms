
/*
    You are given a binary string, s, consisting of characters '0' and '1'. 
    Transform this string into a palindrome by performing some operations. 
    In one operation, swap any two characters, s[i] and s[j]
    
    Determine the minimum number of swaps required to make the string a palindrom.
    If it is impossible to do so, then return -1.
    
    Note:
    A palindrome is a string that reads the same backward as forward, for example, strings "0",
    "111" 010 10101 are palindromes, but strings 001 10 11101 are not. 
    
    
    Example: 
    
    Let string s = "0100101". 
    The following shows the minimum number of steps required. It uses 1-based indexing.
    
    1. Swap characters with indices (4,5)
    2. Swap characters with indices (1,2)
    
    Now, the binary string is now palindromic. 
    The answer is 2 swaps.
    
    
    
*/

public class Main
{
    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        
        System.out.println(minSwapsRequired("0100101") == 2 ? "Test Passed ✅ " : "Test Failed ❌/");
        System.out.println(minSwapsRequired("letelt") == 2 ? "Test Passed ✅ " : "Test Failed ❌/");
        System.out.println(minSwapsRequired("aabb") == 2 ? "Test Passed ✅ " : "Test Failed ❌/");
        System.out.println(minSwapsRequired("10011") == 1 ? "Test Passed ✅ " : "Test Failed ❌/");
        System.out.println(minSwapsRequired("abba") == 0 ? "Test Passed ✅ " : "Test Failed ❌/");
        System.out.println(minSwapsRequired("ababa") == 0 ? "Test Passed ✅ " : "Test Failed ❌/");
        
        System.out.println(minSwapsRequired("dammitimmad") == 0 ? "Test Passed ✅ " : "Test Failed ❌/");
        System.out.println(minSwapsRequired("dammmtiimad") == 4 ? "Test Passed ✅ " : "Test Failed ❌/");
        System.out.println(minSwapsRequired("ddmmitimmaa") == 16 ? "Test Passed ✅ " : "Test Failed ❌/");

        // not palindrome
  
        System.out.println(minSwapsRequired("ddmmitimmaaxcve") == 5 ? "Test Passed ✅ " : "Test Failed ❌/");


    }
    
    /**
     *  Returns the minimum number of swaps required to make the given string a Palindrom.
     *  If the result is...
     *      0 - then the given string is already a palindrome
     *      1 - it takes one swap to make the string a palindrome
     */ 
    public static int minSwapsRequired(String s){
       int count = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while(sb.length() > 2) {
            char left = sb.charAt(0);
            int len = sb.length();
            char right = sb.charAt(len - 1);
            
            if (left == right) {
                sb.deleteCharAt(len - 1);
                sb.deleteCharAt(0);
                // System.out.println("SB match: " + sb);
            } else {
                int id1 = sb.lastIndexOf(Character.toString(left));
                int id2 = sb.indexOf(Character.toString(right));
                
                int steps1 = len - id1 - 1;
                int steps2 = id2;
                                
                if (steps1 > steps2) { // keep last char, move char at id2
                    count += steps2;
                    sb.deleteCharAt(id2);
                    sb.deleteCharAt(sb.length() - 1);
                    
                    // System.out.println("SB not match IF: " + sb);
                    
                } else {// keep first char, move char at id1
                    count += steps1;
                    sb.deleteCharAt(id1);
                    sb.deleteCharAt(0);      
                    // System.out.println("SB not match Else: " + sb);
                }
                
                
            }
        }
        
        //System.out.println("SB : " + sb);
        System.out.println("Input: " + s +  " Result: " + count);
        return count;
    }
}
