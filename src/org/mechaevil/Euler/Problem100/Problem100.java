/**
 * 
 */
package org.mechaevil.Euler.Problem100;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem100 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		//First ran this , and sloaned the series... (OEIS Rules!)
//		for(long n = 1; n < 100 ; n++)
//		{
//			long k = n * (n - 1) / 2;
//			long k2 = (long)Math.sqrt(k) + 1;
//			if(k2 * (k2 - 1) == k)
//			{
//				System.out.println(k2 + " : " + k);
//
//			}
//		}
		
		
		long a0 = 1;
		long a1 = 1;
		while(a1 < 1000000000000L)
		{
			long a2 = 6 * a1 - a0 - 2;
			a0 = a1;
			a1 = a2;
		}
		System.out.println("P100 : " + a0);
		
		
		timer.stopTimer();
		System.out.println(timer);
	}
}
