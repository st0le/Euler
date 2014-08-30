/**
 * 
 */
package org.mechaevil.Euler.Problem025;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem025 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
//		03 Sep 2005 08:58 pm  
//		ke9tv   (Tcl)   
//		 
//		Saying that a number contains 1000 digits is the same as 
//		saying that it's greater than 10**999. 
//
//		The nth Fibonacci number is [phi**n / sqrt(5)], where the 
//		brackets denote "nearest integer". 
//
//		So we need phi**n/sqrt(5) > 10**999 
//
//		n * log(phi) - log(5)/2 > 999 * log(10) 
//
//		n * log(phi) > 999 * log(10) + log(5)/2 
//		n > (999 * log(10) + log(5) / 2) / log(phi) 
//		 


		System.out.println("P025 : " + Math.ceil((999 * Math.log(10) + Math.log(5) / 2)
				/ Math.log(xMath.PHI)));
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
