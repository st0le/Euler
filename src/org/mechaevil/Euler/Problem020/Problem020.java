/**
 * 
 */
package org.mechaevil.Euler.Problem020;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem020 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		System.out.println("P020 : " + xMath.sumDigits(xMath.fact(new BigInteger("100"))));
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
