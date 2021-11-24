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

            //put word into hash table, handling collisions

            
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

        //this hard-coded return value is here to allow this method stub to compile
        return false;        
    }

    public String toString()
    {
        //traverses the hash table to output each word, preceded by a word count 

        //this hard-coded return value is here to allow this method stub to compile
        return "";
    }
}
