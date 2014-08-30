/**
 * 
 */
package org.mechaevil.Euler.Problem095;

import java.util.HashSet;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem095 {

	public static int[] sdiv = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 1000000;
		sdiv = xMath.sieveSumOfDivisors(N);
		for(int i = 0; i < N;i++)
			sdiv[i] -= i;
		
		int maxChainLen = 0;
		int minNum = 0;
		for(int i = 1 ; i < N;i++)
		{
			
			int chainLen = chainLength(i);
			if(maxChainLen < chainLen)
			{
				maxChainLen = chainLen;
				minNum = i;
			}
		}
		
		System.out.println("P095 : " + minNum);
		timer.stopTimer();
		System.out.println(timer);

	}

	private static int chainLength(int n) {
		// 
		int c = 0;
		int t = n;
		HashSet<Integer> set = new HashSet<Integer> ();
		
		do
		{
			if(n > 1000000 || set.contains(n)) break;
			set.add(n);
			n = sdiv[n];
			c++;
		}while(n != t);
		return (n == t)? c : 0;
	}

}
