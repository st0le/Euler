package org.mechaevil.Euler.Problem293;

import java.math.BigInteger;
import java.util.HashSet;

import org.mechaevil.util.StopWatch;

public class Problem293 {


	final static long MAX = 1000000000L;
	static int[] primes = new int[]{2,3,5,7,11,13,17,19,23}; //product exceeds 10^9
	static HashSet<Integer> set = new HashSet<Integer>();
	static int s = 0;

	static public void DFS(int prime_i,long prod)
	{
		if(prime_i < primes.length && prod < MAX)
		{
			Integer M = (int) (BigInteger.valueOf(prod+1).nextProbablePrime().longValue() - prod); 
			if(!set.contains(M))
			{
				s += M;
				set.add(M);
			}
			while(prod * primes[prime_i] < MAX)
			{
				prod *= primes[prime_i];
				DFS(prime_i+1,prod);
			}
		}
	}
	

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// ... your Code here
		DFS(0,2);
		System.out.println("P293 : " + s);

		timer.stopTimer();
		System.out.println(timer);
	}
}
