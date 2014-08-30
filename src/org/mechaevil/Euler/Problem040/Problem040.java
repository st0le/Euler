/**
 * 
 */
package org.mechaevil.Euler.Problem040;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem040 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		StringBuilder s = new StringBuilder();
		int i = 1;
		while(s.length() < 1000000){
			s.append(i);
			i++;
		}
		int ans = 1;
		for(i = 1; i <= 1000000; i*=10)
			ans *= s.charAt(i-1) - '0';
		System.out.println("P040 : " + ans);
		
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
