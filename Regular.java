import java.util.ArrayList;


/**
 * Extension of Patron. Used to represent regular customers and their borrowed books.
 *
 * @author Kamil Pawlowski
 * @version 1
 */
public class Regular extends Patron
{
    //variables
    private String ID;
    private boolean student;
    
    
    /**
     * Constructs objects of class Regular
     */
    public Regular(String name, String email, String phoneNo, String address, ArrayList<Book> borrowed, String ID, boolean student)
    {
        super(name, email, phoneNo, address, borrowed);
        this.ID = ID;
        this.student = student;
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
     * Gets Student
     *
     * @param      No parameters
     * @return    boolean student
     */
    public boolean getStudent()
    {
        return student;
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
     * Sets Student
     *
     * @param     boolean new student
     * @return    Nothing
     */
    public void setStudent(boolean student)
    { 
        this.student = student;
    } 

    
    
    /**
     * Transalates the student boolean into english
     * 
     * @param      No parameters
     * @return     String describing the availablility in words
     */
    public String studentStatus()
    {
        if (student == false)
        {
            return "No";
        }
        else
        {
            return "Yes";
        }
    }
    
    
    
    /**
     * Uses the borrowed arraylist of books to make a summed up list of all books, 
     * show the discount applied and calculate the total cost for all the borrowed books
     * 
     * @param   No parameters
     * @return  String representation of the costs and procedure to calculate them
     */
    public String cart()
    {
        if(numberOfBorrowed()==0)
        {
            return "The cart is empty";
        }
        else
        {
            String list = "";
            Double totalCost = 0.0;
            int index = 0;
            Double discount = 1.0;
        
            for(Book b: getBorrowed())
            {
                list = list + "Index " + index + ":   "+ b.type() +" | ID: " + b.getID() + " | Title: " + b.getTitle() + " | Cost: €" + b.getCost() +"\n";
                index++;
                totalCost = totalCost + b.getCost();
            }
            list = list + "Total Cost: €" + EasyScanner.roundToTwo(totalCost) + "\n";
            if (getStudent())
            {
                discount = 0.75;
                list = list + "Student Discount: 25%" + "\n";
            }
            else
            {
                list = list + "No Applicable Discount" + "\n";
            }
            list = list + "Final Cost: €" + EasyScanner.roundToTwo(totalCost*discount) + "\n";
            
            return list;
        }
    }
        
    
    
    /**
     * Returns what class something is as a string
     */
    public String type()
    {
        return "Regular";
    }
    
    
    
    /**
     * Describes the class in a string format
     */
    public String toString()
    {
        return
              type()
        + " | Name: " + getName()
        + " | Email: " + getEmail()
        + " | Phone Number: " + getPhoneNo()
        + " | Address: " + getAddress()
        + " | ID: " + ID 
        + " | Student: " + studentStatus() 
        + "\n";
    }
}