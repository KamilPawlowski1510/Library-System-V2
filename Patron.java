import java.util.ArrayList;


/**
 * The superclass for all patrons.
 *
 * @author Kamil Pawlowski
 * @version 2
 */
public abstract class Patron implements iMain
{
    //variables
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private ArrayList<Book> borrowed= new ArrayList<Book>(); 
    
    
    /**
     * Constructs objects of class Librarian
     */
    public Patron(String name, String email, String phoneNo, String address, ArrayList<Book> borrowed)
    {
        if(name.length() <=40)
        {
            this.name = name;
        }
        else
        {   
            this.name = name.substring(0,40);
        }
        if(email.contains("@") && email.contains("."))
        {
            this.email = email;
        }
        else
        {
            this.email = "invalid email format";
        }
        this.phoneNo = phoneNo;
        this.address = address;
        this.borrowed = borrowed;
    }

    
    
    /**
     * Gets Name
     *
     * @param      No parameters
     * @return    String name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets Email
     *
     * @param      No parameters
     * @return    String email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Gets Phone Number
     *
     * @param      No parameters
     * @return    String phone number
     */
    public String getPhoneNo()
    {
        return phoneNo;
    }
    
    /**
     * Gets Address
     *
     * @param      No parameters
     * @return    String address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Gets Borrowed Book List
     *
     * @param      No parameters
     * @return    Arraylist borrowed
     */
    public ArrayList<Book> getBorrowed()
    {
        return borrowed;
    }
    
    
    
    /**
     * Sets Name
     *
     * @param     String new name
     * @return    Nothing
     */
    public void setName(String name)
    { 
       if(name.length() <=40)
        {
            this.name = name;
        }
        else
        {   
            this.name = name.substring(0,40);
        }
    }  

    /**
     * Sets Email
     *
     * @param     String new email
     * @return    Nothing
     */
    public void setEmail(String email)
    { 
           if(email.contains("@") && email.contains("."))
        {
            this.email = email;
        }
        else
        {
            this.email = "invalid email format";
        }
    }  
    
    /**
     * Sets Phone Number
     *
     * @param     String new phone number
     * @return    Nothing
     */
    public void setPhoneNo(String phoneNo)
    { 
        this.phoneNo = phoneNo;
    } 
    
    /**
     * Sets Address
     *
     * @param     String new address
     * @return    Nothing
     */
    public void setAddress(String address)
    { 
        this.address = address;
    }
    
    /**
     * Sets Borrowed Book List
     *
     * @param     Arraylist new borrowed
     * @return    Nothing
     */
    public void setBorrowed(ArrayList<Book> borrowed)
    { 
        this.borrowed = borrowed;
    }
    
    
    
    /**
     * Add a book to the Borrowed Book List
     */
    public void addBorrowed(Book book1)
    {
        borrowed.add(book1);
    }
    
    /**
     * Remove a book from the Borrowed Book List
     */
    public void removeBorrowed(int index)
    {
        borrowed.remove(index);

    }
    
    /**
     * Return Quantity of books in list
     */
    public int numberOfBorrowed()
    {
        return borrowed.size();
    }
    
    /**
     * Make a list of all borrowed books
     */
    public String listOfBorrowed()
    {
        String allBorrowed="Patron has " +numberOfBorrowed()+" Books currently Borrowed\n";
        if(numberOfBorrowed()==1)
        {
            allBorrowed="Patron has " +numberOfBorrowed()+" Book currently Borrowed\n";
        }
        int index = 0;
        if(borrowed.isEmpty())
        {
            allBorrowed = "The patron is currently not borrowing any books";
        }
        else
        {
            for(Book b: borrowed)
            {
                allBorrowed = allBorrowed + "Index " + index + ":   "+ b + "\n";

                index++;
            }
        }
            return allBorrowed;
    }
    
    
    
    /**
     * Uses the borrowed arraylist of books to make a summed up list of all books,
     * show the discount applied and calculate the total cost for all the borrowed books
     * 
     * @param   No parameters
     * @return  String representation of the costs and procedure to calculate them
     */
    public abstract String cart();
    
    
    
    /**
     * Describes the class in a string format
     */
    public String toString()
    {
        return
             "Name: " + name 
        + " | Email: " + email 
        + " | Phone Number: " + phoneNo
        + " | Address: " + address 
        + "\n";
    }
}