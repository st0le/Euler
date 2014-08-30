/**
 * 
 */
package org.mechaevil.util.Math;

import java.math.BigInteger;

public class BigRational implements Comparable<BigRational> {

    public final static BigRational ZERO = new BigRational(0);
    public final static BigRational ONE = new BigRational(1);

    private BigInteger num = null;   // the numerator
    private BigInteger den = null;   // the denominator


    // create and initialize a new BigRational object
    public BigRational(int numerator, int denominator) {
        this(new BigInteger("" + numerator), new BigInteger("" + denominator));
    }

    // create and initialize a new BigRational object
    public BigRational(int numerator) {
        this(numerator, 1);
    }

    // create and initialize a new BigRational object from a string, e.g., "-343/1273"
    public BigRational(String s) {
        String[] tokens = s.split("/");
        if (tokens.length == 2)
            init(new BigInteger(tokens[0]), new BigInteger(tokens[1]));
        else if (tokens.length == 1)
            init(new BigInteger(tokens[0]), BigInteger.ONE);
        else
            throw new RuntimeException("Parse error in BigRational");
    }

    // create and initialize a new BigRational object
    public BigRational(BigInteger numerator, BigInteger denominator) {
        init(numerator, denominator);
    }

    private void init(BigInteger numerator, BigInteger denominator) {

        // deal with x / 0
        if (denominator.equals(BigInteger.ZERO)) {
           throw new RuntimeException("Denominator is zero");
        }

        // reduce fraction
        BigInteger g = numerator.gcd(denominator);
        num = numerator.divide(g);
        den = denominator.divide(g);

        // to ensure invariant that denominator is positive
        if (den.compareTo(BigInteger.ZERO) < 0) {
            den = den.negate();
            num = num.negate();
        }
    }

    // return string representation of (this)
    public String toString() { 
        if (den.equals(BigInteger.ONE)) return num + "";
        else                            return num + "/" + den;
    }

    // return { -1, 0, + 1 } if a < b, a = b, or a > b
    public int compareTo(BigRational b) {
        BigRational a = this;
        return a.num.multiply(b.den).compareTo(a.den.multiply(b.num));
    }

    // is this BigRational negative, zero, or positive?
    public boolean isZero()     { return compareTo(ZERO) == 0; }
    public boolean isPositive() { return compareTo(ZERO)  > 0; }
    public boolean isNegative() { return compareTo(ZERO)  < 0; }

    // is this Rational object equal to y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;  
        if (y.getClass() != this.getClass()) return false;
        BigRational b = (BigRational) y;
        return compareTo(b) == 0;
    }
        
    // hashCode consistent with equals() and compareTo()
    public int hashCode() {
        return this.toString().hashCode();
    }
    

    // return a * b
    public BigRational times(BigRational b) {
        BigRational a = this;
        return new BigRational(a.num.multiply(b.num), a.den.multiply(b.den));
    }

    // return a + b
    public BigRational plus(BigRational b) {
        BigRational a = this;
        BigInteger numerator   = a.num.multiply(b.den).add(b.num.multiply(a.den));
        BigInteger denominator = a.den.multiply(b.den);
        return new BigRational(numerator, denominator);
    }

    // return -a
    public BigRational negate() {
        return new BigRational(num.negate(), den);
    }

    // return a - b
    public BigRational minus(BigRational b) {
        BigRational a = this;
        return a.plus(b.negate());
    }

    // return 1 / a
    public BigRational reciprocal() {
        return new BigRational(den, num);
    }

    // return a / b
    public BigRational divides(BigRational b) {
        BigRational a = this;
        return a.times(b.reciprocal());
    }
    
    //return numerator
    public BigInteger getNumerator()
    {
    	return num;
    }
    
    //return denominator
    public BigInteger getDenominator()
    {
    	return den;
    }

}

