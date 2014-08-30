/**
 * 
 */
package org.mechaevil.Euler.Problem011;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem011 implements Constants{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		//Build Grid...
		String[] lines = grid.split("\n");
		int[][] iGrid = new int[lines.length][];
		int col = 0;
		int row  = lines.length;
		for(int i = 0 ; i < lines.length; i++)
		{

			String line = lines[i];
			String[] nums = line.split(" ");
			col  = nums.length;
			iGrid[i] = new int[col];
			for(int j = 0 ; j < col; j++)
				iGrid[i][j] = Integer.parseInt(nums[j]);
		}

		int mx = 0;
		for(int i = 0 ; i+3 < row; i++)
		{
			for(int j = 0 ; j+3 < col; j++)
			{
				int s1 = iGrid[i][j] * iGrid[i][j+1] * iGrid[i][j+2] * iGrid[i][j+3]; 
				int s2 = iGrid[i][j] * iGrid[i+1][j] * iGrid[i+2][j] * iGrid[i+3][j];
				int s3 = iGrid[i][j] * iGrid[i+1][j+1] * iGrid[i+2][j+2] * iGrid[i+3][j+3];
				int s4 = (i-3 >= 0)? (iGrid[i][j] * iGrid[i-1][j+1] * iGrid[i-2][j+2] * iGrid[i-3][j+3]): 0;
				mx = Math.max(mx, Math.max(Math.max(s1,s2), Math.max(s3,s4)));
			}
		}
		System.out.println("P011 : " + mx);
		timer.stopTimer();
		System.out.println(timer);


	}

}
