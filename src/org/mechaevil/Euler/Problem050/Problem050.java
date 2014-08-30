/**
 * 
 */
package org.mechaevil.Euler.Problem050;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem050 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve table = new PrimeSieve();
		int count = table.countPrimes();
		int[] primes = new int[count];
		int k = 0;
		primes[k++] = 2;
		for (int i = 3; i < table.getMaxLimit(); i++)
			if (table.isPrime(i))
				primes[k++] = i;
		
		int maxLen = 21,maxSum = 953;
		int len = 0;
		for(int startIndex = 0; startIndex < primes.length; startIndex++)
		{
			int sum = primes[startIndex];
			for(int sweepIndex = startIndex + 1;sum < 1000000 && sweepIndex < primes.length; sweepIndex++)
			{
				sum += primes[sweepIndex];
				if(table.isPrime(sum))
				{
					len = sweepIndex - startIndex;
					if(maxLen < len)
					{
						maxLen = len;
						maxSum = sum;
						//System.out.println(maxLen + " : " + maxSum);
					}
				}
			}
		}
		System.out.println("P050 : " + maxSum);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
