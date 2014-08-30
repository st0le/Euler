package org.mechaevil.Euler.Problem146;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem146 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		//Voilates 1 Minute rule...11 minutes.
		int[]d = new int[]{1,3,7,9,13,27};
		int[]d2 = new int[]{11,17,19,21,23};
		 
		int i;
		long s = 0;
		for(long n = 0; n < 150e6; n+=10)
		{
			long  n2 = n*n;
			boolean allPrimes = true;
			
			for(i = 0; i < d.length; i++)
				if( !BigInteger.valueOf(n2+d[i]).isProbablePrime(3))
				{
					allPrimes = false;
					break;	
				}
			if(allPrimes)
			{
				boolean allOthersNotPrimes = true;
				for(i = 0; i < d2.length; i++)
					if( BigInteger.valueOf(n2+d2[i]).isProbablePrime(3))
					{
						allOthersNotPrimes = false;
						break;
					}
				if(allOthersNotPrimes)
					s += n;
			}
		}
		System.out.println("P146 : " + s);
		timer.stopTimer();
		System.out.println(timer);
	
	}

}
