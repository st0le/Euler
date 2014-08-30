/**
 * 
 */
package org.mechaevil.Euler.Problem301;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem301 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		int c = 0;
		for(int n = 0; n <= (1<<30); n++)
		{
			if((n ^ (2 * n) ^ (3 * n)) == 0) c++;
		}
		System.out.println("P301 : " +c);

		timer.stopTimer();
		System.out.println(timer);

	}

}
