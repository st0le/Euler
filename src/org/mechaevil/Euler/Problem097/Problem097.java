/**
 * 
 */
package org.mechaevil.Euler.Problem097;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem097 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		// 28433 * 2^7830457 + 1
		
		//Original Method 
//		final long MOD = 10000000000L;
//		long p = 1;
//		for(int n = 0; n < 7830457; n++)
//		{
//			p *= 2;
//			if(p > MOD) p %= MOD;
//		}
//		p = ((p * 28433) + 1) % MOD;
//		System.out.println("P097 : " + p);
		
		//Alternative ;)
		BigInteger a = new BigInteger("2"); 
		BigInteger mod = new BigInteger("10000000000"); 
		a = a.modPow(new BigInteger("7830457"),mod).multiply(new BigInteger("28433")).add(BigInteger.ONE).mod(mod); 
		System.out.println("P097 : " + a); 

		timer.stopTimer();
		System.out.println(timer);
	}

}
