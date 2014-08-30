/**
 * 
 */
package org.mechaevil.Euler.Problem096;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Misc.SudokuSolver;

/**
 * @author 332609
 *
 */
public class Problem096 implements Constants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		String[] lines = sudokus.split("\n");
		int [][] mat = new int[9][9];
		int s = 0;
		for(int i = 0; i < lines.length; i+= 10)
		{
			for(int j = 0; j < 9; j++)
			{
				for(int k = 0 ; k < 9; k++)
				{
					mat[j][k] = lines[i+j+1].charAt(k) - '0';
				}
			}
			SudokuSolver.solvePuzzle9(mat);
			s += mat[0][0] * 100 + mat[0][1] * 10 + mat[0][2];
		}
		System.out.println("P096 : " + s);
		timer.stopTimer();
		System.out.println(timer);
	}

}


