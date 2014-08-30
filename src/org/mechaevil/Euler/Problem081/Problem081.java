/**
 * 
 */
package org.mechaevil.Euler.Problem081;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem081 implements Constants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		String []rows = grid.split("\n");
		int[][]matrix = new int[rows.length][rows[0].split(",").length];
		int i = 0;
		for(String row : rows)
		{
			String[]cells = row.split(",");
			for(int j = 0; j < cells.length; j++)
				matrix[i][j] = Integer.parseInt(cells[j]);
			i++;
		}
		int r = matrix.length;
		int c = matrix[0].length;

		for(int r_i = c - 2; r_i >= 0;r_i--)
			matrix[r-1][r_i] += matrix[r-1][r_i+1];
		for(int c_i = r - 2; c_i >= 0;c_i--)
			matrix[c_i][c-1] += matrix[c_i+1][c-1];

		for(int p = r - 2; p >= 0; p --)
		{
			for(int q = c - 2; q>=0; q--)
			{
				matrix[p][q] += Math.min(matrix[p][q+1], matrix[p+1][q]);
			}
		}

		System.out.println("P081 : " + matrix[0][0]);

		timer.stopTimer();
		System.out.println(timer);
	}

}
