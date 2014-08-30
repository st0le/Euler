/**
 * 
 */
package org.mechaevil.Euler.Problem039;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem039 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final int N = 1000;
		int [] p = new int[N + 1];

		for(int i = 1; i < N; i++)
			for(int j = 1; i+j<N; j++)
			{
				for(int k = 1; i+j+k<=N; k++)
				{
					if((i *i + j*j == k*k) || (i*i + k*k == j*j) || (j*j + k*k == i*i))
					{
						p[i+j+k]++;
					}
				}
			}
		int mxi = 0;
		for(int i= 0 ; i < N+1; i++)
		{
			if( p[mxi] < p[i])
			{
				mxi = i;
			}
		}
		System.out.println("P039 : " + mxi );

		timer.stopTimer();
		System.out.println(timer);


	}

}
