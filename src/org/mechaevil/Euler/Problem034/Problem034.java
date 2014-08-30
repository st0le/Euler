package org.mechaevil.Euler.Problem034;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

public class Problem034 {
	
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		long s = 0;
		for(int i = 10 ; i < 100000; i++)
		{
			int n = i;
			long sfac = 0;
			while(n > 0)
			{
				sfac += xMath.factorial(n % 10);
				n/=10;
			}
			if(i == sfac)
			{
				//System.out.println(i);
				s += i;
			}
		}
		System.out.println("P034 : " + s);
		timer.stopTimer();
		System.out.println(timer);

	}

}
