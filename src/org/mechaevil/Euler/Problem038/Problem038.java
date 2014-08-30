/**
 * 
 */
package org.mechaevil.Euler.Problem038;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.Math.xMathApprox;

/**
 * @author 332609
 *
 */
public class Problem038 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final long N = 10000;
		long t = 0,mxt = 0;
		for(long i = 1; i < N; i++)
		{
			long j;
			t = 0;
			for( j = 1; xMathApprox.countDigits(t) < 9; j++)
			{
				t = xMath.appendNumber( t, j*i);
			}
			if(xMath.isPandigital9(t))
				mxt =Math.max(t, mxt);
		}
		System.out.println("P038 : " + mxt);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
