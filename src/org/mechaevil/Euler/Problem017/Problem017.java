/**
 * 
 */
package org.mechaevil.Euler.Problem017;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Conversions.NumberToWordsConverter;

/**
 * @author 332609
 *
 */
public class Problem017 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int s = 0;
		for(int i = 1 ; i <= 1000; i++)
		{
			s += NumberToWordsConverter.convert(new Integer(i)).replace(" ","").length();
		}
		System.out.println("P017 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
