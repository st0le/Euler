/**
 * 
 */
package org.mechaevil.Euler.Problem108;

import java.util.ArrayList;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem108 {
	
	public static ArrayList<Integer> primes = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve table  = new PrimeSieve(200000);
		primes = table.toArray();
		long n = 0;
		for(n = 5; ; n++)
		{
			if((ndiv(n*n)+1)/2 >= 1000)
				break;
		}
		System.out.println("P108 : " + n);
		timer.stopTimer();
		System.out.println(timer);
 	}

	private static int ndiv(long n) {
		int i = 0;
		int c = 1;
		while(n > 1 && i < primes.size())
		{
			int p = 0;
			int prime = primes.get(i);
			while(n % prime == 0)
			{
				n /= prime;
				p++;
			}
			c *= (p + 1);
			i++;
		}
		if(i >= primes.size())
			System.out.println("over" + i);
		return c;
	}
	
}
