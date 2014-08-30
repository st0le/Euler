/**
 * 
 */
package org.mechaevil.Euler.Problem079;

/**
 * @author 332609
 *
 */

public class Digit implements Comparable<Digit>
{
	public int digit,freq;
	@Override
	public int compareTo(Digit arg0) {
		// 
		return (arg0.freq == freq)? (arg0.digit - digit):(arg0.freq - freq);
	}

	public String toString() {
		return "(" + digit + "," + freq + ")";
	}
}

