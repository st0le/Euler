/**
 * 
 */
package org.mechaevil.Euler.Problem021;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;


/**
 * @author 332609
 *
 */
public class Problem021 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here

		final int N = 10000;
		int[] spdivs = new int[N];
		
		for(int i = 0 ; i < N;i++)
			spdivs[i] = xMath.sdiv(i)-i;
		
		long s = 0;
		for(int i = 0 ; i < N; i++)
			if(i < spdivs[i] && spdivs[i] < N && spdivs[spdivs[i]] == i)
			{
				s += i + spdivs[i];
			}
		System.out.println("P021 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);

	}

}
