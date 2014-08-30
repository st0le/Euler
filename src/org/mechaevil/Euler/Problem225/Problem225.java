package org.mechaevil.Euler.Problem225;

import org.mechaevil.util.StopWatch;

public class Problem225 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// ... your Code here
		int count = 0;
		int last = 0;
		for(int i = 3; count < 124 ;i += 2)
		{
			long a,b,c,d;
			a = b = c = 1;
			boolean found = false;
			for(int iter = 0;iter < i*i ; iter++)
			{
				d = (a + b + c) % i;

				if(d == 0)
				{
					found  = true;
					break;
				}

				a = b;
				b = c;
				c = d;
			}
			if(!found)
			{
				count++;
				last = i;
			}
		}
		System.out.println("P225 : " + last);
		timer.stopTimer();
		System.out.println(timer);
	}

}
