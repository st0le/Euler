/**
 * 
 */
package org.mechaevil.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author 332609
 *
 */
public class zString {

	/**
	 * @param str
	 * @return Reverses of the String. 
	 */
	public static String reverseString(String str)
	{
		String r = "";
		for(char ch:str.toCharArray())
			r = ch + r;
		return r;
	}

	public static String joinChars(Collection<Character> col)
	{
		String r = "";
		for(char ch: col)
			r += ch;
		return r;
	}
	public static String sortString(String str)
	{
		ArrayList<Character> list = new ArrayList<Character>();
		for(char ch : str.toCharArray())
			list.add(ch);
		Collections.sort(list);
		return joinChars(list);
	}
	public static boolean isPermutation(String p,String q)
	{
		if(p.length() == q.length())
		{
			int[] alpha = new int[256];
			for(int i = 0 ; i < q.length(); i++)
			{
				alpha[p.charAt(i)]++;
				alpha[q.charAt(i)]--;
			}
			for(int i = 0; i < 256; i++)
				if(alpha[i] != 0) return false;
			return true;
		}else
			return false;

	}
	public static boolean isPalindrome(String str)
	{
		int l = str.length() - 1;
		for(int i = 0; i < l; i++, l--)
			if(str.charAt(i) != str.charAt(l))
				return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public static String join(Collection<?> s, String delimiter) {
		StringBuilder builder = new StringBuilder();
		Iterator iter =  s.iterator();
		while (iter.hasNext()) {
			builder.append(iter.next());
			if (!iter.hasNext()) {
				break;                  
			}
			builder.append(delimiter);
		}
		return builder.toString();
	}


	public static String join(String[] arr, String delimiter) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < arr.length; i++){
			builder.append(arr[i]);
			if(i == arr.length - 1) break;
			builder.append(delimiter);
		}
		return builder.toString();
	}

	public static int computeEditDistance(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {

				dp[i][j] = i == 0 ? j : j == 0 ? i : 0;

				if (i > 0 && j > 0) {

					if (s1.charAt(i - 1) == s2.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1];

					else
						dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(
								dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1));

				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
