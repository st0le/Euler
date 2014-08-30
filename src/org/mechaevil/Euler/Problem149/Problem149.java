/**
 * 
 */
package org.mechaevil.Euler.Problem149;

import java.math.BigInteger;
import java.util.Arrays;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Algorithms.xAlgorithm;

/**
 * @author 332609
 *
 */
public class Problem149 {

	final static int N = 2000;
	final static int MOD = 1000000;
	static int[] fib = new int[N*N + 1];
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		Arrays.fill(fib, -1);
		int[][] mtx = getLaggedFibonacci();
		int [] arr = null;
		int maxSum = 0;
		//horizontal
		for(int row = 0; row < mtx.length; row++)
		{
			arr = Arrays.copyOf(mtx[row], mtx[row].length);
			maxSum = Math.max(maxSum,xAlgorithm.getMaximumSubSequence(arr));
		}
		//vertical
		arr = new int[mtx[0].length];
		for(int col = 0; col < mtx[0].length; col++)
		{
			for(int row = 0; row < mtx.length; row++)
				arr[row] = mtx[row][col];
			maxSum = Math.max(maxSum,xAlgorithm.getMaximumSubSequence(arr));
		}
		//diag-1
		arr = new int[mtx[0].length];
		for(int col = 0; col < mtx[0].length; col++)
		{
			int row;
			for(row = 0; row < mtx.length && col+row < mtx[0].length; row++)
				arr[row] = mtx[row][col+row];
			//xDebug.display1D(arr,mtx[0].length - col);
			maxSum = Math.max(maxSum,xAlgorithm.getMaximumSubSequence(arr,mtx[0].length - col));
		}
		//diag-2
		for(int row = 1; row < mtx.length; row++)
		{
			int col;
			for(col = 0 ; col+row < mtx[0].length; col++)
				arr[col] = mtx[row+col][col];
			//xDebug.display1D(arr,mtx[0].length - row);
			maxSum = Math.max(maxSum,xAlgorithm.getMaximumSubSequence(arr,mtx[0].length - row));
		}		
		//antidiag-1
		for(int row = 0; row < mtx.length; row++)
		{
			for(int col = 0 ; col <= row; col++)
				arr[col] = mtx[row-col][col];
			//xDebug.display1D(arr,row + 1);
			maxSum = Math.max(maxSum,xAlgorithm.getMaximumSubSequence(arr,row+1));
		}
		
		//anti-diag-2
		arr = new int[mtx[0].length];
		for(int col = 1; col < mtx[0].length; col++)
		{
			int row = mtx.length - 1;
			for(int k = 0; row >= 0 && k + col < mtx[0].length; k++,row--)
			{
				arr[k] = mtx[row][k+col];
			}
			//xDebug.display1D(arr,mtx[0].length - col);
			maxSum = Math.max(maxSum,xAlgorithm.getMaximumSubSequence(arr,mtx[0].length - col));
		}
		System.out.println("P149 : " + maxSum);
		timer.stopTimer();
		System.out.println(timer);
	}

	private static int[][] getLaggedFibonacci() {
		// 
		int[][]ret = new int[N][N];
		
		for(int k = 0; k < N*N; k++)
		{
			int x = k / N;
			int y = k % N;
			ret[x][y] = fib(k+1); 
		}
		return ret;
	}
	
	private static int fib(int k)
	{
		if(fib[k] == -1)
		{
			if( k >= 1 && k <= 55)
			{
				BigInteger bigk =  BigInteger.valueOf(k);
				BigInteger r = BigInteger.valueOf(100003);
				r = r.subtract(BigInteger.valueOf(200003).multiply(bigk));
				r = r.add(BigInteger.valueOf(300007).multiply(bigk.pow(3)));
				r = r.mod(BigInteger.valueOf(MOD));
				fib[k] = r.intValue() - 500000;
			}else
			{
				
				BigInteger r = BigInteger.valueOf(fib[k-24]);
				r = r.add(BigInteger.valueOf(fib[k-55]));
				r = r.add(BigInteger.valueOf(1000000));
				r = r.mod(BigInteger.valueOf(MOD));
				fib[k] = r.intValue() - 500000;
			}
		}
		return fib[k];
	}
}
