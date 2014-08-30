/**
 * 
 */
package org.mechaevil.Euler.Problem114;

import java.util.HashMap;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem114_2 {

	public static HashMap<Integer, Long> table = new HashMap<Integer, Long>(); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		System.out.println("P114 : " + foo(50));

		timer.stopTimer();
		System.out.println(timer);

	}

	private static long foo(int n) {
		if(n < 3) return 1;
		if(n == 3) return 2;
		if(table.containsKey(n)) return table.get(n);
		long s = 1;
		for(int red = 3; red <= n;red++)
		{
			for(int start = 0; start <= n-red;start++)
			{
				s+= foo(n - (red + start + 1));
			}
		}
		table.put(n,s);
		return s;
	}
}
