/**
 * 
 */
package org.mechaevil.Euler.Problem125;

import java.util.HashSet;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem125 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		HashSet<Long> table = new HashSet<Long>();
		long sum,i;
		final long N = (long) 1e8;
		for(i = 1; i < N; i++ )
		{
			sum = i*i + (i+1)*(i+1);
			long j = i + 2;
			while(sum < N)
			{
				table.add(sum);
				sum += j*j;
				j++;
			}
		}
		sum = 0;
		for(Long p:table)
		{
			if(xMath.isPalindrome(p))
				sum += p;
		}
		System.out.println("P125 : " + sum);
		timer.stopTimer();
		System.out.println(timer);
	}

}
