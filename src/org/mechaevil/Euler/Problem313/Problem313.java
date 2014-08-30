package org.mechaevil.Euler.Problem313;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

public class Problem313 {
	public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		
		//My Slow Code (runs well above 1 min) :(
//		int[] primes = new PrimeSieve(1000000).toPrimitiveArray();
//		long[] primes2 = new long[primes.length];
//		for (int i = 0; i < primes.length; i++)
//			primes2[i] = (long)primes[i] * primes[i];
//		long s = 2;
//		long start = 21;
//		int pos = 1;
//		for (; start < primes2[primes2.length - 1]; start += 24) {
//			if(primes2[pos] < start) pos++;
//			s += 2*(primes2.length - pos);
//			//System.out.println(start + " : " + (primes2.length - pos) + " : " + s);
//			
//		}
		final int N = 1000000;
		int[] primes = new PrimeSieve(N).toPrimitiveArray();
		long s = 2;
		for(int i = 0; i < primes.length; i++)
			s += ((long)primes[i] * primes[i]) / 12;
		System.out.println("P313 : " + s);

		timer.stopTimer();
		System.out.println(timer);
	}
}
