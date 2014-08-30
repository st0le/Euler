/**
 * 
 */
package org.mechaevil.Euler.Problem092;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem092 {

	public static int[] memo = new int[10000000];

	public static int foo89(int n)
	{
		if(n == 1 || n == 89)
			return (int) n;
		else
		{
			if(memo[n] != 0)
				return  memo[(n)];
			else
			{
				int r = 0;
				int t = n;
				while(n > 0)
				{
					r = r + (n % 10)*(n % 10);
					n /= 10;
				}
				memo[t] = foo89(r);
				return memo[t];
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		long c = 0;
		for(int i = 2; i < 10000000; i++)
		{
			if(foo89(i) == 89)
				c++;
		}
		System.out.println("P092 : " + c);
		timer.stopTimer();
		System.out.println(timer);


	}

}
