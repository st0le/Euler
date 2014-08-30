/**
 * 
 */
package org.mechaevil.Euler.Problem009;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem009 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		for(int a = 1; a < 1000; a++)
			for(int b = 1; b <= a && a+b < 1000; b++)
			{
				int c = 1000 - a - b;
				if(a*a + b*b == c*c)
					System.out.println("P009 : " + a*b*c);
			}
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
