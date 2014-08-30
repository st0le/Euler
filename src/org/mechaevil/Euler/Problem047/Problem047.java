/**
 * 
 */
package org.mechaevil.Euler.Problem047;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem047 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		
		//Solution does not satisfy the "one minute rule". (A little over a minute)
		int c,i;
		c = 0;
		for(i = 2*3*5*7; c < 4 ;i++) 
		{
			if(xMath.getPrimeFactors(i).length == 4)
				c++;
			else 
				c = 0;
		}
		System.out.println("P047 : " + (i - 4));
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
