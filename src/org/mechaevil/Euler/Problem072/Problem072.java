/**
 * 
 */
package org.mechaevil.Euler.Problem072;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem072 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		final int N = 1000000;
		long[]phi = xMath.sieveEulerTotientFunction(N);
		long s = 0;
		for(long i : phi)
		{
			s+=i;
		}
		System.out.println("P072 : " + s);
		timer.stopTimer();
		System.out.println(timer);
	}
	
	//For Trial...
	public static int countFarey(int a,int b,int c,int d,int limit)
	{
		return (b+d <= limit)? 1 + countFarey(a,b,a+c,b+d,limit) + countFarey(a+c,b+d,c,d,limit): 0;
	}

}
