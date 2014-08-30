/**
 * 
 */
package org.mechaevil.util.Math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 332609
 *
 */
public class xMathApprox {

	/**
	 * GAMMA FUNCTION
	 * gamma function for approximating factorials.
	 * @param z Only works for 1 <= z <= 142 but also defined for non integers.
	 * @returns approximation to (z-1)!
	 * @author Roedy Green
	 */
	public static double gamma(double z)
	{
		return Math.exp( -z ) * Math.pow( z, z - 0.5 ) * Math.sqrt( 2 * Math.PI ) *
		( 1 + 1 / ( 12 * z ) + 1 / ( 288 * z * z ) - 139 / ( 51840 * z * z * z ) - 571 / ( 2488320 * z * z * z * z ));
	}

	/**
	 * @param a
	 * @return Counts the Number of digits in the Number. (Base 10)
	 */
	public static int countDigits(int a)
	{
		if( a == 0) return 1;
		return (int) (Math.log10(a)+1);
	}

	public static int countDigits(long a)
	{
		if( a == 0) return 1;
		return (int) (Math.log10(a)+1);
	}
	
	public static int countDigits(int a,int b)
	{
		if( a == 0 || b == 0) return 1;
		return (int) ((Math.log(a) / Math.log(b))+1);
	}

	public static int countDigits(long a,int b)
	{
		if( a == 0 || b == 0) return 1;
		return (int) ((Math.log(a) / Math.log(b))+1);
	}

	/**
	 * Algorithm From "http://en.wikipedia.org/wiki/Methods_of_computing_square_roots" :)
	 * @param n
	 * @return Continued Fraction of Square Root of N. 
	 */
	public static ArrayList<Integer> continuedFractionOfSqrt(int n)
	{

		ArrayList<Integer> lst = new ArrayList<Integer>();
		ArrayList<Integer> prevTriplet = new ArrayList<Integer>(); 
		double sqroot = Math.sqrt(n);
		int m0 = 0;
		int d0 = 1;
		int a0 = (int)sqroot;
		int m1,d1,a1;
		boolean tripletFound = false;
		do
		{
			lst.add(a0);
			m1 = d0 * a0 - m0;
			d1 = (n - m1 * m1) / d0;
			a1 = (int) Math.floor((sqroot + m1) / (double)d1);

			prevTriplet.add(a0);
			prevTriplet.add(d0);
			prevTriplet.add(m0);

			m0 = m1;
			d0 = d1;
			a0 = a1;
			for(int i = 0 ; i + 2 < prevTriplet.size(); i+=3)
			{
				if(prevTriplet.get(i) == a1 && prevTriplet.get(i + 1) == d1 && prevTriplet.get(i+2) == m1)
				{
					tripletFound = true;
					break;
				}
			}

		}while( !tripletFound );
		return lst;
	}


	public static BigRational sqrtApproximation(int D)
	{
		ArrayList<Integer> lst = continuedFractionOfSqrt(D);
		return continuedFractionToFraction(lst,lst.size());
	}
	
	
	public static BigRational continuedFractionToFraction(ArrayList<Integer> lst)
	{
		return continuedFractionToFraction(lst,lst.size());
	}
	/**
	 * @param lst
	 * @return Get nth Fraction of the Supplied Continued Fraction
	 */
	public static BigRational continuedFractionToFraction(ArrayList<Integer> lst,int l)
	{
		if(l == 1) return new BigRational(lst.get(0),1);
		BigInteger num = BigInteger.valueOf(lst.get(--l));
		BigInteger den = BigInteger.ONE;
		while(l > 0)
		{
			BigInteger t = num;
			num = den;
			den = t;
			num = num.add(den.multiply(BigInteger.valueOf(lst.get(--l))));
		}
		return new BigRational(num,den);
	}

	/**
	 * @param lst
	 * @return Get nth Fraction of the Supplied Continued Fraction
	 */
	public static BigRational sqrtApproximation(int D,int n)
	{
		ArrayList<Integer> lst = continuedFractionOfSqrt(D);
		if(lst.size() == 1) return new BigRational(lst.get(0),1);
		List <Integer> frac = lst.subList(1, lst.size());
		BigInteger p0,p1,q0,q1;
		p0 = BigInteger.ONE;
		p1 = BigInteger.valueOf(lst.get(0));
		q0 = BigInteger.ZERO;
		q1 = BigInteger.ONE;
		int i = -1, l = frac.size();
		while(n > 0)
		{
			i = (i + 1) % l;
			BigInteger t = BigInteger.valueOf(frac.get(i));
			BigInteger p2 = t.multiply(p1).add(p0);
			BigInteger q2 = t.multiply(q1).add(q0);
			p0 = p1;
			q0 = q1;
			p1 = p2;
			q1 = q2;
			n--;
		}
		return new BigRational(p1,q1);
	}

