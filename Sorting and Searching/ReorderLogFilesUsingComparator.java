class ReorderLogFilesUsingComparator {
    
    /*
    * Return an ordered String array of log files based on the information below:
    
      Example 1: 
        Input: 
            logs = ["dig1 8 1 5 1",
                    "let1 art can",
                    "dig2 3 6",
                    "let2 own kit dig",
                    "let3 art zero"]
        Output:    ["let1 art can",
                    "let3 art zero",
                    "let2 own kit dig",
                    "dig1 8 1 5 1",
                    "dig2 3 6"]
        
           Example 2: 
           
        Input: 
            logs = ["a1 9 2 3 1",
                    "g1 act car",
                    "zo4 4 7",
                    "ab1 off key dog",
                    "a8 act zoo"]
        Output:    ["g1 act car",
                    "a8 act zoo",
                    "ab1 off key dog",
                    "a1 9 2 3 1",
                    "zo4 4 7"]
        
     2 Types of Logs:
        1. Letter Logs - order based on their content 
        2. Digit Logs  - maintain order of ordering
      
      LOG FORMAT/ SYNTAX:
        
            <identifier> n1 n2 n3 n...
            
            if "n" is letter, then the log is a Letter log. Else, it is a digit log.
            
     APPROACH
        - Create a Comparator and sort the input
        - The comparator has the following implementation:
            - The two inputs would be split in to two parts: 
                1. identifier
                2. content
                
                Example: 
                    "let2 own kit dig" -> "let2", "own kit dig"
                    "dig1 8 1 5 1"     -> "dig1", "8 1 5 1"
      
    */
    public String[] reorderLogFiles(String[] logs) {
        
        /**
        * 
            INSIGHTS:
                - letter logs are always LESS than the Digit Logs
                - "LESS" in this case, means it should go on the left-hand side of the array, 
                  where the letter logs are meant to be placed.
                

            
            This Comparator returns:
             0  = if the two inputs are the same
            -1  = if the first input is less  than the second input 
                = (goes to the LEFT of the array)
             1  = if the first input is greater than the former
                = (goes to the RIGHT of the array) 

             If the input is:
                 (letter-log, digit-log) = -1
                 (digit-log, letter-log) =  1
            
        */
        Comparator<String> logComparator = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                
                int firstInputIsSmaller = -1;
                int firstInputIsBigger = 1;
                int bothInputsAreEqual = 0;
                
                // split each log into two parts: <identifier, content>
                String[] logSplit1 = log1.split(" ", 2);
                String[] logSplit2 = log2.split(" ", 2);
                
                String log1identifier = logSplit1[0];
                String log1Content    = logSplit1[1];
                
                String log2identifier = logSplit2[0];
                String log2Content    = logSplit2[1];

                boolean isLetterLog1 = Character.isLetter(log1Content.charAt(0));
                boolean isLetterLog2 = Character.isLetter(log2Content.charAt(0));

                // This first if block has two outcomes:
                
                //      - If both inputs are letter-logs, compare the content
                //      - if the inputs are the same, compare the identifiers
                
                if (isLetterLog1 && isLetterLog2) {

                    System.out.println("Both input are Letter Logs");
                    
                    // Compare the content of the two Input. 
                    
                    // The compareTo function also returns:
                    //      0 : if the two inputs are equal    (bothInputsAreEqual)
                    //     -1 : if the first input is smaller
                    //      1 : if the first input is bigger
                    
                    int compareContentResult = log1Content.compareTo(log2Content);
                    
                    // if the logs have the same content, compare the identifiers
                    if (compareContentResult == bothInputsAreEqual){
                        return log1identifier.compareTo(log2identifier);
                    }
                    
                    return compareContentResult;
                }

                // The first input is a digit log but the second is a letter log
                // The letter log always comes first so the
                // first input is considered bigger than the second input
                else if (!isLetterLog1 && isLetterLog2){

                    System.out.println("The first input is a Digit Log");
                    return firstInputIsBigger;
                }
                
                // The second input is a digit log but the first one is a letter log
                // The letter log always comes first, or considered smaller than the latter input.         
                else if (isLetterLog1 && !isLetterLog2){

                    System.out.println("The first input is a Letter Log");
                    return firstInputIsSmaller;
                }
                
                // Both logs are digit logs, so no ordering needed. 
                else{ 

                    System.out.println("Both input are the same");
                    return bothInputsAreEqual;
                }
            }
        };

        // Sort the input
        Arrays.sort(logs, logComparator);
        return logs;
        
    }
    
   
}
