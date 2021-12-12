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
    public WordCount () 
    {
        word = null;
    }
    
    public WordCount (String word)
    {
        this.word = word;
        count = 0;
        lineNum = 0;
    }
    
    public void addLine(int line)
    {
        if (lastLine != line)
        {
            lineNums.append(line);
            lastLine = line;
        }
    }
    
    public void increaseCount()
    {
        this.count += 1;
    }
    
    public String getLineNums()
    {
        return lineNums.toString();
    }
    
    public String getWord()
    {
        return this.word;
    }
    
    public void checkList()
    {       
        lineNums.removeLast();
    }
    
    public boolean emptyList()
    {
        return lineNums.isEmpty();
    }
    
    public String toString()
    {
        String output = "Word: " + this.word + ", Count: " + count + ", Lines: " + lineNums.toString();
        return  output; 
    }
}
