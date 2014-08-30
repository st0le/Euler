/**
 * 
 */
package org.mechaevil.Euler.Problem116;

import java.util.HashMap;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem116 {

	public static HashMap<Integer, Long> table = new HashMap<Integer, Long>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int N = 50;
		table.clear();
		long s = foo(N,2);
		table.clear();
		s += foo(N,3);
		table.clear();
		s += foo(N,4);
		s -= 3;
		System.out.println("P116 : " + s);
		timer.stopTimer();
		System.out.println(timer);

	}
	private static long foo(int m, int n) {
		if(m < n)
			return 1;
		else
		{
			if(!table.containsKey(m))
			{
				long s = foo(m-1,n) + foo(m-n,n);
				table.put(m,s);
				return s;
			}
			return table.get(m) ;
		}
	}


	
}
