/**
 * The superclass for all books. 
 *
 * @author Kamil Pawlowski
 * @version 2
 */
public abstract class Book implements iMain
{
    //variables
    private String ID;
    private String title;
    private String author;
    private String genre;
    private Double cost;
    private boolean avail;
    
    
    /**
     * Constructs objects of class Book
     */
    public Book(String ID, String title, String author, String genre, Double cost, boolean avail)
    {
        this.ID = ID;
        this.title = title;
        this.author = author;
        if(genre.length() <=40)
        {
            this.genre = genre;
        }
        else
        {   
            this.genre = genre.substring(0,40);
        }
        this.cost = EasyScanner.roundToTwo(cost);
        this.avail = avail;
    }

    
    
    /**
     * Gets ID
     *
     * @param      No parameters
     * @return    String ID
     */
    public String getID()
    { 
        return ID;
    }
    
    /**
     * Gets Title
     *
     * @param      No parameters
     * @return    String Title
     */
    public String getTitle()
    { 
        return title;
    }

    /**
     * Gets Author
     *
     * @param      No parameters
     * @return    String Author
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Gets Genre
     *
     * @param      No parameters
     * @return    String Genre
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Gets Cost
     *
     * @param      No parameters
     * @return    Double Cost
     */
    public Double getCost()
    {
        return cost;
    }
    
    /**
     * Gets Availability
     *
     * @param      No parameters
     * @return    boolean Availability
     */
    public boolean getAvail()
    {
        return avail;
    }
    
    
    
    /**
     * Sets ID
     *
     * @param     String new ID
     * @return    Nothing
     */
    public void setID(String ID)
    { 
        this.ID = ID;
    }
    
    /**
     * Sets Title
     *
     * @param     String new title
     * @return    Nothing
     */
    public void setTitle(String title)
    { 
        this.title = title;
    }

    /**
     * Sets Author
     *
     * @param     String new author
     * @return    Nothing
     */
    public void setAuthor(String author)
    { 
        this.author = author;
    }  

    /**
     * Sets Genre
     *
     * @param     String new genre
     * @return    Nothing
     */
    public void setGenre(String genre)
    { 
        if(genre.length() <=40)
        {
            this.genre = genre;
        }
        else
        {   
            this.genre = genre.substring(0,40);
        }
    }

    /**
     * Sets Cost
     *
     * @param     double new cost
     * @return    Nothing
     */
    public void setCost(Double cost)
    { 
            this.cost = EasyScanner.roundToTwo(cost);
    }  
    
    /**
     * Sets Availability
     *
     * @param     boolean new availability
     * @return    Nothing
     */
    public void setAvail(boolean avail)
    { 
        this.avail = avail;
    }  
    
    
    
    /**
     * Transalates the availability into english
     *
     * @param      No parameters
     * @return     String describing the availablility in words
     */
    public String status()
    {
        if (avail == false)
        {
            return "Unavailable";
        }
        else
        {
            return "Available";
        }
    }
    
    
    
    /**
     * Describes the class in a string format
     */
    public String toString()
    {
        return 
            " ID: " + ID
        + " | Title: " + title
        + " | Author: " + author
        + " | Genre: " + genre 
        + " | Cost: €" + cost 
        + " | Availability: " + status() 
        + "\n";
    }
}