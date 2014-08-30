package org.mechaevil.Euler.Problem234;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

public class Problem234 {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// ... your Code here
		
		final long N = 999966663333L;
		
		final int sqroot = (int) Math.sqrt(N) + 1000;
		int[] primes = new PrimeSieve(sqroot).toPrimitiveArray();
		long s = 0;
		for(int i = 0; (long)primes[i]*primes[i] <= N; i++)
		{
			long p1 = primes[i];
			long p2 = primes[i+1];
			long end = Math.min((long)p2*p2, N);
			
			for(long p = p1*p1 + p1; p < end; p+=p1) s += p; 
			for(long p = p1*p1 +(p2 - p1*p1 % p2); p < end; p+=p2)s += p; 
			for(long p = p1*p2; p < end; p+=p1*p2)s -= 2*p; 

		}
		System.out.println("P234 : " + s);

		timer.stopTimer();
		System.out.println(timer);
	}
	
}
