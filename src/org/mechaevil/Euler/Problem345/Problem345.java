package org.mechaevil.Euler.Problem345;

import org.mechaevil.util.StopWatch;

public class Problem345 {

	private static int[][] mtx = new int[][] {
			{ 7, 53, 183, 439, 863, 497, 383, 563, 79, 973, 287, 63, 343, 169,
					583, },
			{ 627, 343, 773, 959, 943, 767, 473, 103, 699, 303, 957, 703, 583,
					639, 913, },
			{ 447, 283, 463, 29, 23, 487, 463, 993, 119, 883, 327, 493, 423,
					159, 743, },
			{ 217, 623, 3, 399, 853, 407, 103, 983, 89, 463, 290, 516, 212,
					462, 350, },
			{ 960, 376, 682, 962, 300, 780, 486, 502, 912, 800, 250, 346, 172,
					812, 350, },
			{ 870, 456, 192, 162, 593, 473, 915, 45, 989, 873, 823, 965, 425,
					329, 803, },
			{ 973, 965, 905, 919, 133, 673, 665, 235, 509, 613, 673, 815, 165,
					992, 326, },
			{ 322, 148, 972, 962, 286, 255, 941, 541, 265, 323, 925, 281, 601,
					95, 973, },
			{ 445, 721, 11, 525, 473, 65, 511, 164, 138, 672, 18, 428, 154,
					448, 848, },
			{ 414, 456, 310, 312, 798, 104, 566, 520, 302, 248, 694, 976, 430,
					392, 198, },
			{ 184, 829, 373, 181, 631, 101, 969, 613, 840, 740, 778, 458, 284,
					760, 390, },
			{ 821, 461, 843, 513, 17, 901, 711, 993, 293, 157, 274, 94, 192,
					156, 574, },
			{ 34, 124, 4, 878, 450, 476, 712, 914, 838, 669, 875, 299, 823,
					329, 699, },
			{ 815, 559, 813, 459, 522, 788, 168, 586, 966, 232, 308, 833, 251,
					631, 107, },
			{ 813, 883, 451, 509, 615, 77, 281, 613, 459, 205, 380, 274, 302,
					35, 805, }, };

	private static int maxSum = 0;
	private static int[] maxInRow;

	private static void go(int row, int sum, boolean[] cols) {
		if (row == mtx.length) {
			if (sum > maxSum) {
				maxSum = sum;
			}
		} else {
			if (maxInRow[row] + sum >= maxSum) {
				// so even if i used the best values
				// in the remaining rows, i can't
				// beat maxSum? so why bother right?
				for (int col = 0; col < mtx[0].length; col++) {
					if (!cols[col]) {
						cols[col] = true;
						go(row + 1, sum + mtx[row][col], cols);
						cols[col] = false;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// Your Code here...
		mtx = new int[][] { { 7, 53, 183, 439, 863 },
				{ 497, 383, 563, 79, 973 }, { 287, 63, 343, 169, 583 },
				{ 627, 343, 773, 959, 943 }, { 767, 473, 103, 699, 303 }, };

		maxInRow = new int[mtx.length];
		for (int r = 0; r < mtx.length; r++) {
			maxInRow[r] = mtx[r][0];
			for (int c = 1; c < mtx[0].length; c++) {
				if (maxInRow[r] < mtx[r][c])
					maxInRow[r] = mtx[r][c];
			}
		}
		for (int i = mtx.length - 2; i >= 0; i--) {
			maxInRow[i] += maxInRow[i + 1];
		}
		go(0, 0, new boolean[mtx[0].length]);
		System.out.println("P345: " + maxSum);

		timer.stopTimer();
		System.out.println(timer);
	}
}
