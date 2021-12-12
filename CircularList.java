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
    public void removeLast()
    {
        Item r = list;
        
        // checks for empty list or only on item in list
        if (isEmpty() || r.next == null)
            System.out.println("Error in removeLast(): list is empty");
        
        // loop to the end of the list
        while (r.next.next != null) {
            r = r.next;
        } 
        
        // remove last item
        r.next = null;
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