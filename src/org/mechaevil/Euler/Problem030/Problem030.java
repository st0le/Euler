/**
 * 
 */
package org.mechaevil.Euler.Problem030;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem030 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int Sum = 0;
		int limit  = (int) (6 * Math.pow(9,5));
		for(int i = 2; i <= limit;i++)
		{
			int s = 0;
			int n = i;
			while( n > 0)
			{
				s += Math.pow(n % 10, 5);
				n /= 10;
			}
			if( s == i)
				Sum += i;
		}
		System.out.println("P030 : " + Sum);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
