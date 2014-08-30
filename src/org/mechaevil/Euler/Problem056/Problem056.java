/**
 * 
 */
package org.mechaevil.Euler.Problem056;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem056 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int mx = 0;
		for(long a = 90; a< 100; a++ )
			for(int b = 90; b< 100; b++ )
				mx = Math.max(xMath.sumDigits(BigInteger.valueOf(a).pow(b)), mx);
		System.out.println("P056 : " + mx);
		
		timer.stopTimer();
		System.out.println(timer);
	}

}
