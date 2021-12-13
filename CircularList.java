public class CircularList
{
    private Item list;

    public CircularList()
    {
        list = null;
    }

    public Boolean isEmpty()
    {
        return list == null;
    }

    public void append(int x)
    {
        Item r = new Item(x);
        if (isEmpty()) {
            r.next = r;
        }
        else {
            r.next = list.next;
            list.next = r;
        }
        list = r;
    }

    //write a new method here that returns the info of the last item in the list
    //Javadoc comment required
    
    /**
    * Gets the last Item from the end of the list. 
    * 
    * @return last.info - The last line number added to the list.
    */
    public int getLast()
    {
        Item r = list;
        
        // checks for empty list or only on item in list
        if (isEmpty() || r.next == null)
            System.out.println("Error in removeLast(): list is empty");
        
        // loop to the end of the list
        while (r.next.next != null) {
            r = r.next;
        } 
        
        // gets the last item
        Item last = r.next;
        return last.info;
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder("");

        if (!isEmpty()) {
            Item r = list.next;
            while (r != list) {
                s.append(r.info + ", ");
                r = r.next;
            }
            //append last item
            s.append(r.info);
        }
        return s.toString();
    }
}