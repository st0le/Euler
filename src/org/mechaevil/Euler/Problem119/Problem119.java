/**
 * 
 */
package org.mechaevil.Euler.Problem119;

import java.math.BigInteger;
import java.util.TreeSet;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem119 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		BigInteger TEN = BigInteger.valueOf(10);
		TreeSet<BigInteger> set = new TreeSet<BigInteger>();
		for(int n = 2; n < 70; n ++)
		{
			BigInteger big = BigInteger.valueOf(n);
			for(int p = 1; p < 50; p++)
			{
				BigInteger pow = big.pow(p);
				if(pow.compareTo(TEN) >=0 && xMath.sumDigits(pow) == n)
					set.add(pow);
			}
		}
		int c = 1;
		BigInteger solution = null;
		for(BigInteger b: set)
		{
			if( c == 30)
			{
				solution = b;
				break;
			}
			c++;
		}
		System.out.println("P119 : " + solution);	
		timer.stopTimer();
		System.out.println(timer);


	}

}
