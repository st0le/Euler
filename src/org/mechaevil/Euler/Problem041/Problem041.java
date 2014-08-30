/**
 * 
 */
package org.mechaevil.Euler.Problem041;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Algorithms.xAlgorithm;
import org.mechaevil.util.PrimeFactory.xPrime;

/**
 * @author 332609
 *
 */
public class Problem041 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int[] validNs = new int[] {4,7};
		//Valid n-Pandigital Number which can be Prime..
		//There's no 1 digit Pandigital Prime
		//There's no 2 digit Pandigital Prime (12,21)
		//There's no 3 digit Pandigital Prime {1 + 2 + 3 = 6} hence the number is divisible by 3
		//There's no 5 digit Pandigital Prime {1 + 2 + 3 + 4 + 5 = 15} hence the number is divisible by 3
		//There's no 6 digit Pandigital Prime {1 + ... + 6 = 21} hence the number is divisible by 3
		//There's no 8 digit Pandigital Prime {1 + ... + 8 = 36} hence the number is divisible by 3
		//There's no 9 digit Pandigital Prime {1 + ... + 9 = 45} hence the number is divisible by 3
		
		int mx = 0;
		for(int i = 0; i < validNs.length; i++)
		{
			Integer []arr = new Integer[validNs[i]];
			for(int j =0; j < validNs[i]; j++) arr[j] = j + 1;
			do
			{
				int n = 0;
				for(int j = 0 ; j < arr.length; j++)
					n = n * 10 + arr[j];

				if(xPrime.isPrimeNaive(n))
					mx = n;
			}while(xAlgorithm.nextPermutation(arr));
		}
		System.out.println("P041 : " + mx);
		timer.stopTimer();
		System.out.println(timer);
	}

}
