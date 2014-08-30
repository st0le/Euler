/**
 * 
 */
package org.mechaevil.Euler.Problem010;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem010 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve sieve = new PrimeSieve(2000000);
		long s = 2;
		for(int i = 3; i < sieve.getMaxLimit(); i+=2)
		{
			if(sieve.isPrime(i))
			{
				s += i;
			}
		}
		System.out.println("P010 : " + s);
		timer.stopTimer();
		System.out.println(timer);
	}
}
