/**
 * 
 */
package org.mechaevil.Euler.Problem099;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem099 implements Constants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		String[] lines = numbers.split("\n");
		int maxLineNo = 0;
		double maxValue = 0.0;
		for(int i = 0 ; i < lines.length; i++)
		{
			String[] num = lines[i].split(",");
			double value = Double.parseDouble(num[1]) * Math.log10(Double.parseDouble(num[0]));
			if(maxValue < value)
			{
				maxValue = value;
				maxLineNo = i + 1;
			}
		}
		System.out.println("P099 : " + maxLineNo);
		
		timer.stopTimer();
		System.out.println(timer);

	}

}
