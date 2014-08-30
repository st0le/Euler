/**
 * 
 */
package org.mechaevil.Euler.Problem033;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem033 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int a,b;
		int n,d;
		int pN = 1,pD = 1;
		for(a = 10; a < 100; a++)
		{
			if(a  % 10 == 0 ) continue;
			for(b = a+1; b < 100; b++)
			{
				if(b  % 10 == 0 ) continue;
				n = d = 1;
				int g = (int) xMath.gcd(a, b);
				int low_n = a / g;
				int low_d = b / g;
				//System.out.println(a + "/" + b + "\t" + low_n + "/" + low_d);
				
				if( (a % 10) == (b % 10)){ n = a / 10; d = b / 10; }
				if( (a % 10) == (b / 10)){ n = a / 10; d = b % 10; }
				if( (a / 10) == (b % 10)){ n = a % 10; d = b / 10; }
				if( (a / 10) == (b / 10)){ n = a % 10; d = b % 10; }
				if(low_n == n && low_d == d)
				{
					pN *= n;
					pD *= d;
				}
			}
		}
		System.out.println("P033 : " + pD);
		
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
