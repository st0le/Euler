/**
 * 
 */
package org.mechaevil.Euler.Problem023;

import java.util.ArrayList;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem023_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		
		
		final int N = 22000;
		ArrayList<Integer> ablist = new ArrayList<Integer>();
		int [] sdivs = xMath.sieveSumOfDivisors(N);
		for(int i = 1 ; i < sdivs.length;i ++)
			if(sdivs[i] > i*2)
				ablist.add(i);
		
		boolean [] flag = new boolean[N + 1];
		for(int i = 0 ; i < ablist.size(); i++)
			for(int j = 0 ; j <= i ; j++)
			{
				int  k = ablist.get(i) + ablist.get(j);
				if(  k <= N )
					flag[k] = true;
			}
		
		long s = 0;
		for(int i = 0 ; i < N + 1;i++)
			if(!flag[i])
			{
				s += i;
			}
		System.out.println("P023 : " + s);

		
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
