package org.mechaevil.Euler.Problem187;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

public class Problem187 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		final int N = 100000000;
		final int sqroot = (int) Math.sqrt(N);
		int[]primes = new PrimeSieve(N/2).toPrimitiveArray();
		int c = 0;
		for(int i = 0 ; primes[i]< sqroot; i++)
		{
			for(int j = i; j < primes.length && primes[i]*primes[j]< N;j++,c++);
		}
		System.out.println("P187 : " + c);
		timer.stopTimer();
		System.out.println(timer);

	}

}
