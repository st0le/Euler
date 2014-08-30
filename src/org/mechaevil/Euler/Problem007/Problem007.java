/**
 * 
 */
package org.mechaevil.Euler.Problem007;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem007 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve sieve = new PrimeSieve();
		int i,c;
		for( i = c = 0; c <= 10000; i++ )
		{
			if(sieve.isPrime(i))
				c++;
		}
		System.out.println("P007 : " + (i-1));
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
