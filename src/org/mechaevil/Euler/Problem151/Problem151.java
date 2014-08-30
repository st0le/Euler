/**
 * 
 */
package org.mechaevil.Euler.Problem151;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem151 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
				
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		
		System.out.printf("P151 : %.6f\n", solve(1, 1, 1, 1));

		timer.stopTimer();
		System.out.println(timer);


	}

	private static double solve(int a2, int a3, int a4, int a5) {
		int s = a2 + a3 + a4 + a5;
		if(s == 1 && a5 == 1) return 0.0;
		double r = 0.0;
		if( s == 1) r = 1;
		if(a2 > 0) 
			r += solve(a2-1,a3+1,a4+1,a5+1) * a2/s;
		if(a3 > 0) 
			r += solve(a2,a3-1,a4+1,a5+1)* a3/s;
		if(a4 > 0) 
			r += solve(a2,a3,a4-1,a5+1)* a4/s;
		if(a5 > 0) 
			r += solve(a2,a3,a4,a5-1)* a5/s;
		return r;
	}

}
