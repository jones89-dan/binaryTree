import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester
{
    public static final int WordsPerLine = 10;

    public static void main() throws FileNotFoundException
    {
        //build then output hash table
        HashTable ht = new HashTable();
        System.out.println(ht.toString());

        String word; //read from input file
        WordCount wordToFind;  //search for this in the bst
        WordCount wordInTree;  //found in the bst
        WordCount countLine = new WordCount();
        //create generic BST, of WordCount here
        BSTree<WordCount> t = new BSTree<WordCount>();
        WordCount check = new WordCount();

        //want to read word at a time from input file
        Scanner wordsIn = new Scanner(new File("Hamlet.txt"));
        wordsIn.useDelimiter("[^A-Za-z']+");

        int wordCount = 0;
        int lineNum = 1;
        System.out.printf("%3d:  ", lineNum);
        while (wordsIn.hasNext()) {
            word = wordsIn.next();
            ++wordCount;
            System.out.print(word + " ");
            word = word.toLowerCase();
            
            // now process word and lineNum here
            // create new WordCount object
            wordInTree = new WordCount(word);
            
            // add first line to CircularList
            wordInTree.addLine(lineNum);
            
            // add word to the BST if word is not in the hast table
            if(ht.find(word) != true) {
                // if word is not in the tree add word and update count
                if (t.find(wordInTree) == null ) {
                    t.insertBST(wordInTree);
                    wordInTree.increaseCount();
                }
                // if word is in the BST find and updated the existing object count & line number
                else {
                    check = t.find(wordInTree);
                    check.increaseCount();
                    check.addLine(lineNum);
                }
            }
            
            // checks words per line and creates new line when limit is reached
            if (wordCount % WordsPerLine == 0) {
                ++lineNum;
                System.out.printf("\n%3d:  ", lineNum);
            }
        }
        //EOF
        
        // output for BST and header/padding
        System.out.println();
        System.out.println("********************************");
        System.out.println("Word     Count      Line numbers");
        System.out.println("********************************");
        // print bst in alpha order
        System.out.println(t.toString());
    }
}