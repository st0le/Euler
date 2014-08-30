/**
 * 
 */
package org.mechaevil.Euler.Problem004;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem004 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//Simple Brute Force
		int max = 0;
		for(int a = 100; a< 1000; a++)
			for(int b = 100; b< 1000; b++)
				if(xMath.isPalindrome(a*b)) max = Math.max(max, a*b);
		timer.stopTimer();
		System.out.println("P004 : " + max);
		System.out.println(timer);
	}

}
