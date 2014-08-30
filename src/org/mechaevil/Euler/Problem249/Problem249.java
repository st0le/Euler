/**
 * 
 */
package org.mechaevil.Euler.Problem249;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.UtilityMethods;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author st0le
 *
 */
public class Problem249 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		final int N = 5000;
		final long MOD = (long) Math.pow(10, 16);
		int []primes = new PrimeSieve(N).toPrimitiveArray();
		int sum = (int) UtilityMethods.sumArray(primes);
		
		long[] sset = new long[sum+1];
		sset [0] = 1;
		int maxsum = 0;
		for(int prime:primes)
		{
			for(int j = maxsum; j > 0; j--)
			{
				sset[j+prime] += sset[j];
				if(sset[j+prime] >= MOD) sset[j+prime] -= MOD;
			}
			sset[prime]++;
			maxsum += prime;
		}
		
		PrimeSieve sieve = new PrimeSieve(sum+1);
		long s = 0;
		for(int i = 0 ; i < sset.length;i++)
			if(sieve.isPrime(i))
			{
				s += sset[i];
				if(s >= MOD ) s-= MOD;
			}
		System.out.println("P249 : " + s);
		timer.stopTimer();
		System.out.println(timer);

	}

}
