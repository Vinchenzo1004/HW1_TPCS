package MainMenu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

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
     * @throws IllegalArgumentException if the number is negative
     * @return the factors of the given number and whether it is prime or not
     */
    public void factorize(int number)
    {
        if(factorizationCache.containsKey(number))
        {
            FactorizationResult result = factorizationCache.get(number);
            System.out.println("Factors: " + result.getFactors());
            System.out.println("Prime: " + result.isPrime());
        }
        else
        {
            FactorizationResult result = getFactors(number);
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
        List<Integer> factors = new ArrayList<>();
        boolean isPrime = true;

        for(int i = 1; i <= Math.sqrt(number); i++)
        {
            if(number % i == 0)
            {
                factors.add(i);

                if(i != 1 && i != number)
                {
                    isPrime = false;
                }

                if(i != number / i)
                {
                    factors.add(number / i);
                }
            }
        }

        Collections.sort(factors);

        StringBuilder factorString = new StringBuilder();
        for(Integer factor : factors)
        {
            factorString.append(factor).append(" ");
        }

        return new FactorizationResult(factors.toString(), isPrime);
    }
}
