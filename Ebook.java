/**
 * Extension of Book. Used to represent electronic books.
 *
 * @author Kamil Pawlowski
 * @version 1
 */
public class Ebook extends Book
{
    //variables
    private int pageCount;
    private Double fileSize;
    
    
    /**
     * Constructs objects of class Ebook
     */
    public Ebook(String ID, String title, String author, String genre, Double cost, boolean avail, int pageCount, Double fileSize)
    {
        super(ID, title, author, genre, cost, avail);
        this.pageCount = pageCount;
        this.fileSize = EasyScanner.roundToTwo(fileSize);
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
     * Gets File Size
     *
     * @param      No parameters
     * @return    double file size
     */
    public Double getFileSize()
    { 
        return fileSize;
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
     * Sets File Size
     *
     * @param     double new file size
     * @return    Nothing
     */
    public void setFileSize(Double fileSize)
    { 
        this.fileSize = EasyScanner.roundToTwo(fileSize);
    }
    
    
    
    /**
     * Returns what class something is as a string
     */
    public String type()
    {
        return "Ebook";
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
        + " | File Size: " + fileSize +"MB"
        + "\n";
    }
}