/**
 * 
 */
package org.mechaevil.Euler.Problem026;

import java.util.ArrayList;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem026 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		
		PrimeSieve table = new PrimeSieve(1000);
		ArrayList<Integer> primes = table.toArray();
		Integer max,maxi;
		max = 1;
		maxi = 1;
		for(Integer i : primes)
		{
			int k = cycleLength(i);
			if( k > max)
			{
				max = k ;
				maxi = i;
			}
		}
		System.out.println("P026 : " +  maxi + "\t Cycle Lenght : " + max );
		timer.stopTimer();
		System.out.println(timer);

	}

	private static int cycleLength(Integer i) {
		// 
		ArrayList<Integer> remList = new ArrayList<Integer>();
		int num = 10;
		int c  = 0;
		while(!remList.contains(new Integer(num % i)))
		{
			c++;
			remList.add(num % i);
			num = (num * 10) % i;
		}
		return c - remList.lastIndexOf(num);
	}

}
