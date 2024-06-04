import java.util.ArrayList;

//This is used to make delays in the code where necessary
import java.util.concurrent.TimeUnit;


/**
 * Contians the main method, this is the front end user interference
 *
 * @author Kamil Pawlowski
 * @version 2
 */
public class LibrarySystem
{
    //Create an object libraryWF from the Library Class
    private Library libraryWF = new Library();  
    
    
    /**
     * Constructs objects of class Library System
     */
    public LibrarySystem()
    {
    }
    
    
    
    /**
     * Creates and runs the Library System
     */
    public static void main(String[] args)
    {
        LibrarySystem ls1 = new LibrarySystem();
        ls1.run();
    }

    
    
    /**
     * Displays the menu for the application,reads the menu option that the user
     * entered and returns it.
     *
     * @return     the users menu choice
     */
    public int mainMenu()
    {

        System.out.println("Library Menu\n");
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" \nPlease enter choice [0-2]: ");

        System.out.println("1. Patron Menu");
        System.out.println("2. Book Menu");
        System.out.println("0. Quit");
        

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.print('\u000C');
        return choice;
    }

    
    
    /**
     * Displays the menu and processes the user's menu choice.  Option ‘0’ exits the program.
     */

    public void run()
    {
        //load sequence, done once initially
        try{
                libraryWF.loadPatron();
                System.out.println("Loaded all Patron files succesfully");
            }
        catch (Exception e)
            { 
                System.out.println("Error reading from Patron file: " + e);
             }   
        try{
                libraryWF.loadBook();
                System.out.println("Loaded all Book files succesfully");
            }
        catch (Exception e)
            { 
                System.out.println("Error reading from Book file: " + e);
             } 
        try 
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException ie) 
            {
                Thread.currentThread().interrupt();
            }
        System.out.print('\u000C');
        
        
        int option = mainMenu();
        while(option !=0)
        {
            switch (option)
            {
                case 1: 
                    runPatron();
                    break;
                case 2:
                    runBook();
                    break;
                
                default : 
                    System.out.println("Invalid option selected");
            }
            option = mainMenu();
        }
    } 
    
    
    
    /**
     * Displays the menu for the runPatron() method. It's 
     * used to show the user their options and store their choice.
     *
     * @return     the users menu choice
     */
    public int patronMenu()
    {
        System.out.println("Library Menu > Patron Menu\n");
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" \nPlease select option [0-8]: ");

        System.out.println("1. List Patrons");
        System.out.println("2. Number of Patrons");
        System.out.println("3. List Patron details by name");
        System.out.println("4. See Patron's borrowed books");
        System.out.println("5. Update Patron details (not functional)");
        System.out.println("6. Add a Patron");
        System.out.println("7. Remove a Patron");
        System.out.println("8. Explain Patron Types");
        System.out.println("0. Go Back");
        
        // get choice
        int choice = EasyScanner.nextInt();
        System.out.print('\u000C');
        return choice;
    }
    
    
    
    /**
     * Displays the menu with the Patron options and processes 
     * the user's patronMenu choice.  Option ‘0’ goes back to main menu.
     * 
     */
    public void runPatron()
    {
        int option = patronMenu();
        while(option !=0)
        {
            switch (option)
            {
                case 1:
                    if(libraryWF.numberOfPatrons() ==0)
                    {
                        System.out.println("There are no patrons in the system!");
                    }
                    else
                    {
                        System.out.println(" \nWhich list would you like to see? [0-3]: ");
                        System.out.println("1. All Patrons");
                        System.out.println("2. Librarians");
                        System.out.println("3. Regular");
                        System.out.println("0. Go Back");
                        int choice = EasyScanner.nextInt();
                        System.out.print('\u000C');
                        if(choice == 0)
                        {
                            break;
                        }
                        System.out.println(libraryWF.listOfPatrons(choice));
                    }
                    break;
                case 2:
                    if(libraryWF.numberOfPatrons() ==1)
                    {
                        System.out.println("There is 1 patron in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfPatrons() + " patrons in the system.");
                    }
                    if(libraryWF.numberOfPatronType("Librarian") ==1)
                    {
                        System.out.println("There is 1 librarian in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfPatronType("Librarian") + " librarians in the system.");
                    }
                    if(libraryWF.numberOfPatronType("Regular") ==1)
                    {
                        System.out.println("There is 1 regular in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfPatronType("Regular") + " regulars in the system.");
                    }
                    break;
                case 3:
                    listOfPatronsByName();
                    break;
                case 4:
                    runBorrowed();
                    break;
                case 5: 
                    updatePatronDetails();
                    break;
                case 6: 
                    createPatron();
                    break;
                case 7:
                    deletePatron(); 
                    break;
                case 8:
                    System.out.println("There are two types of patron, regular and librarian.");
                    System.out.println("Both of these patrons store personal details as well as a list of books they are currently borrowing.");
                    System.out.println("A regular patron is also required to have an ID and can be set as a student where applicable to get a 25% discount.");
                    System.out.println("A librarian receives 50% discount and can track their current salary.");
                    break;
                default : 
                    System.out.println("Invalid option selected");
            }
            System.out.println();
            option = patronMenu();
        }
    } 
    
    
    
    /**
     * Displays the menu for the runBook() method. It's 
     * used to show the user their options and store their choice.
     *
     * @return     the users menu choice
     */
    public int bookMenu()
    {
        System.out.println("Library Menu > Book Menu\n");
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" \nPlease select option [0-8]: ");

        System.out.println("1. List Books");
        System.out.println("2. Number of Books");
        System.out.println("3. List Book Details by Title");
        System.out.println("4. Update Book Details (not functional)");
        System.out.println("5. Add a Book");
        System.out.println("6. Copy a Book");
        System.out.println("7. Remove a Book");
        System.out.println("8. Explain Book Types");
        System.out.println("0. Go Back");

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.print('\u000C');
        return choice;
    }
    
    
    
    /**
     * Displays the menu with the Book options and processes 
     * the user's bookMenu choice.  Option ‘0’ goes back to main menu.
     * 
     */
    public void runBook()
    {
        int option = bookMenu();
        while(option !=0)
        {
            switch (option)
            { 
                case 1:
                    if(libraryWF.numberOfBooks() ==0)
                    {
                        System.out.println("There are no books in the system!");
                    }
                    else
                    {
                        System.out.println(" \nWhich list would you like to see? [0-4]: ");
                        System.out.println("1. All Books");
                        System.out.println("2. Print Books");
                        System.out.println("3. Ebooks");
                        System.out.println("4. Audio Books");
                        System.out.println("0. Go Back");
                        int choice = EasyScanner.nextInt();
                        System.out.print('\u000C');
                        if(choice == 0)
                        {
                            break;
                        }
                        System.out.println(libraryWF.listOfBooks(choice));
                    }
                    break;
                    
                case 2:
                    if(libraryWF.numberOfBooks() ==1)
                    {
                        System.out.println("There is 1 book in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfBooks() + " books in the system.");
                    }
                    if(libraryWF.numberOfBookType("Print") ==1)
                    {
                        System.out.println("There is 1 print book in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfBookType("Print") + " print books in the system.");
                    }
                    if(libraryWF.numberOfBookType("Ebook") ==1)
                    {
                        System.out.println("There is 1 ebook in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfBookType("Ebook") + " ebooks in the system.");
                    }
                    if(libraryWF.numberOfBookType("Audio") ==1)
                    {
                        System.out.println("There is 1 audio book in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfBookType("Audio") + " audio books in the system.");
                    }
                    break;
                    
                case 3:
                    listOfBooksByTitle();
                    break;
                    
                case 4:
                    updateBookDetails();
                    break;
                    
                case 5: 
                    createBook();
                    break;
                case 6:
                    copyBook(); 
                    break;
                case 7:
                    deleteBook(); 
                    break;
                case 8:
                    System.out.println("There are three types of books, print, electronic and audio books.");
                    System.out.println("All book types store basic information such as the title or author and they also track whether they are currently borrowed and what their current cost is.");
                    System.out.println("Print books, referring to traditional printed paper books, need to also store page count.");
                    System.out.println("Electronic or E-books, digital versions of a book that can be accessed through a computer or smart device, need to store page count as well as file size in MB.");
                    System.out.println("Audio books, recorded narations of a book, need to also store their length in hours, file size in MB and the name of the narrator.");
                    break;
                
                default : 
                    System.out.println("Invalid option selected");
            }
            System.out.println();
            option = bookMenu();
        }
    } 
    
    
    
    /**
     * Displays the first menu for the runBorrowed() method. It's used to let
     * the user select the patron with validation that the choice is appropriate that
     * will be used to determine whose borrowed books are being interacted with.
     *
     * @return     the users menu choice
     */
    public int borrowedPatronMenu()
    {
        System.out.println("Library Menu > Patron Menu > Borrowed Books\n");
        
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(libraryWF.listOfPatrons(1));
        System.out.print(" \nSelect the index of the Patron whose borrowed books you wish to see: ");
        String choice = EasyScanner.nextString();
        while (!choice.matches("[0-9]+") || Integer.parseInt(choice) >= libraryWF.numberOfPatrons())
        {
            System.out.println(" Please enter a number that's within the arraylist. ");
            choice = EasyScanner.nextString();
        }
        System.out.print('\u000C');
        return Integer.parseInt(choice);
    }
    
    
    
    /**
     * Displays the second menu for the runBorrowed() method. It's used to show
     * the user which Patrons books they're interacting with as well as their options
     * for how they can interact with them.
     *
     * @return     the users menu choice
     */
    public int borrowedMenu(Patron patron)
    {
        System.out.println(patron.listOfBorrowed());
        System.out.println("Library Menu > Patron Menu > Borrowed Books > "+patron.getName()+"\n");
        
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" \nPlease Enter choice [0-3]: ");

        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("3. Cart");
        System.out.println("0. Go Back");

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.print('\u000C');
        return choice;

    }
    
    
    
    /**
     * Displays two menus, one to select which Patrons borrowed books to interact
     * with and another showing how the books can be interacted with, and processes 
     * the user's choices.  Option ‘0’ goes back to Patron menu.
     * 
     */
    public void runBorrowed()
    {
        if (libraryWF.numberOfPatrons() ==0)
        {
            System.out.print("There are no Patrons in the System!");
        }
        else
        {
            int patronI = borrowedPatronMenu();
            Patron patron = libraryWF.getPatron(patronI);
            int option = borrowedMenu(patron);
            while(option !=0)
            {
                switch (option)
                {
                    case 1:
                        borrowBook(patron);
                        break;
                    case 2:
                        returnBook(patron);
                        break;
                    case 3:
                        System.out.println(patron.cart());
                        break;
                    default : 
                        System.out.println("Invalid option selected");
                }
                option = borrowedMenu(patron);
            }
        }
    } 
    
    
    
    /**
     * Borrows a book. It takes in a patron, checks for available books
     * and if there are any shows a list of them. The user selects the index of the book they want
     * to borrow, this index is validated(consists of only digits, isn't bigger than the highest 
     * position in the arraylist and checks if the book associated with that index is available), the
     * book of their choice has it's validity changed to unavailable and a copy of it is created in
     * the Patrons borrowed books arraylist. The changes are then saved automatically.
     */
    public void borrowBook(Patron patron)
    {
        if(libraryWF.numberOfAvailBooks()==0)
        {
            System.out.println("There are no available books in the system to borrow!");
        }
        else
        {
            System.out.println("Library Menu > Patron Menu > Borrowed Books > "+patron.getName()+"\n");
            
            System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.print(libraryWF.listAvailableBooks());
            System.out.println(" \nSelect the index of the Book which you'd like to borrow.: ");
            String choice = EasyScanner.nextString();
            
            while (!choice.matches("[0-9]+") || Integer.parseInt(choice) >= libraryWF.numberOfBooks() || libraryWF.getBook(Integer.parseInt(choice)).getAvail() ==false )
            {
                System.out.println(" Please enter the index of an available book. ");
                choice = EasyScanner.nextString();
            }
            Book book =libraryWF.getBook(Integer.parseInt(choice));
            book.setAvail(false);
            patron.addBorrowed(book);
            try
            {
                libraryWF.savePatron();
                libraryWF.saveBook();
                System.out.println("Changes Added to System and Saved:");
            }
            catch (Exception e)
            {
                System.out.println("Error writing to file: " + e);
                System.out.println("Changes Added to System not Saved:");
            }
            try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
            System.out.print('\u000C');
        }
    }
    
    
    
    /**
     * Returns a book. Takes in a patron and if the patron has any books
     * borrowed asks the patron which book they'd like to return. Has validation to make sure
     * the users choice is a number and isn't greater than the highest index in the arraylist.
     * It uses the selected book to check its ID and searches through the bookList to find a 
     * book with the same ID. It changes that books avail to true and removes the copy of the
     * book from the patron's borrow arraylist
     */
    public void returnBook(Patron patron)
    {
        if(patron.numberOfBorrowed()==0)
        {
            System.out.println("There are no books to return!");
        }
        else
        {
            System.out.println("Library Menu > Patron Menu > Borrowed Books > "+patron.getName()+"\n");
        
            System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.print(patron.listOfBorrowed());
            System.out.println(" \nSelect the index of the Book which you'd like to return: ");
            String choice = EasyScanner.nextString();
            
            while (!choice.matches("[0-9]+") || Integer.parseInt(choice) >= patron.numberOfBorrowed())
            {
                System.out.println(" Please enter the index of a borrowed book. ");
                choice = EasyScanner.nextString();
            }
            Book book =patron.getBorrowed().get(Integer.parseInt(choice));
            libraryWF.returnBook(book.getID());
            patron.removeBorrowed(Integer.parseInt(choice));
            try
            {
                libraryWF.savePatron();
                libraryWF.saveBook();
                System.out.println("Changes Added to System and Saved:");
            }
            catch (Exception e)
            {
                System.out.println("Error writing to file: " + e);
                System.out.println("Changes Added to System not Saved:");
            }
            try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
            System.out.print('\u000C');
        }
    }
    
    
    
    /**
     * Creates a new patron and automatically saves it
     */
    public void createPatron()
    {

        //Declare 5 String Variables
        String name;
        String email;
        String phoneNo;
        String address;
        ArrayList<Book> borrowed= new ArrayList<Book>();
        
        //Input and assign values for 4 variables

        System.out.print("Enter Patron Name ");
        name = EasyScanner.nextString();
        while(name.length() >40)
        {
            System.out.print("Try again - A patrons name can have a maximum of 40 characters   : ");
            name = EasyScanner.nextString();
        }

        System.out.print("Enter Patron Email: ");
        email = EasyScanner.nextString();
        while(!(email.contains("@") && email.contains(".")))
        {
            System.out.print("Try again - Email must have an @ and a .   : ");
            email = EasyScanner.nextString();
        }
        
        System.out.print("Enter Patron Phone Number: ");
        phoneNo = EasyScanner.nextString();
        
        System.out.print("Enter Patron Address: ");
        address = EasyScanner.nextString();
        
        //Establish type of patron to select remaining variables then make and add patron to list
        System.out.println("What kind of Patron is this? [1-2] ");
        System.out.println("1. Librarian");
        System.out.println("2. Regular Patron");
        int choice = EasyScanner.nextInt();
        if (choice == 1)
        {
            Double salary;
                
            System.out.print("Enter salary per hour: €");
            salary = EasyScanner.nextDouble();
            Librarian l1 = new Librarian(name, email, phoneNo, address, borrowed, salary);
            libraryWF.addPatron(l1);
        }
        else if (choice == 2)
        {
            String ID;
            boolean student;
                
            System.out.print("Enter Patron ID: ");
            ID = EasyScanner.nextString();
            System.out.println("Is this patron a student? [1-2] ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int stuChoice = EasyScanner.nextInt();
            if (stuChoice == 1)
            {
                student = true;
            }
            else
            {
                student = false;
            }
            Regular r1 = new Regular(name, email, phoneNo, address, borrowed, ID, student);
            libraryWF.addPatron(r1);
        }
                
        //Save automatically
        try
        {
            libraryWF.savePatron();
            System.out.println("Patron Added to System and Saved:");
        }
        catch (Exception e)
        {
            System.out.println("Error writing to file: " + e);
            System.out.println("Patron Added to System not Saved:");
        } 
        try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
        System.out.print('\u000C');
    }
    
    
    
    /**
     * Creates a new book and automatically saves it
     */
    public void createBook()
    {

        //Declare 6 String Variables
        String ID;
        String title;
        String author;
        String genre;
        Double cost;
        boolean avail = true;
        
        //Input and assign values for 5 variables, there is a default value for the sixth
        System.out.print("Enter a 7 digit Book ID: ");
        ID = EasyScanner.nextString();
        while (!libraryWF.validifyBookID(ID) || !ID.matches("[0-9]+") || !(ID.length() == 7))
        {
            System.out.print("Invalid ID, Please Enter a Unique, 7 Digit ID: ");
            ID = EasyScanner.nextString();
        }
        
        System.out.print("Enter Book Title: ");
        title = EasyScanner.nextString();

        System.out.print("Enter Book Author: ");
        author = EasyScanner.nextString();

        System.out.print("Enter Book Genre: ");
        genre = EasyScanner.nextString();
        while(genre.length() >40)
        {
            System.out.print("Try again - A books genre can have a maximum of 40 characters   : ");
            genre = EasyScanner.nextString();
        }
        
        System.out.print("Enter Book Cost: €");
        cost = EasyScanner.nextDouble();
        
        //Establish type of book to select remaining variables then make and add book to list
        System.out.println("What kind of book is this? [1-3] ");
        System.out.println("1. Print");
        System.out.println("2. Ebook");
        System.out.println("3. Audio Book");
        int choice = EasyScanner.nextInt();
        if (choice == 1)
        {
            int pageCount;
                
            System.out.print("Enter Page Count: ");
            pageCount = EasyScanner.nextInt();
            Print p1 = new Print(ID, title, author, genre, cost, avail, pageCount);
            libraryWF.addBook(p1);
        }
        else if (choice == 2)
        {
            int pageCount;
            Double fileSize;
                
            System.out.print("Enter Page Count: ");
            pageCount = EasyScanner.nextInt();
            System.out.print("Enter File Size (MB): ");
            fileSize = EasyScanner.nextDouble();
            Ebook e1 = new Ebook(ID, title, author, genre, cost, avail, pageCount, fileSize);
            libraryWF.addBook(e1);
        }
        else if (choice == 3)
        {
            int length;
            Double fileSize;
            String narrator;
                
            System.out.print("Enter Length (Hours): ");
            length = EasyScanner.nextInt();
            System.out.print("Enter File Size (MB): ");
            fileSize = EasyScanner.nextDouble();
            System.out.print("Enter Narrator: ");
            narrator = EasyScanner.nextString();
            Audio a1 = new Audio(ID, title, author, genre, cost, avail, length, fileSize, narrator);
            libraryWF.addBook(a1);
        }
        
        //Save automatically
        try
        {
            libraryWF.saveBook();
            System.out.println("Book Added to System and Saved:");
        }
        catch (Exception e)
        {
            System.out.println("Error writing to file: " + e);
            System.out.println("Book Added to System not Saved:");
        }    
        try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
        System.out.print('\u000C');
    }
    
    
    
    /**
     * Deletes a selected Patron. Stops if there aren't any patrons to be
     * deleted or if the user attempts to delete a Patron that is currenlty borrowing a
     * book. Saves automatically afterwards.
     */
    public void deletePatron()
    {
        if(libraryWF.numberOfPatrons() ==0)
        {
            System.out.println("There are no patrons in the system to be removed!  ");
        }
        else
        {
            System.out.println("Which list of Patrons would you like to see? [1-3]");
            System.out.println("1. All Patrons");
            System.out.println("2. Librarians");
            System.out.println("3. Regular Patrons");
            int listChoice = EasyScanner.nextInt();
            System.out.print('\u000C');
            
            System.out.println("Waterford Library Patron List: ");
            System.out.println(libraryWF.listOfPatrons(listChoice));
            System.out.println("______________________________");
            System.out.println("Enter the Index of the Patron you wish to delete from the system:  ");
            int index = EasyScanner.nextInt();
            if (!(libraryWF.getPatron(index).numberOfBorrowed() ==0))
            {
                System.out.println("The Patron you have selected cannot be removed as they are currently borrowing books.");
            }
            else
            {
                libraryWF.removePatron(index);
                try
                {
                    libraryWF.savePatron();
                    System.out.println("Patron Removed from System and Saved:");
                }
                catch (Exception e)
                {
                    System.out.println("Error writing to file: " + e);
                    System.out.println("Patron Removed from System not Saved:");
                }    
                try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
                System.out.print('\u000C');
            }
        }
    }
    
    
    
    /**
     * Deletes a selected Book. Stops if there aren't any books to be deleted
     * or if the user attempts to delete a Book that is currenlty borrowed. Saves automatically 
     * afterwards.
     */
    public void deleteBook()
    {
        if(libraryWF.numberOfBooks() ==0)
        {
            System.out.println("There are no books in the system to be removed!  ");
        }
        else
        {
            System.out.println("Which list of Books would you like to see? [1-3]");
            System.out.println("1. All Books");
            System.out.println("2. Print");
            System.out.println("3. Ebooks");
            System.out.println("3. Audio Books");
            int listChoice = EasyScanner.nextInt();
            System.out.print('\u000C');
            
            System.out.println("Waterford Library Book List: ");
            System.out.println(libraryWF.listOfBooks(listChoice));
            System.out.println("______________________________");
            System.out.println("Enter the Index of the Book you wish to delete from the system:  ");

            int index = EasyScanner.nextInt();
            if (libraryWF.getBook(index).getAvail() ==false)
            {
                System.out.println("The Book you have selected cannot be removed as it is currently borrowed.");
            }
            else
            {
                libraryWF.removeBook(index);
                try
                {
                    libraryWF.saveBook();
                    System.out.println("Book Removed from System and Saved:");
                }
                catch (Exception e)
                {
                    System.out.println("Error writing to file: " + e);
                    System.out.println("Book Removed from System not Saved:");
                } 
            }
            try 
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException ie) 
            {
                Thread.currentThread().interrupt();
            }
            System.out.print('\u000C');
        }
    }
    
    
    
    /**
     * Creates a copy of a book but with a different ID and availability set to true. Saves automatically at the end
     */
    public void copyBook()
    {
        if(libraryWF.numberOfBooks() ==0)
        {
            System.out.println("There are no books in the system to be copied!  ");
        }
        else
        {
            System.out.println("Which list of Books would you like to see? [1-4]");
            System.out.println("1. All Books");
            System.out.println("2. Print");
            System.out.println("3. Ebooks");
            System.out.println("4. Audio Books");
            int listChoice = EasyScanner.nextInt();
            System.out.print('\u000C');
            
            System.out.println("Waterford Library Book List: ");
            System.out.println(libraryWF.listOfBooks(listChoice));
            System.out.println("______________________________");
            System.out.println("Enter the Index of the Book you wish to create a copy of:  ");
            int index = EasyScanner.nextInt();
            Book b=libraryWF.getBook(index);
            
            System.out.print("Enter a 7 digit Book ID: ");
            String ID = EasyScanner.nextString();
            while (!libraryWF.validifyBookID(ID) || !ID.matches("[0-9]+") || !(ID.length() == 7))
            {
                System.out.print("Invalid ID, Please Enter a Unique, 7 Digit ID: ");
                ID = EasyScanner.nextString();
            }
            
            if(b instanceof Print)
            {
                Print p=(Print)b;
                Print p1 = new Print(ID, p.getTitle(), p.getAuthor(), p.getGenre(), p.getCost(), true, p.getPageCount());
                libraryWF.addBook(p1);
            }
            else if(b instanceof Ebook)
            {
                Ebook e=(Ebook)b;
                Ebook e1 = new Ebook(ID, e.getTitle(), e.getAuthor(), e.getGenre(), e.getCost(), true, e.getPageCount(), e.getFileSize());
                libraryWF.addBook(e1);
            }
            else if(b instanceof Audio)
            {
                Audio a=(Audio)b;
                Audio a1 = new Audio(ID, a.getTitle(), a.getAuthor(), a.getGenre(), a.getCost(), true, a.getLength(), a.getFileSize(), a.getNarrator());
                libraryWF.addBook(a1);
            }
            
            try
            {
                libraryWF.saveBook();
                System.out.println("Book Copied and Saved:");
            }
            catch (Exception e)
            {
                System.out.println("Error writing to file: " + e);
                System.out.println("Book Copied not Saved:");
            } 
            try 
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException ie) 
            {
                Thread.currentThread().interrupt();
            }
            System.out.print('\u000C');
        }
    }
    
    
    
    /**
     * Makes a list of all Patrons that have the entered Name
     */
    public void listOfPatronsByName()
    {
        System.out.print("Enter Patron Name: ");
        String name = EasyScanner.nextString();
        System.out.println(libraryWF.searchPatronByName(name));
    }
    
    /**
     * Makes a list of all Books that have the entered Title
     */
    public void listOfBooksByTitle()
    {
        System.out.print("Enter Book Title: ");
        String title = EasyScanner.nextString();
        System.out.println(libraryWF.searchBookByTitle(title));
    }
    
    
    
    /**
     * Updates Book details, not functional so it just displays a message saying so
     */
    public void updateBookDetails()
    {
        System.out.print("This option is currently not available");
    }

    /**
     * Updates Patron details, not functional so it just displays a message saying so
     */
    public void updatePatronDetails()
    {
        System.out.print("This option is currently not available");
    }
}