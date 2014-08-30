/**
 * 
 */
package org.mechaevil.util.Conversions;

/**
 * @author 332609
 *
 */
public class BaseConverter {
	// converts integer n into a base b string
	public static String toString(int n, int base) {
		// special case
		if (n == 0) return "0";

		String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String s = "";
		while (n > 0) {
			int d = n % base;
			s = digits.charAt(d) + s;
			n = n / base;
		}
		return s;
	}

	public static String toBinaryString(int n) { return toString(n,  2); }
	public static String toHexString(int n)    { return toString(n, 16); }


	public static void inputError(String s) {
		throw new RuntimeException("Input error with" + s);
	}

	// convert a String representing a base b integer into an int
	public static int fromString(String s, int b) {
		int result = 0;
		int digit = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9')
				digit = c - '0';
			else if (c >= 'A' && c <= 'Z')
				digit = 10 + c - 'A';
			else inputError(s);

			if (digit < b) result = b * result + digit;
			else inputError(s);
		}
		return result;
	}

	public static int fromBinaryString(String s) { return fromString(s,  2); }
	public static int fromHexString(String s)    { return fromString(s, 16); }

}
