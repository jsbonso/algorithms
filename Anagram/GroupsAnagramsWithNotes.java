import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class GroupsAnagramsWithNotes {
    
    /**
    
    Returns a list of a list of Anagram Strings
    https://github.com/jsbonso/algorithms
      Input:  ["eat","tea","tan","ate","nat","bat"]
      Output: [ ["bat"],
                ["nat","tan"],
                ["ate","eat","tea"]]
                
      INSIGHTS:
        - An anagram is just another word that has exactly the same characters 
          of the original word but in different arrangement
          
            Example:
                 eat  = tea
                 star = rats
        
        - If your rearranged the characters of the two anagram words in alphabetical order, 
          the output should be exactly the same.  
          
            Example:
            
                 "eat" and "tea" are anagrams:
                 
                 "eat" is "aet" in alphabetical order
                 "tea" is "aet"  in alphabetical order
                 
                 "aet" = "aet" are the same, thus, the words "eat" and "tea" are indeed anagrams
        

                
      APPROACH: 
        - Convert the string into a character array 
        - Sort the character array into alphabetical order
        - Use 
      
      CONSTRAINTS:
        - All letters are in lowercase
        - The words don't have whitespaces
        
      TIME/SPACE COMPLEXITY:
        - TIME: O(n k log k)    
            - Summation of O(n) for the iteration and O(k log k) for the sorting
            – since we only iterate through the string array once O(n)
            - Sorting the characters of a string is (k log k) since Arrays.sort is using a custom 
              timsort algorithm which is a combination of mergesort and insertion sort
            
        - SPACE: O(nk) 
        
        WHERE:
            n is the number of elements 
            k is the maximum length of string

    
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        
        // A hashmap containing a list of strings
        // where the key is the sorted characters of the input 
        // and the value is the list of String anagram words
        Map<String, List<String>> map = new HashMap<>();
        
        // iterate the input
        for (String current : strs){
            
            // Rearrange the characters of the current word in alphabetical order
            char[] currentCharArray = current.toCharArray();
            Arrays.sort(currentCharArray);
            String sortedString = String.valueOf(currentCharArray);
            
            // Populate the key with an empty String Array if not existing yet
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            
            // Add the current word (which is not rearranged/sorted)
            // in the map
            map.get(sortedString).add(current);
            
        }
        
        result.addAll(map.values());
            
        
        
        return result;
        
    }
}
