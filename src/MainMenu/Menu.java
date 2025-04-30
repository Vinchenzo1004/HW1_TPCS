package MainMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A basic menu that displays 6 options.
 *
 * @author Vincent Vaccaro
 * @version 3/5/2025
 */
public class Menu 
{
    private static final int MAX = 100_000;

    /**
     * Main method to run the menu and handle user input.
     *
     * @param args command line arguments
     * @throws Exception if an error occurs during execution
     */
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome, User!");
        System.out.println("1) Single-threaded Solver");
        System.out.println("2) Executor Solver");
        System.out.println("3) Stream Solver");
        System.out.println("4) Distributed Solver");
        System.out.println("5) Timer");
        System.out.println("0) Quit");

        int choice = -1;
        while(true) 
        {
            System.out.print("Please choose an option: ");
            try 
            {
                choice = in.nextInt();
            } 
            catch(InputMismatchException e) 
            {
                System.out.println("Invalid input. Please enter a number between 0 and 5.");
                in.next();
                continue;
            }
            if(choice >= 0 && choice <= 5) 
            break;
            System.out.println("Invalid choice. Please select a number between 0 and 5.");
        }

        Solver s;
        FactorizationResult model;
        switch(choice) 
        {
            case 1:
                s = new SingleThreadedSolver();
                break;
            case 2:
                s = new ExecutorSolver();
                break;
            case 3:
                s = new StreamSolver();
                break;
            case 4:
                s = new DistributedSolver();
                break;
            case 5:
                System.out.println("Timing Single-threaded Solver for numbers up to " + MAX + "...");
                long start = System.nanoTime();
                new SingleThreadedSolver().solve(MAX);
                System.out.printf("Time taken: %.3f seconds%n", (System.nanoTime() - start) / 1e9);
                in.close();
                return;
            case 0:
                System.out.println("Goodbye!");
                in.close();
                return;
            default:
                in.close();
                return;
        }

        model = s.solve(MAX);
        s.welcomeMsg();

        while(true) 
        {
            System.out.print(s.getPrompt());
            int n;
            try 
            {
                n = in.nextInt();
            } 
            catch(InputMismatchException e) 
            {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.next();
                continue;
            }
            if(n > MAX) 
            {
                System.out.println("Invalid input. Please enter a valid integer.");
                continue;
            }
            if(n == 0) break;
            if(n < 0) 
            {
                System.out.println("Please enter a non-negative number, or 0 to quit.");
                continue;
            }
            s.handleResult(n, model.getFactors(n));
        }
        in.close();
    }
}