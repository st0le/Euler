/**
 * 
 */
package org.mechaevil.Euler.Problem139;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem139 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final long N = 100000000;
		final long rootN = (long)Math.sqrt(N/2);
		int count = 0;
		boolean done = false;
		for(long m = 1;!done && m < rootN; m++)
		{
			for(long n = (m%2)+1;!done && n < m; n+=2)
			{
				if(xMath.gcd(m, n) == 1)
				{
					long p = 2* m * (m+n);
					if(p < N)
					{
						long c = m*m + n*n;
						long b = m*m - n*n;
						long a = 2*m*n;
						if( (c % Math.abs(a-b)) == 0)
							count+= N/p;
					}
				}
			}
		}
		System.out.println("P139 : " + count);

		timer.stopTimer();
		System.out.println(timer);


	}

}
