package MainMenu;

import java.util.List;

/**
 * Interface for different factorization solvers.
 * Each solver should implement the solve method to provide its own factorization logic.
 * 
 * @author Vincent Vaccaro
 * @version 4/30/2025
 */
public interface Solver 
{
    /**
     * Factor every number from 2 up to MAX (e.g. 100_000),
     * and return a FactorizationResult that holds the full map.
     */
    FactorizationResult solve(int max);

    /**
     * Print any solver-specific intro text (default: nothing)
     * 
     * @return void
     */
    default void welcomeMsg() 
    {
        // No description by default
    }

    /**
     * Prompt shown on each query (default: generic)
     * 
     * @return a string prompt for user input
     */
    default String getPrompt() 
    {
        return "Enter a number to factor (or 0 to quit): ";
    }

    /**
     * Handle and display the factorization result for one number
     * 
     * @param n the number to factor
     * @param factors the list of factors for the number
     * @return void
     */
    default void handleResult(int n, List<Integer> factors) 
    {
        System.out.println("Factors of " + n + ": " + factors);
    }
}
