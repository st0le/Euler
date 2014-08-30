/**
 * 
 */
package org.mechaevil.Euler.Problem105;


import org.mechaevil.util.StopWatch;
import org.mechaevil.util.UtilityMethods;

/**
 * @author 332609
 *
 */
public class Problem105 implements Constants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		String[] lines = sets.split("\n");
		int s = 0;
		for(String line : lines)
		{
			String[] nums = line.split(",");
			int[] arr = new int [nums.length];
			int i = 0;
			for(String num:nums)
				arr[i++] = Integer.parseInt(num); 
			if(isSpecial(arr))
			{
				s +=  (int) UtilityMethods.sumArray(arr);
			}
		}	
		System.out.println("P105 : "+ s);
		
		timer.stopTimer();
		System.out.println(timer);
	}

	private static boolean isSpecial(int[] arr) {
		int l = arr.length;
		int MAX = 1 << l;
		
		for(int a = 1; a < MAX; a++)
		{
			for(int b = 1; b < MAX; b++)
			{
				if( (a & b) == 0)
				{
					int bA = Integer.bitCount(a);
					int bB = Integer.bitCount(b);
					int sumA = sumMask(arr,a);
					int sumB = sumMask(arr,b);
					if(sumA == sumB) return false;
					if(bA < bB && sumA > sumB) return false;
					if(bA > bB && sumA < sumB) return false;
				}
			}
		}
		return true;
	}

	private static int sumMask(int[] arr, int a) {
		int s = 0;
		for(int i = 0; i < arr.length; i++)
			if( ((a >> i) & 1) == 1)
				s += arr[i];
		return s;
	}

}
