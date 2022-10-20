class MostCommonWordUsingHashSetAndHashMap {
    
    /**
    Returns the most unbanned common word from the paragraph
    
    Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
    Output: "ball"
    
    APPROACH:
    
        - Convert the paragraph into a String array, delimited by a space (" ")
        - Create a sorted treemap with the key as the word and the number of occurence as the value
        - Iterate the words in the String array
            - If the word is part of the unbanned word, skip it.
            - Add the word in the map and increment the count whenever it occured again
        - 
    
    CONSTRAINTS: 
    
        1 <= paragraph.length <= 1000
        paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
        0 <= banned.length <= 100
        1 <= banned[i].length <= 10
        banned[i] consists of only lowercase English letters.

    */
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // Remove the special characters from the paragraph
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = normalizedStr.split("\\s+");
        
        // Populate the banned words
        Set<String> bannedWords = new HashSet<>();
        for (String bannedWord: banned){
            bannedWords.add(bannedWord);
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word: words){
            // Skip banned words and populate valid words
            if (!bannedWords.contains(word)){
                
                // Increment the count
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        // Return the word with the highest number occurence
        return Collections.max( wordCount.entrySet(), Map.Entry.comparingByValue() ).getKey();
        
        
    }
}
