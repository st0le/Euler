/**
 * 
 */
package org.mechaevil.Euler.Problem087;

import java.util.ArrayList;
import java.util.BitSet;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem087 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final int N = 50000000;
		int max = (int)Math.sqrt(N - 2*2*2*2 - 2*2*2) + 1;
		PrimeSieve table = new PrimeSieve(max);
		ArrayList<Integer> primes = table.toArray();

		BitSet used = new BitSet(N);
		for(int a:primes)
		{
			int a2 = a * a;
			for(int b:primes)
			{
				int b3 = b * b * b;
				if(a2 + b3 > N) break;
				for(int c:primes)
				{
					if(a2 + b3 + c*c*c*c > N) break;
					used.set(a2+b3+c*c*c*c);
				}
			}
		}
		
		System.out.println("P087 : " + used.cardinality());
		timer.stopTimer();
		System.out.println(timer);
	}

}
