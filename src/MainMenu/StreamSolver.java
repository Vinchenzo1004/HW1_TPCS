package MainMenu;

import java.util.stream.IntStream;

/**
 * A utility class for factorizing numbers using Java streams.
 *
 * @author Vincent Vaccaro
 * @version 4/3/2025
 */
public class StreamSolver implements Solver 
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
        // Use Java Streams to factor each number
        IntStream.rangeClosed(2, max)
                 .forEach(n -> result.put(n, Factorizer.factor(n)));
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
        System.out.println("Welcome to the Stream Factorizer!");
    }
}