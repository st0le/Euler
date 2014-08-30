/**
 * 
 */
package org.mechaevil.Euler.Problem101;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.UtilityMethods;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem101 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		double [] coeffiecient = new double[]{1,-1,1,-1,1,-1,1,-1,1,-1,1};
		long [] correctValues = new long[10];
		
		for(int n = 0; n < 10; n++)
			correctValues[n] = (long)xMath.solvePolynomial(coeffiecient , n+1);
		
		long s = solve(correctValues,10);
		System.out.println("P101 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);

	}
	
	public static long solve(long []p,int n)
	{
		long s = 0;
		while(n >  1)
		{
			s += UtilityMethods.sumArray(p);
			long[] newp = new long[n-1];
			for(int i = n - 2; i >= 0; i--)
			{
				newp[i] = p[i+1] - p[i];
			}
			p = newp;
			n--;
		}
		return s + p[0];
	}

}
