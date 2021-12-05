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

        //create generic BST, of WordCount here
        BSTree<WordCount> t = new BSTree<WordCount>();

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

            //now process word and lineNum here



            if (wordCount % WordsPerLine == 0) {
                ++lineNum;
                System.out.printf("\n%3d:  ", lineNum);
                // add LineNum to circular array
                countLine.addLine(lineNum);
            }
        }
        //EOF
        System.out.println();

        //print bst in alpha order
        System.out.println(t.toString());
    }
}
