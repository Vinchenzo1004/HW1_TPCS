package MainMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Factorizer 
{
        /**
         * Return the sorted list of all factors of `number`.
         * (We drop the old prime-checking and printing here —
         *  any downstream user can decide what to do with the list.)
         */
        public static List<Integer> factor(int number) 
        {
            List<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= Math.sqrt(number); i++) 
            {
                if (number % i == 0) 
                {
                    factors.add(i);
                    if (i != number / i) 
                    {
                        factors.add(number / i);
                    }
                }
            }
            Collections.sort(factors);
            return factors;
        }
    }