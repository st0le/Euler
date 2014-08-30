/**
 * 
 */
package org.mechaevil.Euler.Problem058;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.xPrime;

/**
 * @author 332609
 *
 */
public class Problem058 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int primeCount = 0;
		int diagonalCount = 1;
		int n;
		for(n = 1;;n+=2,diagonalCount += 4)
		{
			for(int j = 1; j <= 3; j++)
				if(xPrime.isPrimeNaive(n*n - j*(n - 1))) primeCount ++;
			if (n>1 && (primeCount/(float)diagonalCount) < 0.1) break; 
		}
		System.out.println("P058 : " + n);
		timer.stopTimer();
		System.out.println(timer);
	}

}
