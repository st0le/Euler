/**
 * 
 */
package org.mechaevil.util;

/**
 * @author 332609
 */
public class UtilityMethods {

    public static long sumArray(int[] arr) {
        long s = 0;
        for(int p: arr)
            s += p;
        return s;
    }

    public static long sumArray(long[] arr) {
        long s = 0;
        for(long p: arr)
            s += p;
        return s;
    }

    public static void shiftArrayLeft(int[] arr) {
        for(int i = 1; i < arr.length; i++)
            arr[i - 1] = arr[i];
        arr[arr.length - 1] = 0;
    }

    public static void shiftArrayLeft(long[] arr) {
        for(int i = 1; i < arr.length; i++)
            arr[i - 1] = arr[i];
        arr[arr.length - 1] = 0;
    }
}
