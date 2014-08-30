/**
 * 
 */
package org.mechaevil.Euler.Problem137;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Sequence.xFibonacci;

/**
 * @author 332609
 *
 */
public class Problem137 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		//Sloane : http://www.research.att.com/~njas/sequences/A081018
		//TODO: better analysed solution
		int n = 15;
		System.out.println("P137 : " + xFibonacci.fib93(2 * n)
				* xFibonacci.fib93(2 * n + 1));
		timer.stopTimer();
		System.out.println(timer);

	}

}
