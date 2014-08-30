/**
 * 
 */
package org.mechaevil.Euler.Problem046;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.xPrime;

/**
 * @author 332609
 *
 */
public class Problem046 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int i ;
		for(i = 3;!(!xPrime.isPrimeNaive(i) && check(i)) ; i += 2);
		System.out.println("P046 : " + i);
		
		timer.stopTimer();
		System.out.println(timer);
	}

	private static boolean check(int n) {
		// 
		for(int i = 1; 2*i*i < n; i++ )
			if(xPrime.isPrimeNaive(n-2*i*i)) return false;
		return true;
	}

}
