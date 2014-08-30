package org.mechaevil.Euler.Problem002;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Sequence.xFibonacci;

public class Problem002 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int s = 0;
		for(int i = 0; xFibonacci.fib93(i) < 4000000; i+=3)
			s +=xFibonacci.fib93(i);
		System.out.println("P002 : " + s);
		timer.stopTimer();
		System.out.println(timer);

	}
}
