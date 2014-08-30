/**
 * 
 */
package org.mechaevil.Euler.Problem203;

import java.util.HashSet;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Sequence.xPascalTriangle;

/**
 * @author 332609
 *
 */
public class Problem203 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 51; 
		xPascalTriangle tr = new xPascalTriangle(N);
		HashSet<Long> set = new HashSet<Long > ();
		long s = 0;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0;j <= i/2; j++) // only half, the rest are duplicates anyway...
			{
				Long l = tr.getBinomialCoefficient(i,j);
				if(!set.contains(l) &&  squareFree(l))
				{
					s += l;
					set.add(l);
				}
			}
		}
		System.out.println("P203 : " + s);
		timer.stopTimer();
		System.out.println(timer);
	}

	//if a square number divides bcof, then a square of its Prime factor divides it aswell... 
	//Using Primes, it takes longer since the sieve is huge.
	private static boolean squareFree(long bcof) {
		for(long i = 2; i*i <= bcof ; i++)
			if(bcof % (i*i) == 0)
				return false;
		return true;
	}
}
