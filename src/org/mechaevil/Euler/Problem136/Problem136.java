/**
 * 
 */
package org.mechaevil.Euler.Problem136;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem136 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		
		//Noticed the Pattern euler discovered...
		// 'n' with one solution are of 3 forms
		//1) Primes of form p = 3 (mod 4)
		//2) 4 * p (p = prime)
		//3) 16 * p (p = prime)
		//Special Case : 4,16 (1 is not prime)

		final int N = 50000000;
		int c  = 2;
		PrimeSieve t = new PrimeSieve(N);
		for(int p = 3 ; p < N; p+=4)
			if(t.isPrime(p))
				c++;
		for(int p = 3 ; p < N / 4; p+=2)
			if(t.isPrime(p))
				c++;
		for(int p = 3 ; p < N / 16; p+=2)
			if(t.isPrime(p))
				c++;
		
		System.out.println("P136 : " + c);
		timer.stopTimer();
		System.out.println(timer);


	}

}
