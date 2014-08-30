/**
 * 
 */
package org.mechaevil.Euler.Problem065;

import java.util.ArrayList;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.BigRational;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.Math.xMathApprox;

/**
 * @author 332609
 *
 */
public class Problem065 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		ArrayList<Integer> lst = new ArrayList<Integer>();
		lst.add(2);
		for(int i = 0; lst.size() <100; )
			lst.add((lst.size() % 3 == 2)? (2*++i):1);
		
		BigRational frac = xMathApprox.continuedFractionToFraction(lst);
		System.out.println("P065 : " + xMath.sumDigits(frac.getNumerator()));
		timer.stopTimer();
		System.out.println(timer);

	}

}
