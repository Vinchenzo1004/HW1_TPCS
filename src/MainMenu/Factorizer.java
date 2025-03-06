package MainMenu;

import java.util.HashMap;
import java.util.Map;

/**
 * Factorizer system that will factorize numbers.
 * It will display the factors of the number given.
 * It will also display whether the number is prime or not.
 *
 * @author Vincent Vaccaro
 * @version 3/5/2025
 */
public class Factorizer
{
    /**
     * Cache to store the factorization results for numbers
     */
    private final Map<Integer, FactorizationResult> factorizationCache = new HashMap<>();

    /**
     * Precompute the factorization of numbers from 2 to 100000.
     */
    public void precomputeFactorization()
    {
        for(int i = 2; i <= 100000; i++)
        {
            FactorizationResult result = getFactors(i);
            factorizationCache.put(i, result);
        }
    }

    /**
     * Prints the factors of a given number and whether it is prime or not.
     *
     * @param number the number to factorize
     */
    public void factorize(int number)
    {
        if(factorizationCache.containsKey(number))
        {
            FactorizationResult result = factorizationCache.get(number);
            System.out.println("Factors: " + result.getFactors());
            System.out.println("Prime: " + result.isPrime());
        }
    }

    /**
     * Returns the factors of a given number and whether it is prime or not.
     *
     * @param number, the number to factorize
     * @return a FactorizationResult that contains the factors and whether the number is prime or not
     */
    private FactorizationResult getFactors(int number)
    {
        StringBuilder factors = new StringBuilder();
        boolean isPrime = true;

        for(int i = 1; i <= number; i++)
        {
            if(number % i == 0)
            {
                factors.append(i).append(" ");

                if(i != 1 && i != number)
                {
                    isPrime = false;
                }
            }
        }
        return new FactorizationResult(factors.toString(), isPrime);
    }
}
