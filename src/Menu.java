import java.util.Scanner;

/**
 * A basic menu that displays 6 options.
 *
 * @author Vincent Vaccaro
 * @version 3/5/2025
 */
public class Menu
{
    /**
     * The main entry point of the program.
     * This method displays a menu to the user and handles their input.
     */
    public static void main(String[] args)
    {
        //Scanner for user input
        Scanner scan = new Scanner(System.in);
        int choice;

        //Menu
        System.out.println("Welcome, User!");
        System.out.println("1) Single Threaded Solver");
        System.out.println("2) Executor Solver");
        System.out.println("3) Stream Solver");
        System.out.println("4) Distributed Solver");
        System.out.println("5) Timer");
        System.out.println("0) Quit");
        System.out.print("Enter your choice: ");

        do
        {
            //while loop to catch if the user's input is an invalid integer
            while(!scan.hasNextInt())
            {
                scan.nextLine();
                System.out.print("Invalid Input. Please enter a different value: ");
            }

            choice = Integer.parseInt(scan.nextLine());

            //switch statements to handle user's input
            switch(choice)
            {
                case 1:
                    System.out.println("Welcome to the Single Threaded Factorizer");
                    System.out.println("Please enter a number and we will return the factors of that number " +
                            "and a note if that number is prime or not. Enter 0 to return to the main menu.");
                    int number = scan.nextInt();
                    scan.nextLine();
                    Factorizer factorizer = new Factorizer();
                    factorizer.factorize(number);
                    break;
                case 2, 3, 4:
                    System.out.println("This solver is not implemented yet.");
                    break;
                case 5:
                    System.nanoTime();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.print("Invalid Input. Please enter a different value: ");
                    break;
            }

            //will probably remove later
            //if user enters 2, 3, or 4, exit
            if(choice >= 2 && choice <= 4)
            {
                System.exit(0);
            }
        }

        //if user enters 0, exit
        while(choice != 0);
    }
}