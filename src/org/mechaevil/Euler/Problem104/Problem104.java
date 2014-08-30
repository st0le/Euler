/**
 * 
 */
package org.mechaevil.Euler.Problem104;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem104 {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		
		double root5 = Math.sqrt(5);
		double phi = (1 + root5) / 2;
		double phi_n = 1;
		long a = 1, b = 1;
		int i;
		for(i = 0 ; ; i++)
		{
			phi_n *= phi;
			if(phi_n > 1E30)
				phi_n /= 1E10;
			long no = trimFirst9(phi_n/root5);

			if(xMath.isPandigital9(no) && xMath.isPandigital9(a))
			{
				break;
			}
			long c = (a + b) % 1000000000;
			a = b;
			b = c;

		}
		System.out.println("P104 : " + i);
		timer.stopTimer();
		System.out.println(timer);
	}
	
	public static long trimFirst9(double n)
	{
		while(n > 1E9) n /= 10;
		return (long)(n);
	}

}
