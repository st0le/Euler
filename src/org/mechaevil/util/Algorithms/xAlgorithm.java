/**
 * 
 */
package org.mechaevil.util.Algorithms;

/**
 * @author 332609
 * 
 */
public class xAlgorithm {

	/** Set all elements of a to the value v; return a. */
	public static <T> T[] fill(T[] a, T v) {
		for (int i = 0; i < a.length; i++)
			a[i] = v;
		return a;
	}

	/**
	 * @param <T>
	 * @param arr
	 * @return Returns False unless, Next Permutation of Array is possible to
	 *         generate.
	 */
	public static <T extends Comparable<T>> boolean nextPermutation(T[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1].compareTo(arr[i]) >= 0)
			i--;
		if (i == 0)
			return false;

		int j = arr.length;
		while (j > 0 && arr[j - 1].compareTo(arr[i - 1]) <= 0)
			j--;

		T t = arr[i - 1];
		arr[i - 1] = arr[j - 1];
		arr[j - 1] = t;

		i++;
		j = arr.length;
		while (i < j) {
			t = arr[i - 1];
			arr[i - 1] = arr[j - 1];
			arr[j - 1] = t;

			i++;
			j--;
		}
		return true;
	}

	public static String nextLexographicWord(String txt) {
		char[] letters = txt.toCharArray();
		int l = letters.length - 1;
		while (l >= 0) {
			if (letters[l] == 'z')
				letters[l] = 'a';
			else {
				letters[l]++;
				break;
			}
			l--;
		}
		if (l < 0)
			return 'a' + (new String(letters));
		return new String(letters);
	}

	public static int getMaximumSubSequence(int x[], int l) {
		int currentSum = 0;
		int maxSum = 0;
		for (int i = 0; i < l; i++) {
			currentSum = Math.max(currentSum + x[i], 0);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

	public static int getMaximumSubSequence(int x[]) {
		return getMaximumSubSequence(x, x.length);
	}

}
