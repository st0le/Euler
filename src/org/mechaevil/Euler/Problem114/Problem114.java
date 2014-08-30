/**
 * 
 */
package org.mechaevil.Euler.Problem114;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem114 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		//Sloane'd.
		//http://www.research.att.com/~njas/sequences/A005252
		int n = 51;
		long s = 0;
		for(int k = 0; k <= (n/4); k++)
		{
			s+= xMath.choose(n-2*k, 2*k);
		}
		System.out.println("P114 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);
	}

}
