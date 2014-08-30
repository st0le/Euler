/**
 * 
 */
package org.mechaevil.Euler.Problem019;

import java.util.Calendar;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem019 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int count = 0;
		Calendar c = Calendar.getInstance();
		for(int yr = 1901; yr <= 2000; yr++)
		{
			for(int mn = 0; mn < 12; mn++)
			{
				c.set(yr, mn,1);
				if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) count++;
			}
		}
		System.out.println("P019 : " + count);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
