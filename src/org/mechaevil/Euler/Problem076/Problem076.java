/**
 * 
 */
package org.mechaevil.Euler.Problem076;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem076 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		long[] arr = xMath.integerPartition(100);
		System.out.println("P076 : " + (arr[100] - 1));
		
		timer.stopTimer();
		System.out.println(timer);
	}
	
}
