/**
 * 
 */
package org.mechaevil.Euler.Problem118;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.zString;
import org.mechaevil.util.Algorithms.xAlgorithm;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem118 {

	public static PrimeSieve table = new PrimeSieve(100000000);
	public static HashSet<String> arr = new HashSet<String>();
	
	public static Comparator<String> myComp = new Comparator<String>(){

		@Override
		public int compare(String arg0, String arg1) {
			return Integer.parseInt(arg0) - Integer.parseInt(arg1);
		}
		
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		Integer[] digits = new Integer[]{1,2,3,4,5,6,7,8,9};
		int s = 0;
		do
		{
			if(digits[8] % 2 == 0 || digits[8] == 5) continue;
			s += countSubsets(digits,0,"");
		}while(xAlgorithm.nextPermutation(digits));
		System.out.println("P118 : " + arr.size());
			
		timer.stopTimer();
		System.out.println(timer);
	}

	private static int countSubsets(Integer[] digits, int start,String str) {
		int s = 0 ;
		if(start >= digits.length)
		{
			String [] num = str.substring(0,str.length()-1).split(",");
			Arrays.sort(num,myComp);
			str = zString.join(num,",");
			arr.add(str);
			return 1;
		}

		int n = 0;
		for(int i = start; i < digits.length; i++)
		{
			n = n * 10 + digits[i];
			if(table.isPrime(n))
			{
				s += countSubsets(digits, i+1,str + n + ",");
			}
		}
		return s;
	}


}
