import java.util.ArrayList;


/**
 * Extension of Patron. Used to represent librarians and their borrowed books.
 *
 * @author Kamil Pawlowski
 * @version 1
 */
public class Librarian extends Patron
{
    //variables
    private Double salary;
    
    
    /**
     * Constructs objects of class Librarian
     */
    public Librarian(String name, String email, String phoneNo, String address, ArrayList<Book> borrowed, Double salary)
    {
        super(name, email, phoneNo, address, borrowed);
        this.salary = EasyScanner.roundToTwo(salary);
    }

    /**
     * Gets Salary
     *
     * @param      No parameters
     * @return    double salary
     */
    public Double getSalary()
    { 
        return salary;
    }
    
    /**
     * Sets Salary
     *
     * @param     double new salary
     * @return    Nothing
     */
    public void setSalary(Double salary)
    { 
        this.salary = EasyScanner.roundToTwo(salary);
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
            Double discount = 0.5;
        
            for(Book b: getBorrowed())
            {
                list = list + "Index " + index + ":   "+ b.type() +" | ID: " + b.getID() + " | Title: " + b.getTitle() + " | Cost: €" + b.getCost() +"\n";
                index++;
                totalCost = totalCost + b.getCost();
            }
            list = list + "Total Cost: €" + EasyScanner.roundToTwo(totalCost) + "\n" + "Staff Discount: 50%" + "\n" + "Final Cost: €" + EasyScanner.roundToTwo(totalCost*discount) + "\n";
            return list;
        }
    }
      
    
    
    /**
     * Returns what class something is as a string
     */
    public String type()
    {
        return "Librarian";
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
        + " | Salary: €" + salary + "/hr"
        + "\n";
    }
}

