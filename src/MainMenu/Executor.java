package MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Uses an executor to calculate the factors of a given number.
 * The number of threads used is equal to the number of available processors.
 * The result is returned as a list of integers.
 *
 * @author Vincent Vaccaro
 * @version 4/1/2025
 */
public class Executor
{
    /**
     * Factorizes the given number using an executor service.
     * The number of threads used is equal to the number of available processors.
     *
     * @param number the number to be factorized
     * @return a list of integers representing the factors of the given number
     */
    public static List<Integer> factorize(int number)
    {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<List<Integer>> future = executor.submit(new FactorizerTask(number));

        try
        {
            return future.get();
        }
        catch(Exception e)
        {
            System.err.println("Error calculating factors: " + e.getMessage());
            return new ArrayList<>();
        }
        finally
        {
            executor.shutdown();
        }
    }

    /**
     * A callable that factorizes a given number and returns a list of its factors.
     * This task is designed to be used with an executor service.
     */
    private static class FactorizerTask implements Callable<List<Integer>>
    {
        /**
         * The number to be factorized
         */
        private final int number;

        /**
         * Creates a new FactorizerTask with the given number.
         *
         * @param number the number to be factorized
         */
        public FactorizerTask(int number)

        {
            this.number = number;
        }

        /**
         * Factorizes the given number and returns a list of its factors.
         *
         * @return a list of integers representing the factors of the given number
         */
        @Override
        public List<Integer> call()
        {
            List<Integer> factors = new ArrayList<>();
            for(int i = 1; i <= number; i++)
            {
                if(number % i == 0)
                {
                    factors.add(i);
                }
            }
            return factors;
        }
    }
}