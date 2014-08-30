/**
 * 
 */
package org.mechaevil.Euler.Problem016;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem016 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		
		System.out.println("P016 : " + xMath.sumDigits(new BigInteger("2").pow(1000)));
		timer.stopTimer();
		System.out.println(timer);

	}

}
