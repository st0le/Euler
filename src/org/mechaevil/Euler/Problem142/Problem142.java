/**
 * 
 */
package org.mechaevil.Euler.Problem142;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem142 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		// Violates 1 minute RULE!
		final int N = 1000000; 
		boolean[] isSquare = new boolean [N];
		for(int i = 0 ; i*i < N; i++)
			isSquare[i*i] = true;
		
		boolean done = false;
		for(int x = 1; !done ; x++)
		{
			for(int y = 1 + (x % 2 ); y < x; y+=2)
			{
				if(isSquare[(x-y)] && isSquare[(x+y)])
				{
					for(int z = 1 + (x % 2 ); z < y; z+=2)
					{
						if(isSquare[(x-z)] && isSquare[(x+z)] &&
								isSquare[(y-z)] && isSquare[(y+z)])
						{
							System.out.println("P142 : " + x + "+" + y + "+" + z + "=" + (x+y+z));
							done = true;
						}
					}
				}
			}
		}
		timer.stopTimer();
		System.out.println(timer);
	}
}
