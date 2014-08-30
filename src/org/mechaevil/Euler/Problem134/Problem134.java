/**
 * 
 */
package org.mechaevil.Euler.Problem134;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem134 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here

		// Solve by Chinese Remainder Theorem (p1 and p2 are consecutive primes)
		// S = p1 (mod 10^k)
		// S = 0  (mod p2)

		//where k = No. of digits in p1 = Ceil(Log10(p1))
		final int N = 1000000;
		PrimeSieve table = new PrimeSieve(N + 100);
		int p1;
		p1 = 5;
		Long solution = 0L;
		for(int p2 = 7; p1 < N ; p2 += 2 )
		{
			if(table.isPrime(p2))
			{
				int k = 0, n = p1;
				while(n > 0)
				{
					n/=10;
					k++;
				}

				try{
					Long S = xMath.chineseRemainderTheorem((long)p1, (long)Math.pow(10,k), 0L, (long)p2);
					solution += S;
				}catch(Exception e)
				{
					System.out.println(e);
				}
				p1 = p2;
			}
		}
		System.out.println("P134 : "  + solution);


		timer.stopTimer();
		System.out.println(timer);
	}

}
