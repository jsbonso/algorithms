
/*
    GroupedAnagrams
    
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
    typically using all the original letters exactly once.

 

    Example 1:

        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
    Example 2:

        Input: strs = [""]
        Output: [[""]]

    Example 3:

        Input: strs = ["a"]
        Output: [["a"]]
 

    Constraints:

        1 <= strs.length <= 104
        0 <= strs[i].length <= 100
        strs[i] consists of lowercase English letters.
        
*/

import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GroupedAnagrams
{
    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        //List<List<String>> test1 =  groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        
        List<List<String>> test1 = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(test1 + "\tNumber of Groups: " + test1.size()); // has 2 groups of anagrams out of 3 groups.
        
         List<List<String>> test2 = groupAnagrams(new String[]{"jon","bonso"});
        System.out.println(test2 + "\tNumber of Groups: " + test2.size()); 
        
         List<List<String>> test3 = groupAnagrams(new String[]{"kaliwa","wakali"});
        System.out.println(test3 + "\tNumber of Groups: " + test3.size()); 
        
        
         List<List<String>> test4 = groupAnagrams(new String[]{"sakalam","malakas", "petmalu","malupet", "noypi", "pinoy", "manila" });
        System.out.println(test4 + "\tNumber of Groups: " + test4.size()); 
        
        
    }
    
    public static List<List<String>> groupAnagrams(String[] input){
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String current : input){
            
            // sort the letters of the word in alphabetical order
            char[] currentCharArray = current.toCharArray();
            Arrays.sort(currentCharArray);
            String sortedString = new String(currentCharArray);
            
            // Populate the key
            if (!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            
            map.get(sortedString).add(current);
            
        }
        
        result.addAll(map.values());
        
        return result;
        
    }
}
