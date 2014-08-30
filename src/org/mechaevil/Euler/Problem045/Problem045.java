/**
 * 
 */
package org.mechaevil.Euler.Problem045;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem045 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		
		//Second Number that is a Triangle,Pentagonal,Hexagonal...
		// All Hexagonal Numbers are Triangle numbers.
		int hn;
		for(hn = 144; !xMath.isPentagonalNumber(xMath.getHexagonalNumber(hn));hn++);
		System.out.println("P045 : " + xMath.getHexagonalNumber(hn));
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
