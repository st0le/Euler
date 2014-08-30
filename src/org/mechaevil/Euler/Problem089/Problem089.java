/**
 * 
 */
package org.mechaevil.Euler.Problem089;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Conversions.RomanNumeral;

/**
 * @author 332609
 *
 */
public class Problem089 implements Constants{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		String[] lines = rlines.split("\n");
		int len = 0;
		for(String line:lines)
		{
			len += line.length();
			len -= RomanNumeral.convertToRoman(RomanNumeral.valueOf(line)).length();
		}
		System.out.println("P089 : " + len);
		timer.stopTimer();
		System.out.println(timer);

	}

}
