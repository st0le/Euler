/**
 * 
 */
package org.mechaevil.Euler.Problem055;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem055 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 10000;
		int count = 0;
		for(int n = 0; n < N;n++)
		{
			long num = n;
			int c = 0;
			do
			{
				num += xMath.reverseNumber(num);
				c++;
			}while (c < 50 && !xMath.isPalindrome(num));
			if(c >= 50)
				count++;
		}
		System.out.println("P055 : "  + count);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
