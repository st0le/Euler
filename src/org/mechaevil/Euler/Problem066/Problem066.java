/**
 * 
 */
package org.mechaevil.Euler.Problem066;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.BigRational;
import org.mechaevil.util.Math.xMathApprox;

/**
 * @author 332609
 *
 */
public class Problem066 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		//NOTE : This is one Bad A** question... :)
		BigInteger maxX = BigInteger.ZERO;
		int ansD = 0;
		for(int i = 2; i < 1000; i++)
		{
			BigRational r = xMathApprox.solvePellEquation(i);
			if(r != null)
			{
				BigInteger x = r.getNumerator();
				if(x.compareTo(maxX) >= 0)
				{
					maxX = x;
					ansD = i;
				}
			}
		}
		System.out.println("P066 : " + ansD);

		timer.stopTimer();
		System.out.println(timer);


	}
}
