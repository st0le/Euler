/**
 * 
 */
package org.mechaevil.Euler.Problem075;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem075 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 1500000;
		int[] t = new int[N + 1];
		for(int n = 2; n < 1000; n++)
		{
			for(int m = 1 + (n % 2); m < n; m+=2)
			{
				if(xMath.gcd(m, n) != 1) continue;
				//a+b+c = 2n(m+n)
				int p = 2*n*(m+n);
				int s = p;
				while(s < t.length)
				{
					t[s] ++;
					s += p;
				}
			}
		}
		int c = 0;
		for(int i = 0; i < t.length; i+=2) //Perimeters are Even
			if(t[i] == 1)
				c++;
		System.out.println("P075 : " +c);
		timer.stopTimer();
		System.out.println(timer);
	}

}
