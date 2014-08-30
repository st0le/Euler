/**
 * 
 */
package org.mechaevil.Euler.Problem043;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Algorithms.xAlgorithm;

/**
 * @author 332609
 *
 */
public class Problem043 {

	public static int[] getMultiples(int factor , int limit)
	{
		int[] arr = new int[limit/factor + 1];
		int f  = factor, c = 0;
		while(f < limit)
		{
			arr[c++] = f;
			f += factor;
		}
		return arr;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		long s = 0;
		Integer[] digits = {0,1,2,3,4,5,6,7,8,9};
		int[] primes = {17,13,11,7,5,3,2};
		do
		{
			long n = 0,t;
			for(int i = 0 ; i < digits.length; i++)
				n = n * 10 + digits[i];
			t = n;
			boolean valid = true;
			for(int i = 0; i < primes.length; i++, n/=10)
				if( (n % 1000) % primes[i] != 0 )
				{
					valid = false;
					break;
				}
			if(valid ) s+=t;
		}while(xAlgorithm.nextPermutation(digits));
		
		System.out.println("P043 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);
//		}

	}

}
