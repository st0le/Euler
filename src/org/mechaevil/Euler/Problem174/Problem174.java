/**
 * 
 */
package org.mechaevil.Euler.Problem174;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem174 {

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
			if(map[i] >= 1 && map[i] <= 10)
				s++;

		System.out.println("P174 : " + s);

		timer.stopTimer();
		System.out.println(timer);


	}

}
