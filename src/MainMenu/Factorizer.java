package MainMenu;

import java.util.HashMap;
import java.util.Map;

import MainMenu.FactorizationResult;

/**
 * MainMenu.Factorizer system that will factorize numbers.
 * It will display the factors of the number given.
 * It will also display whether the number is prime or not.
 *
 * @author Vincent Vaccaro
 * @version 3/5/2025
 */
public class Factorizer
{
    private Map<Integer, FactorizationResult> factorizationResults = new HashMap<>();
    private Map<Integer, FactorizationResult> factorizationCache = new HashMap<>();

    public void precomputeFactorization()
    {
        for(int i = 2; i <= 100000; i++)
        {
            FactorizationResult result = getFactors(i);
            factorizationCache.put(i, result);
        }
    }

    public void factorize(int number)
    {
        if(factorizationCache.containsKey(number))
        {
            FactorizationResult result = factorizationCache.get(number);
            System.out.println("Factors: " + result.getFactors());
            System.out.println("Prime: " + result.isPrime());
        }
    }

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
