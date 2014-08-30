/**
 * 
 */
package org.mechaevil.Euler.Problem047;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem047_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final int N = 1000000;
		int[] nums = new int[N];

		//Go Go Sieve ;)
		for(int i = 2; i*i < N; i++)
			if(nums[i] == 0)
				for(int f = 2*i; f < N; f+=i)
					nums[f]++;

		int i,c = 0;
		for( i = 0 ; i < N && c < 4; i++)
		{
			if(nums[i] == 4)
				c++;
			else
				c=0;
		}
		System.out.println("P047 : " + (i - 4));

		timer.stopTimer();
		System.out.println(timer);


	}

}
