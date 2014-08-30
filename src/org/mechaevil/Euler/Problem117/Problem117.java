/**
 * 
 */
package org.mechaevil.Euler.Problem117;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.UtilityMethods;

/**
 * @author 332609
 *
 */
public class Problem117 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		long [] num = new long[4];
		num[0] = 2;
		num[1] = 4;
		num[2] = 8;
		num[3] = 15;
		int max = 50;
		for(int i = 6; i <= max; i++)
		{
			long s = UtilityMethods.sumArray(num);
			UtilityMethods.shiftArrayLeft(num);
			num[3] = s;
		}
		
		System.out.println("P117 : " + num[3]);
		
		timer.stopTimer();
		System.out.println(timer);

	}

}
