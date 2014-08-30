/**
 * 
 */
package org.mechaevil.Euler.Problem015;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem015 {

	
	public static void displayMtx(long[][] grid)
	{
		for(int i = 0 ; i < grid.length; i++)
		{
			for(int j =0 ; j < grid[i].length; j++)
				System.out.print(grid[i][j] + "   ");
			System.out.println();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int n  = 21;
		long [][] grid = new long[n][n];
		for(int i = 0 ; i < n; i++)
				grid[i][0] = grid[0][i] = 1;
		
		for(int i = 1 ; i < n; i++)
			for(int j = 1 ; j < n; j++)
			{
					grid[i][j] = grid[i-1][j] +  grid[i][j-1];
			}
		//displayMtx(grid);
		System.out.println("P015 : " + grid[n-1][n-1]);
		timer.stopTimer();
		System.out.println(timer);

	}

}
