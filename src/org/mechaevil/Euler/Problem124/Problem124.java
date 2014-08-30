/**
 * 
 */
package org.mechaevil.Euler.Problem124;

import java.util.Arrays;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem124 {
	
	private static class RadEntry implements Comparable<RadEntry>
	{
		public int n,rad;

		@Override
		public int compareTo(RadEntry arg0) {
			if(rad == arg0.rad) return n - arg0.n;
			return rad - arg0.rad;
		}
		@Override
		public String toString() {
			return n + "(" + rad + ")";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final int N = 100000 + 1;
		RadEntry[] radEntries = new RadEntry[N];
		for(int i = 0 ; i < N; i++)
		{
			radEntries[i] = new RadEntry();
			radEntries[i].n = i;
			radEntries[i].rad = 1;
		}
		PrimeSieve table = new PrimeSieve(N);
		for(int i = 2 ; i < table.getMaxLimit(); i++)
		{
			if(table.isPrime(i))
			{
				for(int factor = i; factor < N; factor += i)
					radEntries[factor].rad *= i;
			}
		}
		Arrays.sort(radEntries);
		System.out.println("P124 : " + radEntries[10000].n);



		timer.stopTimer();
		System.out.println(timer);
	}

}
