import java.util.*;


/**
 * Used for taking inputs from the user and provides utility. All methods are static
 */
public class EasyScanner
{
    /**
     * Takes in an integer value from the user
     */
    public static int nextInt()
    {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        return i;
    }

    
    
    /**
     * Takes in a double value from the user and will repeat until it is formatted
     * correctly and then it will round to one or two decimal places
     */
    public static double nextDouble()
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (!s.matches("[0-9]+\\.[0-9]+"))
        {
            System.out.print("Invalid input, please enter a number with at least one decimal place :");
            s = sc.nextLine();
        }
        Double d = roundToTwo(Double.parseDouble(s));
        return d;
    }

    
    
    /**
     * Takes in a String from the user
     */
    public static String nextString()
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s;
    }

    
    
    /**
     * Takes a character from the user
     */
    public static char nextChar()
    {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        return c;
    }
    
    
    /**
     * Rounds a double to two decimal places
     */
    public static Double roundToTwo(Double d)
    {
        long tmp = Math.round(d*100);
        return (double) tmp / 100;
    }
}