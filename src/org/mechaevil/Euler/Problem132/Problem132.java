/**
 * 
 */
package org.mechaevil.Euler.Problem132;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem132 {

	private static boolean isDivisible(int k,int p)
	{
		return xMath.powMod(10, k, p) == 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve table = new PrimeSieve(1000000);
		int s =  0;
		int c = 0;
		for(int i = 7; c < 40 &&  i < table.getMaxLimit(); i+=2)
		{
			if(table.isPrime(i) && isDivisible((int)1e9, i))
			{
				s += i;
				c++;
			}
		}
		System.out.println("P132 : " + s);		
		timer.stopTimer();
		System.out.println(timer);

	}

}
