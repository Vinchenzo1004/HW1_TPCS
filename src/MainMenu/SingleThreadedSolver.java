package MainMenu;

import java.util.List;

/**
 * A simple single-threaded solver for factorization.
 *
 * @author Vincent Vaccaro
 * @version 4/30/2025
 */
public class SingleThreadedSolver implements Solver 
{
    /**
     * Factor every number from 2 up to MAX (e.g. 100_000),
     * and return a FactorizationResult that holds the full map.
     * 
     * @param max the maximum number to factor
     * @return a FactorizationResult containing the factors of each number
     */
    @Override
    public FactorizationResult solve(int max) 
    {
        FactorizationResult result = new FactorizationResult();
        for (int n = 2; n <= max; n++) 
        {
            result.put(n, Factorizer.factor(n));
        }
        return result;
    }

    /**
     * Print any solver-specific intro text (default: nothing)
     * 
     * @return void
     */
    @Override
    public void welcomeMsg() 
    {
        System.out.println("Welcome to the Single Threaded Factorizer!");
    }

    /**
     * Prompt shown on each query (default: generic)
     * 
     * @return a string prompt for user input
     */
    @Override
    public String getPrompt() 
    {
        return "Enter a number to factor and to check if it is prime (or 0 to quit): ";
    }

    /**
     * Handle and display the factorization result for one number
     * 
     * @param n the number to factor
     * @param factors the list of factors for the number
     * @return void
     */
    @Override
    public void handleResult(int n, List<Integer> factors) 
    {
        System.out.println("Factors of " + n + ": " + factors);
        boolean isPrime = (factors.size() == 2);
        System.out.println(n + (isPrime ? " is prime." : " is not prime."));
    }
}
