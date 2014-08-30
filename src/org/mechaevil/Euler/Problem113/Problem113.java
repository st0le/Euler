/**
 * 
 */
package org.mechaevil.Euler.Problem113;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem113 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		BigInteger c = BigInteger.ZERO;
		for(int n = 1; n <= 100; n++)
		{
			c = c.add(xMath.chooseBig(8+n, n));
			c = c.add(xMath.chooseBig(9+n, n));
			c = c.subtract(BigInteger.valueOf(10));
		}
		System.out.println("P113 : " + c);
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
