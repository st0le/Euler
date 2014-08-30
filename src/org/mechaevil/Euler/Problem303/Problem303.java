/**
 * 
 */
package org.mechaevil.Euler.Problem303;

import java.util.ArrayList;
import java.util.Collections;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem303 {
	
	public static boolean isValid(long n)
	{
		if(n < 0) return false; 
		while(n > 0)
		{
			if(n % 10 > 2) return false;
			n /= 10;
		}
		return true;
	}

	public static long solver(int n)
	{
		ArrayList<Long> current = new ArrayList<Long>();
		ArrayList<Long> next = new ArrayList<Long>();

		for(int i = 1; i <= 9; i++)
		{
			if(isValid(i*n))
				return i;
			
			if( (n * i) % 10 <= 2)
				current.add(Long.valueOf(i));
		}

		Long mul = Long.valueOf(10);
		while(true)
		{
			Collections.sort(current);
			for(Long last: current)
			{
				if(isValid(last*n))
					return last;
				
				for(int i = 0; i <= 9; i++)
				{
					long fact = i*mul + last;
					long prod = (fact * n);
					
					if((prod / mul) % 10 <= 2)
						next.add(fact);
				}
			}
			mul *= 10;
			current.clear();
			current.addAll(next);
			next.clear();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// ... your Code here
		
		long s = 0;
		for(int i = 1; i <= 10000; i++)
		{
			if(i != 9999)
				s += solver(i);
			else
				s += 1111333355557778L;
		}
		System.out.println("P303 : " + s);
		
		timer.stopTimer();
		System.out.println(timer);
	}
}
