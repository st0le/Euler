/**
 * 
 */
package org.mechaevil.Euler.Problem150;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem150 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args)  {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		final int N = 500500 ; // 1000 * 1001 / 2
		final int size = 1000;
		int [][] table = new int[size][size];
		int c = 0;
		int t = 0;

		int MOD = 1 << 20;
		int SUB = 1 << 19;
		for(int i = 0; c < N; i++)
		{

			for(int j = 0; j < i+1;j++,c++)
			{
				t  = (615949 * t) % MOD;
				t += 797807;
				t %= MOD;
				table[i][j] = t - SUB; 
			}
		}

		int [][] rollingSum = new int[size][size];

		for(int i = 0 ; i < size; i++)
			for(int j = 1; j < i+1; j++)
				rollingSum[i][j] += rollingSum[i][j-1] + table[i][j];

		//min
		int minSum = Integer.MAX_VALUE;
		for(int i = 0 ; i < size; i++)
		{
			for(int j = 0; j < i+1; j++)
			{
				int s = 0;
				for(int k = i ; k < size;k++)
				{
					s += rollingSum[k][j+ (k-i)] - rollingSum[k][j] + table[k][j];
					if( s < minSum) minSum = s;
				}
			}
		}
		System.out.println("P150 : " + minSum);

		timer.stopTimer();
		System.out.println(timer);
	}

}
