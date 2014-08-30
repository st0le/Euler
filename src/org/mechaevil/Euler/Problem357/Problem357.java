package org.mechaevil.Euler.Problem357;

import java.util.Arrays;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

public class Problem357 {

    private static int[] primes;

    public static boolean foo(int n)
    {
        int sqrt = 1+ (int)Math.sqrt(n);
        for(int i = 1; i < sqrt; i++)
            if(n % i == 0 && (Arrays.binarySearch(primes,i + n/i)<0))
                    return false;
            return true;
    }

    public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//Your Code here...
		PrimeSieve sieve = new PrimeSieve(100000000);
		primes = sieve.toPrimitiveArray();
		
		long s = 0;
		for(int prime : primes)
		    if(foo(prime-1))
		        s += prime - 1;
		
		System.out.println("P357 : "  +s);
		timer.stopTimer();
		System.out.println(timer.getElapsedTimeInMillis() + "ms");
    }

}
