package org.mechaevil.Euler.Problem188;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

public class Problem188 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		
		final int MOD = 100000000;
		System.out.println("P188 : " + pow(1777, 1855,MOD));
		
		timer.stopTimer();
		System.out.println(timer);
	}

	private static long  pow(long a, long b,int MOD) {
		if(b == 1)
			return  (a % MOD);
		else
			return xMath.powMod(a,pow(a,b-1,MOD),MOD);
	}
}
