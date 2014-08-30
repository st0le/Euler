/**
 * 
 */
package org.mechaevil.Euler.Problem214;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem214 {

	static long[] phi = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final int N = 40000000;
		phi = xMath.sieveEulerTotientFunction(N);

		phi[0] = phi[1] = 1; 
		for( int i=2; i<N; i++ ){
			phi[i] = phi[(int) phi[i]]+1;
		}

		long s = 0 ;
		for(int n = 1; n < N;n++)
		{
			if(phi[n] == 25 && BigInteger.valueOf(n).isProbablePrime(3))
			{
				s+=n;
			}
		}
		System.out.println("P214 : " + s);

		timer.stopTimer();
		System.out.println(timer);
	}
}
