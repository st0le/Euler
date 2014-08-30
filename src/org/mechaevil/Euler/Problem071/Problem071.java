/**
 * 
 */
package org.mechaevil.Euler.Problem071;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.Fraction;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem071 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		Fraction f = fareySeries(0, 1, 3, 7, 1000000);
		System.out.println("P071 : " + f.numerator());
		
		timer.stopTimer();
		System.out.println(timer);


	}
	public static Fraction fareySeries(int a,int b,int c,int d,int limit)
	{
		while(true)
		{
			int p = a+c;
			int q = b+d;
			int g = xMath.gcd(p,q);
			p /= g;
			q /= g;
			if(q > limit) break;
			a = p ;
			b = q ;
		}
		return new Fraction(a,b);
	}

}
