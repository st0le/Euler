/**
 * 
 */
package org.mechaevil.Euler.Problem103;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem103 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		//Unfortunately, the "near optimum rule" 
		//satisfies the "optimum" so this was an easy solve
		// but i'll look into the proper way of doing this.
		int [] n6 = new int[] {11, 18, 19, 20, 22, 25};
		int [] n7 = new int[7] ;
		n7[0] = n6[n6.length/2];
		for(int i = 0 ; i < n6.length;i++)
			n7[i+1] = n6[i] + n7[0];
		StringBuilder sb=  new StringBuilder();
		for(int n:n7)
			sb.append(n);
		System.out.println("P103 : " + sb.toString());
			
		
		timer.stopTimer();
		System.out.println(timer);

	}

}
