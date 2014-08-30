/**
 * 
 */
package org.mechaevil.Euler.Problem085;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem085 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int minDiff = 10000000;
		int ans = 0; 
		for(int n = 1; n < 100; n++)
		{
			for(int k = 1; k < 100; k++)
			{
				int h = Math.abs(2000000-calculateRectangles(n, k));
				if(h < minDiff)
				{
					ans = n*k;
					minDiff = h;
				}
			}
		}
		System.out.println("P085 : " + ans );
		timer.stopTimer();
		System.out.println(timer);

	}
	
	//Solution : http://web.gnowledge.org/wiki/index.php/Solution_to_Number_of_Rectangles
	public static int calculateRectangles(int n,int k)
	{
		int s = 0;
		for(int a = 1;a < n+1;a++)
			for(int b = 1; b < k+1; b++)
				s += a*b;
		return s;
	}

}
