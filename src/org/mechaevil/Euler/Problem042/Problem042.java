/**
 * 
 */
package org.mechaevil.Euler.Problem042;

import java.util.ArrayList;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem042 implements Constants{

	public static long alphaValue(String str)
	{
		long s = 0;
		str = str.toUpperCase();
		for(char ch:str.toCharArray())
			s += ch - 'A' + 1;
		return s;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		ArrayList<Long> list = new ArrayList<Long>();
		for(long i = 0 ; i*(i+1)/2 < 200; ++i) list.add(i * (i+1)/2);
		int c =  0;
		for(String s:Constants.arr)
		{
			
			if(list.contains(alphaValue(s)))
				c++;
		}
		System.out.println("P042 : " + c);
		
		timer.stopTimer();
		System.out.println(timer);


	}

}
