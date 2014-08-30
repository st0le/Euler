/**
 * 
 */
package org.mechaevil.Euler.Problem068;

import java.math.BigInteger;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Algorithms.xAlgorithm;

/**
 * @author 332609
 *
 */
public class Problem068 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here (Brute Force, Try Every Permutation, takes 515ms :)
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10};

		BigInteger max = BigInteger.ZERO;
		String t = "";
		do
		{
			int k1 = arr[0] + arr[1] + arr[5];
			int k2 = arr[1] + arr[2] + arr[6];
			if(k1 != k2) continue;
			int k3 = arr[2] + arr[3] + arr[7];
			if(k1 != k3) continue;
			int k4 = arr[3] + arr[4] + arr[8];
			if(k1 != k4) continue;
			int k5 = arr[0] + arr[4] + arr[9];
			if(k1 != k5) continue;

			//Valid Combination
			int mini = 5;
			for(int i= 6; i < 10; i++)
			{
				if(arr[i] < arr[mini])
					mini = i;
			}
			t = "";
			int k = mini;
			for(int c = 0; c < 5;c++,k++)
			{
				if(k > 9) k = 5;
				switch(k)
				{
				case 5 : t += "" + arr[5] + arr[0] + arr[1]; break;
				case 6 : t += "" + arr[6] + arr[1] + arr[2]; break;
				case 7 : t += "" + arr[7] + arr[2] + arr[3]; break;
				case 8 : t += "" + arr[8] + arr[3] + arr[4]; break;
				case 9 : t += "" + arr[9] + arr[4] + arr[0]; break;
				}
			}
			if(t.length() == 16)
			{
				BigInteger temp = new BigInteger(t);
				if(temp.compareTo(max) >=0)
					max = temp;
			}
		}while(xAlgorithm.nextPermutation(arr));
		System.out.println("P068 : " + max);

		timer.stopTimer();
		System.out.println(timer);


	}

}
