/**
 * 
 */
package org.mechaevil.Euler.Problem037;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem037 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 1000000;
		PrimeSieve table = new PrimeSieve(N);
		int s = 0; 
		for(int i= 11 ; i < N; i+=2)
		{
			if(isRightTruncatablePrime(table,i) && isLeftTruncatablePrime(table,i))
			{
				//System.out.println(i);
				s += i;
			}
		}
		System.out.println("P037 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);
	}

	private static boolean isLeftTruncatablePrime(PrimeSieve table, int n) {
		// 
		int p = 1;
		while(p*10 <= n) p*=10;
		while(n > 0)
		{
			if(!table.isPrime(n)) return false;
			n = n - p*(n/p);
			p/=10;
		}
		return true;
	}

	private static boolean isRightTruncatablePrime(PrimeSieve table, int n) {
		// 
		while(n > 0)
		{
			if(!table.isPrime(n)) return false;
			n /= 10;
		}
		return true;
	}

}
