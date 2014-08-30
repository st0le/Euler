/**
 * 
 */
package org.mechaevil.Euler.Problem012;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem012 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		long n;
		boolean even = true;
		long countDiv = 0;
		for(n = 2; countDiv < 500 ; n++,even = !even )
		{
			if(even) //n is even
				countDiv = xMath.ndiv(n/2) * xMath.ndiv(n+1);
			else
				countDiv = xMath.ndiv(n) * xMath.ndiv((n+1)/2);
		}
		n--;
		System.out.println("P012 : " + (n*(n+1)/2) + " [" + countDiv + "]");
		timer.stopTimer();
		System.out.println(timer);
	}

}
