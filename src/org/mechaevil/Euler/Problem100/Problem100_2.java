/**
 * 
 */
package org.mechaevil.Euler.Problem100;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem100_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		// b(b-1) / (b+r)(b+r-1) = 1/2
		// x(x-1) / y(y-1) = 1/2
		// (x/y)^2 ~ 1/2
		// x/y ~(1/2)^(1/2)
		// y/x ~ 2^(1/2)
		// y/x ~ Continued Fraction of Square root of 2
		// y = (b+r)(b+r - 1)
		// x = b(b-1)
		// when b+r > 10^12 find b=?
		
		//x = b(b-1)
		//x = b^2 - b
		//b^2 - b - x = 0
		//b = solveQuadraticEquation(1,-1,-x)
		
		
		timer.stopTimer();
		System.out.println(timer);
	}
}
