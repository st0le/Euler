/**
 * 
 */
package org.mechaevil.Euler.Problem235;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem235 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		double guessR_low = 1.0;
		double guessR_high = 1.1;
		double guessR = (guessR_low + guessR_high)/2.0;
		double lastGuess = guessR;
		
		double target = -6e11;
		double epsilon = 1e-12;
		int c = 0;
		do
		{
			double guessS = solve(guessR);
			if(guessS > target )
				guessR_low = guessR;
			else
				guessR_high = guessR;
			lastGuess = guessR; 
			guessR = (guessR_low + guessR_high)/2.0;
			c++;
		}while(Math.abs(lastGuess-guessR) > epsilon);
		System.out.printf("P235 : %.12f\n",guessR);
		timer.stopTimer();
		System.out.println(timer);
	}
	
	public static double solve(double r)
	{
		double rk = 1.0;
		double s = 0;
		for(int k = 1; k <= 5000; k++)
		{
			double u = (900 - 3 * k) * rk;
			s += u;
			rk *= r;
		}
		return s;
	}

}
