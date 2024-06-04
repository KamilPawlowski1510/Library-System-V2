/**
 * Extension of Book. Used to represent audio books.
 *
 * @author Kamil Pawlowski
 * @version 1
 */
public class Audio extends Book
{
    //variables
    private int length;
    private Double fileSize;
    private String narrator;
    
    
    /**
     * Constructs objects of class Audio
     */
    public Audio(String ID, String title, String author, String genre, Double cost, boolean avail, int length, Double fileSize, String narrator)
    {
        super(ID, title, author, genre, cost, avail);
        this.length = length;
        this.fileSize = EasyScanner.roundToTwo(fileSize);
        this.narrator = narrator;
    }

    
    
    /**
     * Gets Length
     *
     * @param      No parameters
     * @return    int length
     */
    public int getLength()
    { 
        return length;
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
     * Gets Narrator
     *
     * @param      No parameters
     * @return    String narrator
     */
    public String getNarrator()
    { 
        return narrator;
    }
    
    
    
    /**
     * Sets Length
     *
     * @param     int new length
     * @return    Nothing
     */
    public void setLength(int length)
    { 
        this.length = length;
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
     * Sets Narrator
     *
     * @param     String new Narrator
     * @return    Nothing
     */
    public void setNarrator(String narrator)
    { 
        this.narrator = narrator;
    }
    
    
    
    /**
     * Returns what class something is as a string
     */
    public String type()
    {
        return "Audio";
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
        + " | Length: " + length +" Hours"
        + " | File Size: " + fileSize +"MB"
        + " | Narrator: " + narrator
        + "\n";
    }
}