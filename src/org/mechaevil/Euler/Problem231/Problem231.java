package org.mechaevil.Euler.Problem231;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

public class Problem231 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// ... your Code here
		
		int n = 20000000,k= 15000000;
		int[] primes = new PrimeSieve(n+1).toPrimitiveArray();
		int f = 0;
		long s = 0;

		for(int p = 0; p < primes.length; p++)
		{
			int prime = primes[p];
			int x = n;
			f = 0;
			while(x >= prime)
			{
				x /= prime;
				f += x;
			}
			x = k;
			while(x >= prime)
			{
				x /= prime;
				f -= x;
			}
			x = n-k;
			while(x >= prime)
			{
				x /= prime;
				f -= x;
			}
			while(f > 0)
			{
				s+=prime;
				f--;
			}
		}
		System.out.println("P231 : " + s);

		timer.stopTimer();
		System.out.println(timer);
	}

}
