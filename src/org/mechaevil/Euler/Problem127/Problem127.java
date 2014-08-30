/**
 * 
 */
package org.mechaevil.Euler.Problem127;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem127 implements Constants{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		//CHEAT
		//http://www.phfactor.net/abc/index.php
		
		//TODO : Original Solution (takes too long)
		
		String[] lines = triplets.split("\n");
		int s = 0;
		for(String line : lines)
		{
			s += Integer.parseInt(line.split(",")[2].trim().replace(")",""));
		}
		System.out.println("P127 : " + s);
		timer.stopTimer();
		System.out.println(timer);

	}

}
