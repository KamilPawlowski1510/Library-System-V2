/**
 * Extension of Book. Used to represent paper books.
 *
 * @author Kamil Pawlowski
 * @version 1
 */
public class Print extends Book
{
    //variables
    private int pageCount;
    
    
    /**
     * Constructs objects of class Print
     */
    public Print(String ID, String title, String author, String genre, Double cost, boolean avail, int pageCount)
    {
        super(ID, title, author, genre, cost, avail);
        this.pageCount = pageCount;
    }

    
    
    /**
     * Gets Page Count
     *
     * @param      No parameters
     * @return    int page count
     */
    public int getPageCount()
    { 
        return pageCount;
    }
    
    
    
    /**
     * Sets Page Count
     *
     * @param     int new page count
     * @return    Nothing
     */
    public void setPageCount(int pageCount)
    { 
        this.pageCount = pageCount;
    }
    
    
    
    /**
     * Returns what class something is as a string
     */
    public String type()
    {
        return "Print";
    }

    
    
    /**
     * Describes the class in a string format
     */
    public String toString()
    {
        return 
              type()
        + " | ID: " + getID()
        + " | Title: " + getTitle()
        + " | Author: " + getAuthor()
        + " | Genre: " + getGenre()
        + " | Cost: €" + getCost()
        + " | Availability: " + status()
        + " | Page Count: " + pageCount
        + "\n";
    }
}