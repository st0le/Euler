/**
 * 
 */
package org.mechaevil.Euler.Problem090;

import java.util.HashSet;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem090 {
	
	public static boolean strictlyDecreasing(int n)
	{
		int d = n % 10;
		n /= 10;
		while (n > 0)
		{
			int nd = n % 10;
			if(nd <= d) return false;
			d =  nd;
			n /= 10;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		HashSet<String> myset = new HashSet<String>();
		
		for(int n = 987654; n >= 543210; n--)
		{
			if(strictlyDecreasing(n))
			{
				String t = "" + n;
				myset.add(t);
			}
		}
		int c = 0;
		for(String p : myset)
		{
			for(String q:myset)
			{
				if(!check(p,q,'0','1')) continue;
				if(!check(p,q,'0','4')) continue;
				if(!check2(p,q,'0')) continue;
				if(!check2(p,q,'1')) continue;
				if(!check(p,q,'2','5')) continue;
				if(!check2(p,q,'3')) continue;
				if(!check2(p,q,'4')) continue;
				if(!check2(p,q,'4')) continue;
				if(!check(p,q,'8','1')) continue;
				c++;
			}
		}
		c = c/2;
		System.out.println("P090 : " + c);
		
		timer.stopTimer();
		System.out.println(timer);
	}

	private static boolean check(String p, String q, char c, char d) {
		// 
		return ( (p.indexOf(c) >=0 && q.indexOf(d) >= 0) 
				|| (p.indexOf(d) >=0 && q.indexOf(c) >= 0));
	}
	
	private static boolean check2(String p, String q, char c) {
		// 
		return  (p.indexOf(c) >=0 && (q.indexOf('9') >=0 || q.indexOf('6') >=0)) ||
				(q.indexOf(c) >=0 && (p.indexOf('9') >=0 || p.indexOf('6') >=0));
	}


}
