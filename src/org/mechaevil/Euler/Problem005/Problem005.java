/**
 * 
 */
package org.mechaevil.Euler.Problem005;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem005 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		long lcm = 1;
		for(int i = 2; i <= 20; i++)
			lcm = xMath.lcm(lcm, i);
		
		System.out.println("P005 : " + lcm);
		timer.stopTimer();
		System.out.println(timer);


	}

}
