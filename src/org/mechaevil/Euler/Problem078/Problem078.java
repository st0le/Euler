/**
 * 
 */
package org.mechaevil.Euler.Problem078;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem078 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 1000000;
		
		//slightly modified version of Pentagonal Theorem (xMath.integerPartition() )
		long[] arr = new long[N + 1];
		arr[0] = 1;
		int i;
		for( i = 1;  i <=  N; i++)
		{
			int sign = 1;
			arr[i]  = 0;
			for(int j = 1; j <= N; j++)
			{
				int fx = j * (3*j - 1) / 2;
				if( fx > i) break;
				arr[i] = arr[i] + sign * arr[i-fx];
				arr[i] %= N;
				fx = j * (3*j + 1) / 2;
				if( fx > i) break;
				arr[i] = arr[i] + sign * arr[i-fx];
				arr[i] %= N;
				sign = -sign; 
			}
			if(arr[i] == 0)
				break;
		}
		System.out.println("P078 : " + i);
		timer.stopTimer();
		System.out.println(timer);
	}
	

}
