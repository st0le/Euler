/**
 * 
 */
package org.mechaevil.Euler.Problem077;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.PrimeFactory.xPrime;

/**
 * @author 332609
 *
 */
public class Problem077 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		int arr[] = new int[25];
		int c = 1;
		arr[0] = 2;
		for(int i = 3 ; c < arr.length; i+=2)
		{
			if(xPrime.isPrimeNaive(i))
			{
				arr[c++] = i;
			}
		}
		int i = 10; //5 ways to represent 10
		do
		{
			if(xMath.partitionSet(i, arr, 0) > 5000)
				break;
			i++;
		}while(true);
		System.out.println("P077 : " +i);
		timer.stopTimer();
		System.out.println(timer);


	}

}
