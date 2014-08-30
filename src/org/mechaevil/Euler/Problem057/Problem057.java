/**
 * 
 */
package org.mechaevil.Euler.Problem057;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem057 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		BigInteger num = BigInteger.valueOf(3);
		BigInteger den = BigInteger.valueOf(2);
		int c = 0;
		for(int i = 2 ; i < 1000; i++ )
		{
			if(num.toString().length() > den.toString().length()) c++;
			BigInteger t = num.add(den);
			num = t.add(den);
			den = t;
		}
		System.out.println("P057 : " + c);
		timer.stopTimer();
		System.out.println(timer);


	}

}
