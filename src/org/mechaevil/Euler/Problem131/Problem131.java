/**
 * 
 */
package org.mechaevil.Euler.Problem131;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;


/**
 * @author 332609
 *
 */
public class Problem131 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve table = new PrimeSieve(1000000);
		int c = 0;
		for(int i = 1; i < 1000; i++)
		{
			int k  = (i+1)*(i+1)*(i+1) - i*i*i;
			if(table.isPrime(k))
				c++;
		}
		System.out.println("P131 : " + c);
		timer.stopTimer();
		System.out.println(timer);

	}
}