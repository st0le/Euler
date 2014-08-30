/**
 * 
 */
package org.mechaevil.Euler.Problem112;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem112 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		long c = 0;
		long n = 0;
		while(true)
		{

			if(isBouncyNumber(n))
			{
				c++;
				if(c * 100 == n * 99)
					break;
			}
			n++;

		}
		System.out.println("P112 : " + n);
		
		
		timer.stopTimer();
		System.out.println(timer);
	}
	
	public static boolean isBouncyNumber(long n)
	{
		boolean inc = false;
		boolean dec = false;
		long d = n % 10;
		n /= 10;
		while(n > 0)
		{
			long p = n % 10;
			inc |= (d > p);
			dec |= (d < p);
			d = p;
			n /= 10;
			if(inc && dec) return true;
		}
		return inc && dec;
	}

}
