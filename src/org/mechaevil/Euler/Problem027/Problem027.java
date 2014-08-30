/**
 * 
 */
package org.mechaevil.Euler.Problem027;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.PrimeFactory.xPrime;

/**
 * @author 332609
 *
 */
public class Problem027 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		long max,maxa,maxb;
		max = maxa = maxb = 0; 
		for(int a = - 1000; a <= 1000; a++)
			for(int b = -1000; b <= 1000; b++)
			{
				long k = primeLength(a,b);
				if(k > max)
				{
					max = k;
					maxa = a;
					maxb = b;
				}
			}
				
		System.out.println("P027 : " + (maxa * maxb));
		timer.stopTimer();
		System.out.println(timer);
	}

	private static long primeLength(int a, int b) {
		// 
		long n = 0;
		while(xPrime.isPrimeNaive((long) xMath.solvePolynomial(new double[]{b,a,1}, n)))
			n++;
		return n;
	}

}
