/**
 * 
 */
package org.mechaevil.Euler.Problem211;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem211 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here

		int N = 64000000;
		long[] sigma_2 = new long[N];

		for (int i = 1; i < N; i++) {
			for (int j = i; j < N; j += i) {
				sigma_2[j] += i * (long) i;
			}
		}

		long s = 0;
		for (int i = 1; i <N; i++) {
			if (xMath.isPerfectSquare(sigma_2[i]))
				s += i;
		}
		
		System.out.println("P211 : "  + s);

		timer.stopTimer();
		System.out.println(timer);
	}


}
