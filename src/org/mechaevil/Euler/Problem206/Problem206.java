/**
 * 
 */
package org.mechaevil.Euler.Problem206;

import java.util.regex.Pattern;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem206 {

	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		long ubound = (long)Math.sqrt(1929394959697989990L);

		long start = ubound;
		while(!Pattern.matches("1.2.3.4.5.6.7.8.9.0", String.valueOf(start*start)))
			start--;
		System.out.println("P206 : " + start);

		timer.stopTimer();
		System.out.println(timer);

	}


}
