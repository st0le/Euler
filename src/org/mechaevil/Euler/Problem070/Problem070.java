/**
 * 
 */
package org.mechaevil.Euler.Problem070;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem070 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		//Borrowed From P069
		//Sieve the Totient Function (phi(n))
		final int N = 10000000;
		double minRatio = 10000.0; //high enough
		int minN = 0;
		int[] phi = new int[N + 1];
		int i;
		for( i = 2 ; i <= N ; ++i ) 
			phi[i] = i - 1;
		
		for( i = 2 ; i <= N ; ++i )
		{
			if( phi[i] == i - 1 ) //prime...
				for(int j = N / i ; j >= 2 ; --j ) 
					phi[i * j] -= phi[j];
			
			if(minRatio > (i/(double)phi[i]) && xMath.isPermutation(i, phi[i]))
			{
				minRatio = (i/(double)phi[i]);
				minN = i;
			}
		}
		System.out.println("P070 : " + minN);
		
		timer.stopTimer();
		System.out.println(timer);
	}

}