	/**
	 * @param D
	 * @return Returns minimal solution to Pell Equation (x^2 - D *(y^2) = 1)
	 */
	public static BigRational solvePellEquation(int D)
	{
		if(xMath.isPerfectSquare(D))
		{
			return null; // trivial solution (x,y) = (1,0)
		}
		ArrayList<Integer> lst = continuedFractionOfSqrt(D);
		List <Integer> frac = lst.subList(1, lst.size());
		BigInteger p0,p1,q0,q1;
		p0 = BigInteger.ONE;
		p1 = BigInteger.valueOf(lst.get(0));
		q0 = BigInteger.ZERO;
		q1 = BigInteger.ONE;
		BigInteger bigD = BigInteger.valueOf(D);
		int i = -1, l = frac.size();
		while(!p1.pow(2).subtract(q1.pow(2).multiply(bigD)).equals(BigInteger.ONE))
		{
			i = (i + 1) % l;
			BigInteger t = BigInteger.valueOf(frac.get(i));
			BigInteger p2 = t.multiply(p1).add(p0);
			BigInteger q2 = t.multiply(q1).add(q0);
			p0 = p1;
			q0 = q1;
			p1 = p2;
			q1 = q2;
		}
		return new BigRational(p1,q1);
	}
	
	

	/**
	 * @author jeremy watts
	 * @param argument
	 * @param root
	 * @param workingDecimalPlaceNumber
	 * @return Root of a number correct upto the specified number of digits
	 */
	public static BigDecimal bigRoot(BigDecimal argument, int root, int 
			workingDecimalPlaceNumber)
	{

		/* returns uncorrected root of a BigDecimal - uses the Newton Raphson 
	method.
		 * argument must be positive
		 */

		BigDecimal result;
		BigDecimal xn;
		BigDecimal oldxn;
		BigDecimal xnPlusOne;
		BigDecimal numerator;
		BigDecimal denominator;
		BigDecimal quotient;
		BigDecimal constant;

		
		int runIndex;
		int iterationNumber = 200;
		constant = new BigDecimal(root);

		boolean halt;

		if (argument.compareTo(BigDecimal.ZERO) != 0) {
			xn = argument;
			oldxn = xn;
			halt = false;
			runIndex = 1;
			while ((halt == false) & (runIndex <= iterationNumber)) {
				oldxn = xn;
				numerator = xn;
				denominator = numerator;

				numerator = numerator.pow(root);
				denominator = denominator.pow(root - 1);

				denominator = (constant.multiply(denominator));
				numerator = (numerator.subtract(argument));

				if (denominator.compareTo(BigDecimal.ZERO) == 0) {
					halt = true;
				}
				else {
					quotient = (numerator.divide(denominator, 
							workingDecimalPlaceNumber, BigDecimal.ROUND_HALF_UP));

					xnPlusOne = (xn.subtract(quotient));
					xnPlusOne = xnPlusOne.setScale(workingDecimalPlaceNumber, 
							BigDecimal.ROUND_HALF_UP);

					xn = xnPlusOne;

					if (xnPlusOne.compareTo(oldxn) == 0) {
						halt = true;
					}
				}

				runIndex++;
			}
			result = xn;
		}
		else {
			result = BigDecimal.ZERO;
		}
		return(result);
	}
	
	public static Double [] solveQuadraticEquation(double a,double b,double c)
	{
		double b2 = b * b;
		double fourac = 4 * a * c;
		double D = b2 - fourac;
		if( D < 0) //imaginary roots.
		{
			return null;
		}else
		{
			double rootD = Math.sqrt(D);
			Double[] roots = new Double[2];
			roots[0] = (-b + rootD)/(2*a);
			roots[1] = (-b - rootD)/(2*a);
			return roots;
		}
	}
	
	/**
	 * @param n
	 * @param A
	 * @return A^(1/n)
	 */
	public static double nthRoot(int n, double A) {
		return nthRoot(n, A, .001);
	}
	
	public static double nthRoot(int n, double A, double p) {
		if(A < 0) {
			System.err.println("A < 0");// we handle only real positive numbers
			return -1;
		} else if(A == 0) {
			return 0;
		}
		double x_prev = A;
		double x = A / n;  // starting "guessed" value...
		while(Math.abs(x - x_prev) > p) {
			x_prev = x;
			x = ((n - 1.0) * x + A / Math.pow(x, n - 1.0)) / n;
		}
		return x;
	}

}
