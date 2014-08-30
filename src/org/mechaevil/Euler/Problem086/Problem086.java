/**
 * 
 */
package org.mechaevil.Euler.Problem086;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem086 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int s = 0;
		int m = 0;
		while(s < 1000000) s += cube(++m);
		
		System.out.println("P086 : "  + m);
		timer.stopTimer();
		System.out.println(timer);

	}
	
	public static int cube(int m)
	{
		int s = 0;
		int m2 = m*m;
		for(int a = 1; a <= 2*m; a++)
		{
			if(xMath.isPerfectSquare(a*a + m2))
			{
				if(a > m)
					s += (a/2) - (a-m-1);
				else
					s += (a/2);
			}
		}
		return s;
	}

}
