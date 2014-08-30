/**
 * 
 */
package org.mechaevil.Euler.Problem003;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem003 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		long num = 600851475143L;
		int [] pFactors = xMath.getPrimeFactors(num);
		timer.stopTimer();
		System.out.println("P003 : " + pFactors[pFactors.length - 1 ]);
		System.out.println(timer);
	}

}
