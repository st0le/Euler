/**
 * 
 */
package org.mechaevil.Euler.Problem049;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.PrimeFactory.xPrime;

/**
 * @author 332609
 *
 */
public class Problem049 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		boolean found = false;
		for(int a = 1487 + 2;!found && a < 10000; a += 2)
		{
			if(xPrime.isPrimeNaive(a))
			{
				for(int b = a+3330; b < 10000; b += 3330)
					if(xMath.isPermutation(a, b) && xPrime.isPrimeNaive(b))
					{
						for(int c = b + 3330; c < 10000; c += 3330)
						{
							if(xMath.isPermutation(a, c) && xPrime.isPrimeNaive(c))
							{
								System.out.println("P049 : " + a + "" + b + "" + c);
								found = true;
							}
						}
					}
			}
		}
		timer.stopTimer();
		System.out.println(timer);
	}

}
