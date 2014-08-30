/**
 * 
 */
package org.mechaevil.Euler.Problem028;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem028 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int k = 1;
		for(int n = 3; n <= 1001; n += 2)
			k += 4 * n * n - 6 * n + 6;

		System.out.println("P028 : " + k);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
