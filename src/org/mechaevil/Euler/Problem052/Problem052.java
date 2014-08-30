/**
 * 
 */
package org.mechaevil.Euler.Problem052;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem052 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		for(long i = 1; ; i++)
		{
			int j;
			for(j = 6; j>=2; j-- )
				if(!xMath.isPermutation(i, i*j))
					break;
			if(j == 1)
			{
				System.out.println("P052 : " + i);
				break;
			}
		}
		timer.stopTimer();
		System.out.println(timer);
	}

}
