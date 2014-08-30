/**
 * 
 */
package org.mechaevil.Euler.Problem079;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.mechaevil.util.StopWatch;

/**
 * @author 332609
 *
 */
public class Problem079 implements Constants {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		HashSet<String> unique_codes = new HashSet<String>();
		for(String str: codes.split("\n"))
			unique_codes.add(str);

		boolean[] digitused = new boolean[10];
		boolean[][] flag = new boolean[10][10];

		for(String s:unique_codes)
		{
			flag[s.charAt(0)-'0'][s.charAt(1)-'0'] = true;
			flag[s.charAt(1)-'0'][s.charAt(2)-'0'] = true;
			flag[s.charAt(0)-'0'][s.charAt(2)-'0'] = true;
			digitused[s.charAt(0)-'0'] = true;
			digitused[s.charAt(1)-'0'] = true;
			digitused[s.charAt(2)-'0'] = true;
		}
		ArrayList<Digit>digits = new ArrayList<Digit>();
		int i = 0;
		for(i=0;i<10;i++)
		{
			
			if(digitused[i])
			{
				Digit digit = new Digit();
				digit.digit = i;
				digit.freq = 0;
				for(int j = 0; j < 10; j++)
					if(flag[i][j]) digit.freq ++;
				
				digits.add(digit);
			}
		}
		Collections.sort(digits);
		String ans = "";
		for(Digit d:digits)
			ans += d.digit + "";
		
		System.out.println("P079 : " + ans);
		timer.stopTimer();
		System.out.println(timer);


	}

}
