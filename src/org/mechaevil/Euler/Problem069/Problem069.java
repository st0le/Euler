/**
 * 
 */
package org.mechaevil.Euler.Problem069;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem069 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		
		//Sieve the Totient Function (phi(n))
		final int N = 1000000;
		double maxRatio = 0.0;
		int maxN = 0;
		int[] phi = new int[N + 1];
		int i;
		for( i = 2 ; i <= N ; ++i ) 
			phi[i] = i - 1;
		
		for( i = 2 ; i <= N ; ++i )
		{
			if( phi[i] == i - 1 ) //prime...
				for(int j = N / i ; j >= 2 ; --j ) 
					phi[i * j] -= phi[j];
			
			if(maxRatio < (i/(double)phi[i]))
			{
				maxRatio = (i/(double)phi[i]);
				maxN = i;
			}
		}

		System.out.println("P069 : " + maxN);
		timer.stopTimer();
		System.out.println(timer);


	}

}
