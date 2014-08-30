/**
 * 
 */
package org.mechaevil.Euler.Problem135;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem135 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		//		(a+2d)^2 - (a+d)^2 - a^2 = n
		//
		//		a^2 + 4d^2 + 4ad - a^2 - d^2 - 2ad - a^2 = n
		//		4d^2 + 4ad - d^2 - 2ad - a^2 = n
		//
		//		3d^2 + 2ad - a^2 = n
		//		3d^2 + 3ad - ad - a^2 = n
		//		3d(d + a) -a(d+a) = n
		//		(d+a)(3d-a)=n
		//		Say, p = (d+a), q = (3d - a)
		//		p + q = 4d => d = (q + p)/4
		//		3p - q = 4a => a = (3p - q)/4
		//		p * q < 10^6, q < 3 * p
		final int N = 1000000;
		int[] countSolutions = new int [N];
		for(int p = 1; p < N; p++)
		{
			//since p+q = 0 (mod 4)
			for(int q = 4 - (p % 4); q < 3 * p &&  p*q < N; q += 4)
			{
				countSolutions[p*q] ++;
			}
		}

		int c = 0;
		for(int i = 0 ; i < countSolutions.length; i++)
			if(countSolutions[i] == 10)
			{
				c++;
			}
		System.out.println("P135 : " + c);

		timer.stopTimer();
		System.out.println(timer);
	}

}
