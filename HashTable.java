import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTable
{
    public static final int MAX = 30;

    private String hashTable[];

    public HashTable() throws FileNotFoundException
    {
        hashTable = new String[MAX];

        //be certain array contains all nulls
        for (int i = 0; i < MAX; ++i)
            hashTable[i] = null;

        //read file of common words
        int collisions = 0;
        Scanner commonWords = new Scanner(new File("Common_words.txt"));
        while (commonWords.hasNext()) {
            String word = commonWords.nextLine();
            int key = hash(word);
            //put word into hash table, handling collisions
            
            // check to see if index is empty for the key using linear probing 
            if (hashTable[key] == null) {
                // add the word if index is available
                hashTable[key] = word;
            }
            else {
                // if index not available increase collision count
                collisions += 1;
                
                // check for end of array or next available index
                if(key + 1 != MAX +1 || hashTable[key +1] != null) {
                    // increase key and add the word
                    key++;
                    hashTable[key] = word;
                }
                // If end of the array is reached wrap to the front
                else if (key + 1 == MAX +1 ) {
                    // front index
                    key = 0;
                    // if front index is taken, incrase the key, then insert word
                    if (hashTable[key] != null) {
                        key ++;
                    }   
                    hashTable[key] = word;
                }
            }
        }
        System.out.println
        ("Number of collisions building the table: " + collisions);        
    }

    public int hash(String word)
    {
        char ch;
        double total;

        total = 0.0;
        for (int i = 0; i < word.length(); ++i) {
            ch = word.charAt(i);
            total += (double) ch;
            total *= Math.PI;
        }
        double decimal = total - (int) total;
        int hash = (int) (MAX * decimal);
        return hash;
    }
    
    /**
    * Finds a String in the HastTable. 
    * 
    * @param word - String to search for.
    * @return exists - Boolean value true of false if word exists.
    */
    public Boolean find(String word)
    {
        // use hashing here for fast search, implement linear probing to handle collisions 
        
        // hashed key for the word and initialize Boolean
        int key = hash(word);
        Boolean exists = true;
        
        // check if key is not present and update the boolean value
        if (hashTable[key] == null) {
            exists = false;
        }
        
        // returns true or false if word found in Hash Table
        return exists;        
    }
    
    /**
    * Formats the Hash Table for ouput uisng StringBuilder.
    * 
    * @return s.toString - formated StringBuilder object. 
    */
    public String toString()
    {
        //traverses the hash table to output each word, preceded by a word count 
        StringBuilder s = new StringBuilder("");
        
        for (int i = 0; i < MAX; ++i)
             s.append(i + " " + hashTable[i] + "\n");
        
        return s.toString();
    }
}