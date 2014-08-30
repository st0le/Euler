/**
 * 
 */
package org.mechaevil.Euler.Problem031;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem031 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int SUM = 200;
		final int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 }; 
		
		//TODO: Replace Recursion with Dynamic Programming...
		System.out.println("P031 : "+ xMath.partitionSet(SUM, coins, 0)); 
		
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
