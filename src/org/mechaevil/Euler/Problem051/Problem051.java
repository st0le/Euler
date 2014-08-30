/**
 * 
 */
package org.mechaevil.Euler.Problem051;

import java.util.ArrayList;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem051 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		PrimeSieve table = new PrimeSieve();
		ArrayList<Integer> primes = table.toArray();
		int[] digits = {0,1,2,3,4,5,6,7,8,9};
		
		int c = 0;
		boolean found = false;
		for(Integer prime : primes)
		{
			if(prime < 56000) continue;
			if(found ) break;
			for(int oldDigit: digits)
			{
				c = 0;
				if(found ) break;
				if(prime.toString().indexOf("" + oldDigit) != -1)
				{
					for(int newDigit : digits)
					{
						if(found ) break;
						if(newDigit == oldDigit || newDigit == 0) continue;
						int newNum = replaceDigits(prime, oldDigit, newDigit);
						if(table.isPrime(newNum ))
						{
							c++;
							if(c >= 7)
							{
								found = true;
								System.out.println("P051 : "  + prime);
							}
						}
					}
				}
			}
		}
		timer.stopTimer();
		System.out.println(timer);
	}

	private static int replaceDigits(Integer prime, int digit, int newDigit) {
		// 
		int ret = 0;
		int p = 1;
		while(prime > 0)
		{
			int d = prime % 10 ;
			if( d == digit)
				d = newDigit;
			ret += p * d;
			prime /=10;
			p *= 10;
		}
		return ret;
	}

}
