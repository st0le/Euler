/**
 * 
 */
package org.mechaevil.Euler.Problem122;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem122 {

	private static class MinMultiplier
	{
		private int minMul;
		private int[]history = null;
		public MinMultiplier(int n) {
			
			minMul = n;
			history = new int[n];
			findMin(n,1,0);
		}
		
		private void findMin(int n,int c,int level)
		{
			history[level] = c;
			if(level >= minMul) return;
			if(c == n)
			{
				minMul = Math.min(minMul, level);
			}else
				if( c < n)
				{
					for(int i = level; i >=0 ; i--)
						findMin(n, c + history[i], level + 1);
				}
		}

		public int getMinMul() {
			return minMul;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int s = 0;
		for(int i = 1; i <= 200; i++)
		{
			s += new MinMultiplier(i).getMinMul();
		}
		System.out.println("P122 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);
	}

}
