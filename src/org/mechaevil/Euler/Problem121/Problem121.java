/**
 * 
 */
package org.mechaevil.Euler.Problem121;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem121 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final int N = 15;
		int blueDiscCount;
		double blueProbability , gameWin ;
		gameWin = 0.0;
		for(int i = 0 ; i < (1<< N); i++)
		{
			blueDiscCount = 0;
			blueProbability = 1;
			for(int b = 0; b < N; b++ )
			{
				if(((i >> b) & 1) == 1)
				{
					blueDiscCount++;
					blueProbability *= (1.0/ (double)(b+2));
				}else
					blueProbability *= ((b+1)/ (double)(b+2));
			}
			
			if(blueDiscCount > N/2)
				gameWin += blueProbability;

		}
		System.out.println("P121 : " + Math.floor(1/gameWin));

		timer.stopTimer();
		System.out.println(timer);


	}

}
