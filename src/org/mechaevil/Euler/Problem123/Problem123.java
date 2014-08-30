/**
 * 
 */
package org.mechaevil.Euler.Problem123;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem123 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve table = new PrimeSieve(1000000);
		int n = 0;
		int solution = -1;
		for(int i = 0; i < table.getMaxLimit(); i++)
		{
			int p = i;
			if(table.isPrime(p))
			{
				n++;
				if(findRMax(p,n) > 1e10)
				{
					solution = n;
					break;
				}
			}
		}
		System.out.println("P123 : " + solution);
		
		timer.stopTimer();
		System.out.println(timer);
	}

	private static long findRMax(long a,int N) {
		BigInteger bigN = BigInteger.valueOf(N);
		BigInteger a2 = BigInteger.valueOf(a).pow(2);
		BigInteger a_plus_1 = BigInteger.valueOf(a+1).modPow(bigN, a2);
		BigInteger a_minus_1 = BigInteger.valueOf(a-1).modPow(bigN, a2);
		return a_plus_1.add(a_minus_1).mod(a2).longValue();
	}
}
