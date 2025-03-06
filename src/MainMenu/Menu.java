package MainMenu;

import java.util.Scanner;

/**
 * A basic menu that displays 6 options.
 * For now, only option 1, 5, and 0 are functional.
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
        Scanner scan = new Scanner(System.in);
        int choice;
        long runtime = 0;

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
            while(!scan.hasNextInt())
            {
                scan.nextLine();
                System.out.print("Invalid Input. Please enter a different value: ");
            }

            choice = Integer.parseInt(scan.nextLine());

            switch(choice)
            {
                case 1:
                    Factorizer factorizer = new Factorizer();
                    long startTime = System.nanoTime();
                    factorizer.precomputeFactorization();   //I have this set to run first so that when the text pops up, the user will know to type in their appropriate input
                    long endTime = System.nanoTime();

                    runtime = endTime - startTime;

                    System.out.println("Welcome to the Single Threaded Factorizer");
                    System.out.println("Please enter a number and we will return the factors of that number " +
                            "and a note if that number is prime or not. Enter 0 to return to the main menu.");
                    System.out.print("Number: ");
                    boolean continueInput = true;

                    while(continueInput)
                    {
                        String input = scan.nextLine();
                        int number = Integer.parseInt(input);
                        if(number == 0)
                        {
                            continueInput = false;
                            System.out.println("Welcome back, User!");
                            System.out.println("1) Single Threaded Solver");
                            System.out.println("2) Executor Solver");
                            System.out.println("3) Stream Solver");
                            System.out.println("4) Distributed Solver");
                            System.out.println("5) Timer");
                            System.out.println("0) Quit");
                            System.out.print("Enter your choice: ");
                        }
                        else if(number < 2 || number > 100000)
                        {
                            System.out.println("Invalid input. Please enter a number between 2 and 100000.");
                        }
                        else
                        {
                            factorizer.factorize(number);
                        }
                    }
                    break;
                case 2, 3, 4:
                    System.out.println("This solver is not implemented yet.");
                    break;
                case 5:
                    System.out.println("Runtime: " + (runtime / 1e9) + " seconds ");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.print("Invalid Input. Please enter a different value: ");
                    break;
            }

            //will most likely remove later
            //if user enters 2, 3, or 4, exit
            if(choice >= 2 && choice <= 4)
            {
                System.exit(0);
            }
        }
        while(choice != 0);
    }
}