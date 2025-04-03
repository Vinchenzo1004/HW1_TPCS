package MainMenu;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A utility class for factorizing numbers using Java streams.
 *
 * @author Vincent Vaccaro
 * @version 4/3/2025
 */
public class Stream
{
    /**
     * Factorizes the given number and returns a list of its factors.
     *
     * @param number the number to factorize
     * @return a list of integers representing the factors of the given number
     */
    public static List<Integer> factorize(int number)
    {
        return IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}