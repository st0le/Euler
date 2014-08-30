/**
 * 
 */
package org.mechaevil.Euler.Problem014;

import java.util.ArrayList;
import java.util.HashMap;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem014 {

	private static HashMap<Long, Long> table = new HashMap<Long, Long>();

	public static long cycle3(long n) //Iterative + (Memoization) + More Memory.
	{
		ArrayList<Long> myStack = new ArrayList<Long>();
		long  c = 0;
		while(n != 1)
		{
			if(table.containsKey(new Long(n)))
			{
				c += table.get(n);
				break;
			}else
			{
				myStack.add(n);
				if(n % 2 == 0)
					n /= 2;
				else
					n = 3 * n  + 1;
				c++;
			}
		}
		int i = 0;
		while(i < myStack.size())
		{
			table.put(myStack.get(i),c-i);
			i++;
		}
			
		return c;
	}

	public static long cycle2(long n) //needs more stack...Recursive (Memoization)
	{
		if(table.containsKey(new Long(n)))
		{
			return table.get(n);
		}else
		{
			if(n % 2 == 0)
				table.put(n, 1 + cycle2(n / 2));
			else
				table.put(n, 1 + cycle2(3 * n + 1));

			return table.get(n);
		}
	}

	public static long cycle(long n) //Iterative (No Memoization) Slowest 
	{
		int c = 0;
		while (n != 1)
		{
			if ( n % 2 == 0)
				n /= 2;
			else
				n= 3*n + 1;
			c++;
		}
		return c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		long mx = 0,mxi = 1;
		table.put(1L, 0L);
		for(long i = 2; i < 1000000; i++)
		{
			long k = cycle(i);
			if(mx < k) 
			{
				mx = k;
				mxi  = i;
				//System.out.println("" + mx + " (" + mxi + ")");
			}
		}
		System.out.println("P014 : " + mx + " (" + mxi + ")");
		timer.stopTimer();
		System.out.println(timer);
	}
}
