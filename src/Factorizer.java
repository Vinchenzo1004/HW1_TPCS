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
    public void factorize(int number)
    {

        if(number == 0)
        {
            System.out.println("Welcome back, User!");
            System.out.println("1) Single Threaded Solver");
            System.out.println("2) Executor Solver");
            System.out.println("3) Stream Solver");
            System.out.println("4) Distributed Solver");
            System.out.println("5) Timer");
            System.out.println("0) Quit");
            System.out.print("Enter your choice: ");
            return;
        }

        String factors = getFactors(number);
        System.out.println("Factors: " + factors);

        if(isPrime(number))
        {
            System.out.println("Number " + number + " is prime.");
        }
        else
        {
            System.out.println("Number " + number + " is not prime.");
        }
    }

    private String getFactors(int number)
    {
        StringBuilder factors = new StringBuilder();
        for(int i = 1; i <= number; i++)
        {
            if(number % i == 0)
            {
                factors.append(i).append(" ");
            }
        }
        return factors.toString();
    }

    private boolean isPrime(int number)
    {
        if(number <= 1)
        {
            return false;
        }

        for(int i = 2; i < Math.sqrt(number); i++)
        {
            if(number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
