/**
 * 
 */
package org.mechaevil.util.PrimeFactory;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Factorization {
    private final static BigInteger TWO  = new BigInteger("2");
    private final static SecureRandom random = new SecureRandom();

    public static BigInteger pollardRho(BigInteger N) {
        // check divisibility by 2
        if (N.mod(TWO).compareTo(BigInteger.ZERO) == 0) return TWO;
        BigInteger divisor;
        BigInteger c  = new BigInteger(N.bitLength(), random);
        BigInteger x  = new BigInteger(N.bitLength(), random);
        BigInteger xx = x;
        do {
            x  =  x.multiply(x).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            divisor = x.subtract(xx).gcd(N);
        } while((divisor.compareTo(BigInteger.ONE)) == 0);

        return divisor;
    }
    
    public static long fermatFactorisation(long n)
    {
    	long a = (long)Math.ceil(Math.sqrt(n));
    	long b2 = a*a - n;
    	while (!xMath.isPerfectSquare(b2))
    	{
    		a = a + 1;
    		b2 = a*a - n;
    	}
    	return a - (long)Math.sqrt(b2);
    }
}
