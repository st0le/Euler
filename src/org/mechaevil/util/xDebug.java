/**
 * 
 */
package org.mechaevil.util;

import java.util.Arrays;

/**
 * @author 332609
 *
 */
public class xDebug {
	public static void display2D(int[][] arr)
	{
		for(int[] row : arr)
		{
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void display2D(long[][] arr)
	{
		for(long[] row : arr)
		{
			System.out.println(Arrays.toString(row));
		}
	}
	public static void display1D(long[] arr)
	{
		System.out.println(Arrays.toString(arr));
	}

	public static void display1D(int[] arr)
	{
		System.out.println(Arrays.toString(arr));
	}
	public static void display1D(int[] arr,int l)
	{
		String ret = "[";
		for(int i = 0 ; i < l ;i++)
			ret += arr[i] + ((i == l - 1)? "":",");
		System.out.println(ret + "]");
	}

	public static <E> void display1D(E[] arr)
	{
		System.out.println(Arrays.toString(arr));
	}

}
