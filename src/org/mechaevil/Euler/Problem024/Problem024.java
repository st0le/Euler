/**
 * 
 */
package org.mechaevil.Euler.Problem024;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Algorithms.xAlgorithm;

/**
 * @author 332609
 *
 */
public class Problem024 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here

		Integer[] arr = {0,1,2,3,4,5,6,7,8,9};
		int c = 1;
		do
		{
			if(!(c < 1000000 )) break;
			c++;
		}while(xAlgorithm.nextPermutation(arr));
		System.out.print("P024 : ");
		for(Integer i:arr)
			System.out.print("" + i);
		System.out.println();
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
