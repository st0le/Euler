/**
 * 
 */
package org.mechaevil.Euler.Problem186;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Algorithms.UnionFind;

/**
 * @author 332609
 * 
 */
public class Problem186 {

	public static int f1(long k) {
		BigInteger bigK = BigInteger.valueOf(k);
		return BigInteger.valueOf(100003)
				.subtract(BigInteger.valueOf(200003).multiply(bigK))
				.add(bigK.pow(3).multiply(BigInteger.valueOf(300007)))
				.mod(BigInteger.valueOf(1000000)).intValue();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// Your Code here...
		final int N = 1000000;
		LinkedList<Integer> fib55 = new LinkedList<Integer>();
		UnionFind uf = new UnionFind(N);
		final int PM = 524287;
		for (int k = 1; k <= 55; k++)
		{
			fib55.add(f1(k));
		}
		Iterator<Integer> iterator = fib55.iterator();
		Integer previous = iterator.next();
		while(iterator.hasNext())
		{
			Integer current = iterator.next();
			uf.union(previous, current);
			previous = current;
		}
		
		


		timer.stopTimer();
		System.out.println(timer.getElapsedTimeInMillis() + "ms");
	}

}
