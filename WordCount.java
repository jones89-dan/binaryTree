public class WordCount implements Comparable<WordCount>
{
    protected String word;
    protected int count;
    protected CircularList lineNums = new CircularList ();

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
    }
    
    public void addLine(int line)
    {
        lineNums.append(line);
        //System.out.println("Added line: " + lineNums.toString());
    }
    
    public void increaseCount()
    {
        count += 1;
    }
    
    public String getWord()
    {
        return this.word;
    }
    
    public String toString()
    {
        String output = "check: " + this.word + " " + count;
        return  output;    
    }
}
