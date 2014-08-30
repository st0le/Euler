/**
 * 
 */
package org.mechaevil.Euler.Problem013;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem013 implements Constants{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		BigInteger s = new BigInteger("0");
		String[] nums = numbers.split("\n");
		for(String num: nums)
		{
			s = s.add(new BigInteger(num));
		}
		String num = s.toString();
		System.out.println("P013 : " + num.substring(0,10));
		timer.stopTimer();
		System.out.println(timer);
	}

}
