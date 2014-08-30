/**
 * 
 */
package org.mechaevil.Euler.Problem036;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.zString;
import org.mechaevil.util.Conversions.BaseConverter;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem036 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 1000000;
		long s  = 0;
		for(int i = 1 ; i < N; i+=2 )// just odd numbers...
		{
			if(xMath.isPalindrome(i))
			{
				if(zString.isPalindrome(BaseConverter.toBinaryString(i)))
					s += i;
			}
		}
		System.out.println("P036 : " + s); 
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
