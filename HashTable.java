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
            //hashTable[key] = word;
            
            if (hashTable[key] == null) {
                hashTable[key] = word;
            }
            else {
                collisions += 1;
                
                if(key + 1 != MAX +1 || hashTable[key +1] != null) {
                    key++;
                }
                else if (key + 1 == MAX +1)
                {
                    key = 0;
                }
                
                hashTable[key] = word;
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

    public Boolean find(String word)
    {
        //use hashing here for fast search, implement linear probing to handle collisions 
        int key = hash(word);
        Boolean exists = true;
        
        if (hashTable[key] == null) {
            exists = false;
        }
        //this hard-coded return value is here to allow this method stub to compile
        return exists;        
    }

    public String toString()
    {
        //traverses the hash table to output each word, preceded by a word count 
        StringBuilder s = new StringBuilder("");
        //tring words; 
        for (int i = 0; i < MAX; ++i)
             s.append(i + " " + hashTable[i] + "\n");
        //this hard-coded return value is here to allow this method stub to compile
        return s.toString();
    }
}
