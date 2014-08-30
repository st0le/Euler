/**
 * 
 */
package org.mechaevil.Euler.Problem120;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem120 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int s = 0;
		for(int a = 3; a <= 1000; a++){
			s += findRMax(a);
		}
		System.out.println("P120 : " + s);
		timer.stopTimer();
		System.out.println(timer);
	}

	private static int findRMax(int a) {
		int rmax = 0;
		
		int a2 = a*a;
		int a_minus_1 = a - 1;
		int a_plus_1 = a + 1;
		int m = (a_minus_1 + a_plus_1) % a2; 
		for(int n = 1; n < 3000; n++)
		{
			a_minus_1 *= (a-1);
			a_minus_1 %= a2;
			a_plus_1 *= (a+1);
			a_plus_1 %= a2;
			m = (a_minus_1 + a_plus_1) % a2;
			rmax = Math.max(rmax,m);
		}
		return rmax;
	}

}
