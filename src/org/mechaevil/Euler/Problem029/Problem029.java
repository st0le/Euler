/**
 * 
 */
package org.mechaevil.Euler.Problem029;

import java.util.HashSet;
import java.util.Set;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem029 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		Set<Double> terms = new HashSet<Double>();
		for(int a = 2; a <= 100; a++){
			for(int b = 2; b <= 100; b++){
				terms.add(Math.pow(a, b));
			}
		}		
		System.out.println("P029 : " + terms.size());

		
		timer.stopTimer();
		System.out.println(timer);


	}

}
