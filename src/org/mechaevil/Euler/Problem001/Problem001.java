/**
 * 
 */
package org.mechaevil.Euler.Problem001;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem001 {
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int s = 0;
		for (int i = 0; i < 1000; i++)
		{
			if( (i % 3) * (i % 5) == 0 )
			{
				s += i;
			}
		}
		System.out.println("P001 : " + s);
		timer.stopTimer();
		System.out.println(timer);

	}
}
