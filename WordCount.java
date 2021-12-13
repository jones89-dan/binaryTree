public class WordCount implements Comparable<WordCount>
{
    protected String word;
    protected int count;
    protected CircularList lineNums = new CircularList ();
    protected int lineNum;
    int lastLine = 0;
    //required for class to compile
    public int compareTo(WordCount other)
    {
        return word.compareTo(other.word);
    }

    //write your WordCount methods here. Javadoc comments required
    
    /**
    * Contstructor for a WordCount object. 
    * 
    */
    public WordCount () 
    {
        word = null;
    }
    
    /**
    * Overloaded contstructor for a complex WordCount object.
    * 
    * @param word - word for the WordCount object.
    */
    public WordCount (String word)
    {
        this.word = word;
        count = 0;
        lineNum = 0;
    }
    
    /**
    * Adds line to the Circular List and filters out duplicate line entries.
    * 
    * @param line - line to append to the Circular List.
    */
    public void addLine(int line)
    {
        // check for duplicate line before adding
        if (lastLine != line)
        {
            lineNums.append(line);
            lastLine = line;
        }
    }
    
    /**
    * Increases the count of the WordCount object.
    * 
    */
    public void increaseCount()
    {
        this.count += 1;
    }
    
    /**
    * Formats the WordCount object for string output. 
    * 
    * @return output - WordCount object formated to string.
    */
    public String toString()
    {
        String output = "Word: " + this.word + ", Count: " + count + ", Lines: " + lineNums.toString();
        return  output; 
    }
}