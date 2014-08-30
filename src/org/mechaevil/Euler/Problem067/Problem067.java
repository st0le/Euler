/**
 * 
 */
package org.mechaevil.Euler.Problem067;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 * 
 */
public class Problem067 implements Constants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();

		// ... your Code here
		String[] lines = grid.split("\n");
		int[][] iGrid = new int[lines.length][];
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String[] nums = line.split(" ");
			iGrid[i] = new int[nums.length];
			for (int j = 0; j < nums.length; j++) {
				String num = nums[j];
				iGrid[i][j] = Integer.parseInt(num);
			}
		}

		for (int i = iGrid.length - 2; i >= 0; i--) {
			for (int j = 0; j < iGrid[i].length; j++) {
				iGrid[i][j] += Math.max(iGrid[i + 1][j], iGrid[i + 1][j + 1]);
			}
		}
		System.out.println("P067 : " + iGrid[0][0]);
		timer.stopTimer();
		System.out.println(timer);

	}

}
