/**
 * 
 */
package org.mechaevil.Euler.Problem032;

import java.util.HashSet;
import java.util.Set;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem032 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		Set<Long> set = new HashSet<Long>();
		for(int i = 1; i < 2000;i++)
			for(int j = 1; j < i;j++)
				if(xMath.isPandigital9(Long.parseLong(("" + i + "" + j + "" + i*j)))) //ugly :(
				{
					set.add((long)(i*j));
				}
		
		long s = 0;
		for(long l:set)
			s += l;
		System.out.println("P032 : " + s);


		timer.stopTimer();
		System.out.println(timer);


	}

}
