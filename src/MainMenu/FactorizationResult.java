package MainMenu;

/**
 * Stores the result of a factorization operation.
 *
 * @author Vincent Vaccaro
 * @version 3/6/2025
 */
public class FactorizationResult
{
    private String factors;
    private boolean isPrime;

    /**
     * Constructs a FactorizationResult with the given factors and prime status.
     *
     * @param factors a string representing the factors of a number
     * @param isPrime a boolean indicating whether the number is prime
     */
    public FactorizationResult(String factors, boolean isPrime)
    {
        this.factors = factors;
        this.isPrime = isPrime;
    }

    /**
     * Gets the string representation of the factors of a number.
     *
     * @return a string containing the factors of a number
     */
    public String getFactors()
    {
        return factors;
    }

    /**
     * Checks if the number is prime.
     *
     * @return true if the number is prime, false otherwise
     */
    public boolean isPrime()
    {
        return isPrime;
    }
}