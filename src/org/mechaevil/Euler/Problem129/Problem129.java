/**
 * 
 */
package org.mechaevil.Euler.Problem129;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem129 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int d,n;
		n = 1000001;
		do{
			if(xMath.gcd(n, 10) == 1)
			{
				int j = 0;
				for(d = 0;; d++)
				{
					j = ((j * 10) + 1) % n;
					if(j == 0) break;
				}
				if(!(d < 1000000)) break;
			}
			n+=2;
		}while(true);
		System.out.println("P129 : " + n);
		timer.stopTimer();
		System.out.println(timer);
	}

}
