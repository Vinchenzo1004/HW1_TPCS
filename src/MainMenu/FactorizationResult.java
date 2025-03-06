package MainMenu;

/**
 *
 */
public class FactorizationResult
{
    private String factors;
    private boolean isPrime;

    public FactorizationResult(String factors, boolean isPrime)
    {
        this.factors = factors;
        this.isPrime = isPrime;
    }

    public String getFactors()
    {
        return factors;
    }

    public boolean isPrime()
    {
        return isPrime;
    }
}