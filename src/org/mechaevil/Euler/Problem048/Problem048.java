/**
 * 
 */
package org.mechaevil.Euler.Problem048;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem048 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final BigInteger MOD = BigInteger.valueOf(10000000000L);
		BigInteger s = BigInteger.ZERO;
		for(int i = 1; i <= 1000; i++) s = s.add(BigInteger.valueOf(i).pow(i));
		System.out.println("P048 : " + s.mod(MOD));

		timer.stopTimer();
		System.out.println(timer);

	}

}
