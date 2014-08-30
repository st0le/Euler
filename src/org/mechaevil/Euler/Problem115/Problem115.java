/**
 * 
 */
package org.mechaevil.Euler.Problem115;

import java.util.HashMap;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem115 {
	public static HashMap<Integer, Long> table = new HashMap<Integer, Long>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int red = 50;
		int len;
		for(len = red + 1; ; len++ )
		{
			if(foo(red,len) > 1e6) break;
		}
		System.out.println("P115 : " + len);
		
		timer.stopTimer();
		System.out.println(timer);
	}
	

	private static long foo(int m,int n) {
		if(n < m) return 1;
		if(n == m) return 2;
		if(table.containsKey(n)) return table.get(n);
		long s = 1;
		for(int red = m; red <= n;red++)
		{
			for(int start = 0; start <= n-red;start++)
			{
				s+= foo(m,n - (red + start + 1));
			}
		}
		table.put(n,s);
		return s;
	}

}
