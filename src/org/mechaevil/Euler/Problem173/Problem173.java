/**
 * 
 */
package org.mechaevil.Euler.Problem173;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem173 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here

		final int MAX = 1000000; 
		int [] map = new int[MAX+1];

		for(int i = 1; i*i - (i-2)*(i-2) <= MAX; i++)
		{
			for(int j = i - 2 ; i*i - j*j <= MAX && j >= 1; j-=2)
			{
				int k = i*i - j*j;
				if(k > 0 && k <= MAX)
					map[k]++;
			}
		}
		
		int s = 0;
		for(int i = 0 ; i <map.length;i++)
				s+= map[i];

		System.out.println("P173 : " + s);

		timer.stopTimer();
		System.out.println(timer);


	}

}
