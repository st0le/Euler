/**
 * 
 */
package org.mechaevil.Euler.Problem080;

import java.math.BigDecimal;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.Math.xMathApprox;

/**
 * @author 332609
 *
 */
public class Problem080 {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		int s = 0;
		for(int i = 2; i < 100; i++)
		{
			if(xMath.isPerfectSquare(i)) continue;
			String str = xMathApprox.bigRoot(BigDecimal.valueOf(i), 2, 200).toString();
			str = str.replace(".", "").substring(0,100);
			s += xMath.sumDigits(str);
		}
		System.out.println("P080 : " + s);

		timer.stopTimer();
		System.out.println(timer);
	}

}
