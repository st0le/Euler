/**
 * 
 */
package org.mechaevil.Euler.Problem053;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem053 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int c = 0;
		int maxLimit = 100;
		int maxValue = 1000000;
		int[][] table = new int[maxLimit+1][];
		table[0] = new int[1];
		table[0][0] = 1;
		for (int i = 1; i <= maxLimit; i++) {
			table[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0)
					table[i][j] = 1;
				else
					table[i][j] = Math.min(table[i - 1][j] + table[i - 1][j - 1],maxValue + 1);
				
				if(table[i][j] > maxValue) c++;
			}
		}
		System.out.println("P053 : " + c);
		timer.stopTimer();
		System.out.println(timer);
	}

}
