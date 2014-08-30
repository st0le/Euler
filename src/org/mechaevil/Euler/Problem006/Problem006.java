/**
 * 
 */
package org.mechaevil.Euler.Problem006;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem006 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int n = 100;
		long s = (long) Math.pow(n * (n+1) / 2,2) - (n * (2*n+1) / 6) ;
		System.out.println("P006 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);

	}

}
