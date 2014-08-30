package org.mechaevil.util.Algorithms;

import java.util.Arrays;

public class Pi {

	private Pi() {}

	public static String pi(int nDigits)
	{
		if ( nDigits > 54900)
		{
			throw new IllegalArgumentException("n must be <= 54900");
		}

		final StringBuilder pi = new StringBuilder(nDigits);
		final String[] zero = { "0", "00", "000" };
		int d = 0, e, b, g, r;
		int c = (nDigits / 4 + 1) * 14;
		final int[] a = new int[c];
		final int f = 10000;

		Arrays.fill(a, 20000000);

		while ((b = c -= 14) > 0)
		{
			d = e = d % f;

			while (--b > 0)
			{
				d = d * b + a[b];
				g = (b << 1) - 1;
				a[b] = (d % g) * f;
				d /= g;
			}

			r = e + d / f;

			if (r < 1000)
			{
				pi.append(zero[r > 99 ? 0 : r > 9 ? 1 : 2]);
			}
			pi.append(r);
		}
		return pi.toString();
	}


}


