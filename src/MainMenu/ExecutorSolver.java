package MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Uses an executor to calculate the factors of a given number.
 * The number of threads used is equal to the number of available processors.
 * The result is returned as a list of integers.
 *
 * @author Vincent Vaccaro
 * @version 4/1/2025
 */
public class ExecutorSolver implements Solver 
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
        ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<FactorizationResult.Entry>> futures = new ArrayList<>();

        for(int n = 2; n <= max; n++) 
        {
            final int value = n;
            futures.add(exec.submit(() -> {
                return new FactorizationResult.Entry(
                    value, Factorizer.factor(value));
            }));
        }

        for(Future<FactorizationResult.Entry> f : futures) 
        {
            try 
            {
                FactorizationResult.Entry e = f.get();
                result.put(e.getNumber(), e.getFactors());
            } 
            catch(Exception ignored) 
            { 
                // Handle exceptions if needed
            }
        }
        exec.shutdown();
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
        System.out.println("Welcome to the Executor Factorizer!");
    }
}
