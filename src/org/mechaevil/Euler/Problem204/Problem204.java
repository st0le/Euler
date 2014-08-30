/**
 * 
 */
package org.mechaevil.Euler.Problem204;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem204 {

	static int[] primes = null;
	static final long MAX = 1000000000L;
	
	
	static long count(long prod, int start)
	{
		long count = 0;
		while (prod <= MAX)
		{
			if (start + 1 < primes.length)
				count += count(prod, start + 1);
			prod *= primes[start];
			if (prod <= MAX)
				count++;
		}
		return count;
	}


	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// ... your Code here
		
		primes = new PrimeSieve(100).toPrimitiveArray();
		long cnt = count(1,0);
		System.out.println("P204 : " + cnt);

		timer.stopTimer();
		System.out.println(timer);
	}

}
