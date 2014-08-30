/**
 * 
 */
package org.mechaevil.Euler.Problem073;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem073 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		//Increase stack space to 2MB, -Xss2M
		System.out.println("P073 : "+ countFarey(1, 3, 1, 2, 12000));
		timer.stopTimer();
		System.out.println(timer);
	}
	
	//For Trial...
	public static int countFarey(int a,int b,int c,int d,int limit)
	{
		return (b+d <= limit)? 1 + countFarey(a,b,a+c,b+d,limit) + countFarey(a+c,b+d,c,d,limit): 0;
	}
}
