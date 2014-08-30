/**
 * 
 */
package org.mechaevil.Euler.Problem091;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem091 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final int N = 50;
		int count = 0;
		for(int x1 = 0; x1 <= N; x1++)
			for(int y1 = 0; y1 <= N; y1++)
			{
				if(x1 == 0 && y1 == 0) continue;
				for(int x2 = 0; x2 <= N; x2++)
					for(int y2 = 0; y2 <= N; y2++)
					{
						if(x2 == 0 && y2 == 0) continue;
						if(x2 == x1 && y2 == y1) continue;
						
						int a2 = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
						int b2 = x1*x1 + y1*y1;
						int c2 = x2*x2 + y2*y2;
						if( a2 != 0 && b2 != 0 && c2 != 0)
							if( 
									( a2 == b2 + c2) ||
									( b2 == a2 + c2) ||
									( c2 == b2 + a2))
							{

								count++;
							}

					}
			}

		System.out.println("P091 : "+ count/2);

		timer.stopTimer();
		System.out.println(timer);
	}

}
