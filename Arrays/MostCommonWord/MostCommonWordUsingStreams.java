class MostCommonWordUsingStreams {
    
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
        
        Set<String> bannedSet = Arrays.stream(banned)
            .collect(Collectors.toSet());
        
        Map<String,Integer> count = new HashMap<>();

        Arrays.stream(paragraph.replaceAll("[^a-zA-Z0-9]+"," ").split(" "))
            .map(String::toLowerCase)
            // .peek(System.out::println)
            .filter(word -> !bannedSet.contains(word))
            .forEach(word -> count.put(word, count.getOrDefault(word,0)+1) );

        return count.entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .map(Map.Entry::getKey)
            .orElse("");
        
        
    }
}
   
