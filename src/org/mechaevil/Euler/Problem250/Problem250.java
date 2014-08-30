/**
 * 
 */
package org.mechaevil.Euler.Problem250;

import java.util.Arrays;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem250 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 250250;
		final int NUM = 250;
		final long MOD = (long) 1e16; 
		long[] x = new long[NUM];
		long[] y = new long[NUM];
		Arrays.fill(x, 0L);
		for(int i = 1; i <= N; i++)
		{
			int m = xMath.powMod(i, i, NUM);
			for(int j = 0; j < NUM; j++)
			{
				int next = (m + j);
				if(next >= NUM) next -= NUM;
				y[next] = y[next] + x[j];
				if(y [next] >= MOD) y[next] -= MOD;
			}
			y [m] ++;
			if( y [m] >= MOD ) y[m] =- MOD;
			for(int j = 0 ; j < 250; j++)
			{
				x[j] = y[j];
			}
		}
		System.out.println("P250 : " + x[0]);
		
		
		timer.stopTimer();
		System.out.println(timer);

	}

}
