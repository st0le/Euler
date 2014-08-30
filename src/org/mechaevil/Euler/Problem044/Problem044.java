/**
 * 
 */
package org.mechaevil.Euler.Problem044;

import java.util.Arrays;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem044 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 2500;
		long [] pentagonal = new long [N];
		for(int n = 0 ; n < N; n++)
		{
			pentagonal[n] = n * (3*n - 1) / 2;
		}
		long mnD = Long.MAX_VALUE;
		for(int i = 1 ; i < N; i++)
		{
			for(int j = i + 1 ; j < N; j++)
			{
				if(
						(pentagonal[i] + pentagonal[j] < pentagonal[N-1]) &&
						( Arrays.binarySearch(pentagonal, pentagonal[i] + pentagonal[j]) >=0 ) &&
						( Arrays.binarySearch(pentagonal, pentagonal[j] - pentagonal[i]) >=0 ) 
						)
				{
					mnD = Math.min(mnD, Math.abs(pentagonal[j] - pentagonal[i]));
				}
			}
		}
		System.out.println("P044 : " + mnD);
		timer.stopTimer();
		System.out.println(timer);


	}

}
