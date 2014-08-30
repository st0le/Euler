/**
 * 
 */
package org.mechaevil.Euler.Problem063;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem063 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int c = 0;
		for(int n = 1;n<22;n++)
		{
			for(int a = 1; ; a++)
			{
				BigInteger a_n  = BigInteger.valueOf(a).pow(n);
				if(a_n.toString().length() == n) c++;
				if(a_n.toString().length() > n) break;
			}
		}
		System.out.println("P063 : " + c);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
