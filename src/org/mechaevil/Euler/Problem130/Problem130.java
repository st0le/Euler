/**
 * 
 */
package org.mechaevil.Euler.Problem130;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem130 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve table = new PrimeSieve(1000000);
		int c = 0;
		int s = 0;
		for(int i = 2; c < 25 && i < table.getMaxLimit(); i++)
		{
			if(xMath.gcd(10, i) == 1 && !table.isPrime(i))
			{
				int d = A(i);
				if((i - 1) % d  == 0)
				{
					s+=i;
					c++;
				}
			}
		}
		
		System.out.println("P130 : " + s);
		timer.stopTimer();
		System.out.println(timer);
	}
	
	private static int A(int n)
	{
		int m = 0;
		for(int k = 1;;k++ )
		{
			m = ((m * 10) + 1) % n;
			if(m == 0) return k;
		}
	}

}
