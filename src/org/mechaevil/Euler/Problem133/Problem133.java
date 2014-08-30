/**
 * 
 */
package org.mechaevil.Euler.Problem133;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem133 {

	private static boolean isDivisible(int k,int p)
	{
		BigInteger TEN = BigInteger.valueOf(10);
		return TEN.modPow(TEN.pow(100),BigInteger.valueOf(p)).compareTo(BigInteger.ONE) == 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		
		PrimeSieve table = new PrimeSieve(100000);
		int s = 2 + 3;
		for(int i = 3 ;i < table.getMaxLimit(); i+=2)
		{
			if(table.isPrime(i) && !isDivisible(100, i))
			{
				s += i;
			}
		}
		System.out.println("P133 : " + s);

		timer.stopTimer();
		System.out.println(timer);

	}

}
