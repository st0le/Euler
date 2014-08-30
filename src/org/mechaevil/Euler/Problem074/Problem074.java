/**
 * 
 */
package org.mechaevil.Euler.Problem074;

import java.util.HashMap;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem074 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here 
		// 12Secs (Could be Faster?)
		final int N = 1000000;
		long[] arr = new long[N];
		for(int i = 0 ; i < N; i++) 
		{
			arr[i] = digitorial(i);
		}
		int c = 0;
		for(int i = 0 ; i < N; i++)
		{
			if(chainLength(arr,i) == 60)
				c++;			
		}
		System.out.println("P074 : " + c);
		timer.stopTimer();
		System.out.println(timer);
	}
	
	private static long digitorial(long i) {
		// 
		long ret = 0;
		while( i > 0)
		{
			ret += xMath.factorial((int) (i % 10));
			i /= 10;
		}
		return ret;
	}

	public static int chainLength(long[] arr,long n)
	{
		int c = 1;
		HashMap<Long,Integer> lst = new HashMap<Long,Integer>();
		lst.put(n,c);
		while( c <= 60)
		{
			n = (n < arr.length)? arr[(int) n]:digitorial(n);
			if(lst.containsKey(n)) return c;
			lst.put(n,c);
			c++;
		}
		return c;
	}
}
