/**
 * 
 */
package org.mechaevil.util.PrimeFactory;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author 332609
 * 
 */
public class FermatsPrimalityTest {

	private final static BigInteger TWO = new BigInteger("2");
	private final static SecureRandom random = new SecureRandom();
	private static int certainity = 5;

	public static boolean isPrime(int n) {
		return isPrime(BigInteger.valueOf(n), certainity);
	}

	public static boolean isPrime(long n) {
		return isPrime(BigInteger.valueOf(n), certainity);
	}

	public static boolean isPrime(BigInteger n) {
		return isPrime(n, certainity);
	}

	public static BigInteger getRandomBigInteger(BigInteger n) {
		return new BigInteger(n.bitLength(), random).mod(n);
	}

	public static boolean isPrime(BigInteger n, int times) {
		if (n.compareTo(TWO) <= 0)
			return (n.compareTo(TWO) == 0);
		BigInteger a = null;
		do {
			do {
				a = getRandomBigInteger(n);
				if (a.compareTo(TWO) >= 0 && n.compareTo(a) > 0)
					break;
			} while (true);

			if (a.gcd(n).compareTo(BigInteger.ONE) > 0)
				return false;
			if (a.modPow(n, n).compareTo(a) != 0)
				return false;
			times--;
		} while (times > 0);
		return true;
	}

	public static int getTestTimes() {
		return certainity;
	}

	public static void setTestTimes(int testTimes) {
		FermatsPrimalityTest.certainity = testTimes;
	}

}
