package MainMenu;

import java.util.*;

/**
 * Stores the result of a factorization operation.
 *
 * @author Vincent Vaccaro
 * @version 3/6/2025
 */
public class FactorizationResult 
{
    private final Map<Integer,List<Integer>> map = new HashMap<>();

    public void put(int n, List<Integer> factors) 
    {
        map.put(n, factors);
    }
    public List<Integer> getFactors(int n) 
    {
        return map.getOrDefault(n, Collections.emptyList());
    }

    // Optional helper if you want to return list of entries
    public static class Entry 
    {
        private final int number;
        private final List<Integer> factors;
        public Entry(int number, List<Integer> factors) 
        {
            this.number = number; this.factors = factors;
        }
        public int getNumber() 
        { 
            return number; 
        }
        public List<Integer> getFactors() 
        { 
            return factors; 
        }
    }
}
