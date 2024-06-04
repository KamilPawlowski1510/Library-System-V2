import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.thoughtworks.xstream.security.AnyTypePermission;


/**
 * Used as a collection class for both patrons and books
 *
 * @author Kamil Pawlowski
 * @version 2
 */
public class Library
{
    //Declare and build an ArrayList of type Patron and Book
    private ArrayList<Patron> patronList= new ArrayList<Patron>();     
    private ArrayList<Book> bookList= new ArrayList<Book>();  

    
    /**
     * Constructs objects of class Library
     */
    public Library()
    {

    }

    
    
    /**
     * Adds a new Patron to the Patron List
     */
    public void addPatron(Patron patron1)
    {
        patronList.add(patron1);
    }

    /**
     * Adds a new Book to the Book List
     */
    public void addBook(Book book1)
    {
        bookList.add(book1);
    }

    
    
    /**
     * Removes a Patron from the Patron List
     */
    public void removePatron(int index)
    {
        patronList.remove(index);
    }

    /**
     * Removes a Book from the Book List
     */
    public void removeBook(int index)
    {
        bookList.remove(index);
    }

    
    
    /**
     * Returns how many Patrons there are in the Patron List
     */
    public int numberOfPatrons()
    {
        return patronList.size();
    }
    
    /**
     * Returns how many Books there are in the Book List
     */
    public int numberOfBooks()
    {
        return bookList.size();
    }
    
    
    
    /**
     * Returns how many Patrons there are of a particular subclass in the Patron List
     */
    public int numberOfPatronType(String type)
    {
        int no = 0;
        for(Patron p: patronList)
        {   
            if (p.type().equals(type))
            {
                no++;
            }
        }
        return no;
    }
    
    /**
     * Returns how many Books there are of a particular subclass in the Book List
     */
    public int numberOfBookType(String type)
    {
        int no = 0;
        for(Book b: bookList)
        {   
            if (b.type().equals(type))
            {
                no++;
            }
        }
        return no;
    }
    
    
    
    /**
     * Creates a String that represents all the Patrons in Patron List or a 
     * particular subclass depending on choice
     */
    public String listOfPatrons(int choice)
    {
        String allPatrons="";
        int index = 0;
        
        switch (choice)
        {
            case 1: 
                for(Patron p: patronList)
                {
                    allPatrons = allPatrons + "Index " + index + ":   "+ p + "\n";
                    index++;
                }
                break;
            case 2:
                for(Patron p: patronList)
                {
                    if (p.type().equals("Librarian"))
                    {
                        allPatrons = allPatrons + "Index " + index + ":   "+ p + "\n";
                    }
                    index++;
                }
                break;
            case 3:
                for(Patron p: patronList)
                {
                    if (p.type().equals("Regular"))
                    {
                        allPatrons = allPatrons + "Index " + index + ":   "+ p + "\n";
                    }
                    index++;
                }
                break;
            default:
                System.out.println("Invalid option selected");
        }
        return allPatrons;
    }

    /**
     * Creates a String that represents all the Books in Book List or a 
     * particular subclass depending on choice
     */
    public String listOfBooks(int choice)
    {
        String allBooks="";
        int index = 0;
                
        switch (choice)
        {
            case 1: 
                for(Book b: bookList)
                {
                    allBooks = allBooks + "Index " + index + ":   "+ b + "\n";
                    index++;
                }
                break;
            case 2:
                for(Book b: bookList)
                {
                    if (b.type().equals("Print"))
                    {
                        allBooks = allBooks + "Index " + index + ":   "+ b + "\n";
                    }
                    index++;
                }
                break;
            case 3:
                for(Book b: bookList)
                {
                    if (b.type().equals("Ebook"))
                    {
                        allBooks = allBooks + "Index " + index + ":   "+ b + "\n";
                    }
                    index++;
                }
                break;
            case 4:
                for(Book b: bookList)
                {
                    if (b.type().equals("Audio"))
                    {
                        allBooks = allBooks + "Index " + index + ":   "+ b + "\n";
                    }
                    index++;
                }
                break;

            default:
                System.out.println("Invalid option selected");
        }
        return allBooks;
    }
    
    
    
    /**
     * Takes in a String input and searches the Patron List for Patrons 
     * with the same Name and returns this as a String
     */
        public String searchPatronByName(String nameIn)
        {
        String searchResults="";
        for(Patron p: patronList)
        {
            if(p.getName().equals(nameIn))
            {
                searchResults = searchResults + p.toString() + "\n";
            }
        }
        return searchResults;
    }

    /**
     * Takes in a String input and searches the Book List for Books with
     * the same Title and returns this as a String
     */
    public String searchBookByTitle(String nameIn)
    {
        String searchResults="";
        for(Book b: bookList)
        {
            if(b.getTitle().equals(nameIn))
            {
                searchResults = searchResults + b + "\n";
            }
        }
        return searchResults;
    }
    
    
    
    /**
     * Gets Patron
     *
     * @param      int index
     * @return    Patron patron
     */
    public Patron getPatron(int index)
    {
        return patronList.get(index);
    }

    /**
     * Gets Book
     *
     * @param      int index
     * @return    Book book
     */
    public Book getBook(int index)
    {
        return bookList.get(index);
    }
    
    
    
    /**
     * Makes a list of every Book in the Book List that is Available
     */
    public String listAvailableBooks()
    {
        String allBooks="";
        int index = 0;
        if(bookList.isEmpty())
        {
            allBooks = "There are no Books in the System!";
        }
        else
        {
            for(Book b: bookList)
            {
                if(b.getAvail() == true)
                {
                allBooks = allBooks + "Index " + index + ":   "+ b + "\n";
                }
                
                index++;
            }
        }
        return allBooks;
    }
    
    
    
    /**
     * Checks whether or not a book ID is valid. This is done by comparing
     * its ID with every Book ID in the Book List and seeing if it already
     * occured somewhere
     */
    public boolean validifyBookID(String IDIn)
    {
        boolean searchResults=true;
        for(Book b: bookList)
        {
            if(b.getID().equals(IDIn))
            {
                searchResults = false;
            }
        }
        return searchResults;
    }
    
    
    
    /**
     * Returns a book. Takes the inserted ID and compares it with the ID's of
     * all Books in Book List. When it finds one that has the same ID it changes
     * its avail to true.
     */
    public void returnBook(String IDIn)
    {
        for(Book b: bookList)
        {
            if(b.getID().equals(IDIn))
            {
                b.setAvail(true);
            }
        }
    }
    
    
    
    /**
     * Counts how many Available Books there are in the Book List
     */
    public int numberOfAvailBooks()
    {
        int count =0;
        for(Book b: bookList)
        {
            if(b.getAvail()==true)
            {
                count++;
            }
        }
        return count;
    }
    

    
    /**
     * Loads the patrons.xml file
     */
        @SuppressWarnings("unchecked")
    public void loadPatron() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("patrons.xml"));
        patronList = (ArrayList<Patron>) is.readObject();
        is.close();
    }
    
    /**
     * Loads the books.xml file
     */
        @SuppressWarnings("unchecked")
    public void loadBook() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("books.xml"));
        bookList = (ArrayList<Book>) is.readObject();
        is.close();
    }
    
    
    
    /**
     * Saves the data onto the patrons.xml file
     */
    public void savePatron() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("patrons.xml"));
        out.writeObject(patronList);
        out.close(); 
    }
    
    /**
     * Saves the data onto the books.xml file
     */
    public void saveBook() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("books.xml"));
        out.writeObject(bookList);
        out.close();    
    }
}