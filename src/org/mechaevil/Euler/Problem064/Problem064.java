/**
 * 
 */
package org.mechaevil.Euler.Problem064;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.Math.xMathApprox;

/**
 * @author 332609
 *
 */
public class Problem064 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int c = 0;
		for(int i = 2; i <= 10000; i++)
		{
			if(!xMath.isPerfectSquare(i))
			{
				if(xMathApprox.continuedFractionOfSqrt(i).size() % 2 == 0) // Matissa [0] + Periodic
					c++;
			}
		}
		System.out.println("P064 : " + c);
		timer.stopTimer();
		System.out.println(timer);


	}

}
