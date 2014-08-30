/**
 * 
 */
package org.mechaevil.util.Math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 * 
 */
final public class xMath {

	public static final double PHI = (1 + Math.sqrt(5.0)) / 2.0;

	/**
	 * @param num
	 * @return Array of factors
	 */
	public static int[] getFactors(int num) {
		if (num == 0)
			return null;
		ArrayList<Integer> fList = new ArrayList<Integer>();
		fList.add(1);
		fList.add(num);
		int factor ;
		for( factor = 2; factor*factor < num; factor++)
		{
			if(num % factor == 0)
			{
				fList.add(factor);
				fList.add((int) (num/factor));
			}
		}
		if(factor*factor == num)
			fList.add(factor);
		Collections.sort(fList);
		int[] arr = new int[fList.size()];
		for (int i = 0; i < fList.size(); i++)
			arr[i] = fList.get(i);
		return arr;
	}

	/**
	 * @param num
	 * @return Sorted Array containing Prime Factors of the Number.
	 */
	public static int[] getPrimeFactors(long num) {
		if (num == 0)
			return null;
		ArrayList<Integer> fList = new ArrayList<Integer>();
		int factor = 2;
		if (num % factor == 0)
			fList.add(factor);
		while (num % factor == 0) {
			num /= factor;
		}
		factor = 3;
		while (num > 1) {
			if (num % factor == 0)
				fList.add(factor);
			while (num % factor == 0)
				num /= factor;
			factor += 2;
		}
		int[] arr = new int[fList.size()];
		for (int i = 0; i < fList.size(); i++)
			arr[i] = fList.get(i);
		return arr;
	}

	/**
	 * @param num
	 * @return Returns reverse of the number.
	 */
	public static long reverseNumber(long num) {
		long r = 0;
		while (num > 0) {
			r = r * 10 + num % 10;
			num /= 10;
		}
		return r;
	}

	/**
	 * @param num
	 * @return Array of its digits in Order.
	 */
	public static int[] breakNumber(long num) {
		num = Math.abs(num);
		if(num == 0) return new int[]{0};
		int c = 0;
		long r = 0;
		for(;num > 0; r = r*10 + num % 10, num/=10,c++);
		int[]digits = new int[c];

		for(int i = 0 ; i < c;i++,r/=10)
			digits[i] = (int) (r % 10);
		return digits;
	}

	/**
	 * @param num
	 * @return True if number is a Palindrome.
	 */
	public static boolean isPalindrome(long num) {
		return num == reverseNumber(num);
	}

	/**
	 * @param a
	 * @param b
	 * @return Return Greatest Common Divisor of 'a' and 'b'.
	 */
	public static long gcd(long a, long b) {
		while (b > 0) {
			long t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

	/**
	 * @param a
	 * @param b
	 * @return Return Greatest Common Divisor of 'a' and 'b'.
	 */
	public static int gcd(int a, int b) {
		while (b > 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

	/**
	 * @param a
	 * @param b
	 * @return Least Common Multiple of 'a' and 'b'.
	 */
	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	/**
	 * @param a
	 * @param b
	 * @return Least Common Multiple of 'a' and 'b'.
	 */
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	/**
	 * @param n
	 * @return Number of Divisors of the Number.
	 */
	public static long ndiv(long n) {
		if (n <= 1)
			return 1;
		long c = 0;
		long factor = 2;
		while (n % factor == 0) {
			n /= factor;
			c++;
		}
		long count = c + 1;
		factor = 3;
		while (n > 1) {
			c = 0;
			while (n % factor == 0) {
				n /= factor;
				c++;
			}
			factor += 2;
			count *= (c + 1);
		}
		return count;
	}

	/**
	 * @param n
	 * @return Returns Factorial of n.
	 */
	public static BigInteger fact(BigInteger n) {
		BigInteger p = new BigInteger("1");

		while (n.compareTo(BigInteger.ONE) > 0) {
			p = p.multiply(n);
			n = n.subtract(BigInteger.ONE);
		}
		return p;
	}

	static private long[] factorials = { 1L /* 0 */, 1L /* 1 */, 2L /* 2 */,
		6L /* 3 */, 24L /* 4 */, 120L /* 5 */, 720L /* 6 */, 5040L /* 7 */,
		40320L /* 8 */, 362880L /* 9 */, 3628800L /* 10 */,
		39916800L /* 11 */, 479001600L /* 12 */, 6227020800L /* 13 */,
		87178291200L /* 14 */, 1307674368000L /* 15 */,
		20922789888000L /* 16 */, 355687428096000L /* 17 */,
		6402373705728000L /* 18 */, 121645100408832000L /* 19 */,
		2432902008176640000L /* 20 */
	};

	/**
	 * TABLE LOOKUP FACTORIAL COMPUTATION calculate n factorial. Only good for 0
	 * <= n <= 20
	 * 
	 * @author Roedy Green works by table look up
	 */
	public static long factorial(int n) {
		if (!(0 <= n && n <= 20)) {
			throw new IllegalArgumentException(
			"factorial can only handle 0 <= n <= 20");
		}
		return factorials[n];
	}

	/**
	 * @param n
	 * @return Sum of the digits of the number n.
	 */
	public static int sumDigits(BigInteger n) {
		int s = 0;
		for (char ch : n.toString().toCharArray())
			s += ch - '0';
		return s;
	}

	/**
	 * @param n
	 * @return Sum of the digits of the number n.
	 */
	public static int sumDigits(long n) {
		int s = 0;
		while (n > 0) {
			s += n % 10;
			n /= 10;
		}
		return s;
	}

	/**
	 * @param n
	 * @return Sum of the digits of the number n.
	 */
	public static int sumDigits(int n) {
		int s = 0;
		while (n > 0) {
			s += n % 10;
			n /= 10;
		}
		return s;
	}

	/**
	 * @param n
	 * @return Add Digits of a number string.
	 */
	public static int sumDigits(String n)
	{
		int s = 0;
		for(char ch : n.toCharArray())
			s += ch - '0';
		return s;
	}

	/**
	 * @param n
	 * @return The sum of divisors of n.
	 */
	public static int sdiv(int n) {
		int prod = 1;
		for (int k = 2; k * k <= n; ++k) {
			int p = 1;
			while (n % k == 0) {
				p = p * k + 1;
				n /= k;
			}
			prod *= p;
		}
		if (n > 1)
			prod *= 1 + n;
		return prod;
	}

	/**
	 * @param n
	 * @return returns True if number is a Perfect Square.
	 */
	public static boolean isPerfectSquare(long n) {
		int h = (int) (n & 0xF); // h is the last hex "digit"
		if (h > 9)
			return false;
		// Use lazy evaluation to jump out of the if statement as soon as
		// possible
		if (h != 2 && h != 3 && h != 5 && h != 6 && h != 7 && h != 8) {
			long t = (long) Math.floor(Math.sqrt((double) n) + 0.5);
			return t * t == n;
		}
		return false;
	}

	/**
	 * @param N
	 * @return Returns array of 'Sum of Divisors' of the index.
	 */
	public static int[] sieveSumOfDivisors(int N) {
		int[] sdivs = new int[N + 1];
		for (int i = 0; i <= N; i++)
			sdivs[i] = 1 + i;
		for (int f = 2; f <= N / 2; f++)
			for (int g = 2 * f; g <= N; g += f)
				sdivs[g] += f;
		return sdivs;
	}


	/**
	 * @param x
	 * @param n
	 * @return Exponentiation by Squaring (x^n)
	 */
	public static long power(long x, long n) {
		long result = 1;
		while (n > 0) {

			if ((n & 1) == 1) {
				result *= x;
				n -= 1;
			}
			x *= x;
			n /= 2; /* integer division, rounds down */
		}
		return result;
	}

	/**
	 * @param a
	 * @return Checks if the number is a 9-Pandigital
	 */
	public static boolean isPandigital9(long a) {
		if (a < 123456789 || a > 987654321)
			return false;
		int[] digits = new int[10];
		while (a > 0) {
			if (digits[(int) (a % 10)]++ > 1)
				return false;
			a /= 10;
		}
		for (int i = 1; i < 10; i++)
			if (digits[i] != 1)
				return false;
		return true;
	}

	/**
	 * @param a
	 * @return Checks if the number is a 10-Pandigital
	 */
	public static boolean isPandigital10(long a) {
		if (a < 1023456789 || a > 9876543210L)
			return false;
		int[] digits = new int[10];
		while (a > 0) {
			if (digits[(int) (a % 10)]++ > 1)
				return false;
			a /= 10;
		}
		for (int i = 0; i < 10; i++)
			if (digits[i] != 1)
				return false;
		return true;
	}

	/**
	 * @param a
	 * @return Checks if the number is a Permutation of another
	 */
	public static boolean isPermutation(long a, long b) {
		int[] digits = new int[10];
		for (; a > 0; digits[(int) (a % 10)]++, a /= 10)
			;
		for (; b > 0; digits[(int) (b % 10)]--, b /= 10)
			;
		for (int d : digits)
			if (d != 0)
				return false;
		return true;
	}

	/**
	 * @param a
	 * @return Checks if the number is a Permutation of another
	 */
	public static boolean isPermutation(int a, int b) {
		int[] digits = new int[10];
		for (; a > 0; digits[(int) (a % 10)]++, a /= 10)
			;
		for (; b > 0; digits[(int) (b % 10)]--, b /= 10)
			;
		for (int d : digits)
			if (d != 0)
				return false;
		return true;
	}

	/**
	 * @param a
	 * @return returns Sorted Digits of Number.
	 */
	public static long sortNumber(long n) {
		int[] digits = new int[10];
		for (; n > 0; digits[(int) (n % 10)]++, n /= 10);
		long r = 0;
		for(int i = 1 ; i < 10; i++)
		{
			for(int j = 0; j < digits[i]; j++)
				r = r * 10 + i;
		}
		return r;
	}

	/**
	 * Extended Euclidean Algorithm.
	 * 
	 * @param a
	 * @param b
	 * @return {x,y,gcd} where ax + by = gcd
	 */
	public static int[] xgcd(int a, int b) {
		int x = 0, lastx = 1;
		int y = 1, lasty = 0;
		while (b != 0) {
			int quotient = a / b;

			int temp = b;
			b = a % b;
			a = temp;

			temp = x;
			x = lastx - quotient * x;
			lastx = temp;

			temp = y;
			y = lasty - quotient * y;
			lasty = temp;
		}
		return new int[] { a,lastx, lasty};
	}
	/**
	 * Extended Euclidean Algorithm.
	 * 
	 * @param a
	 * @param b
	 * @return {x,y,gcd} where ax + by = gcd
	 */
	public static long[] xgcd(long a, long b) {
		long x = 0, lastx = 1;
		long y = 1, lasty = 0;
		while (b != 0) {
			long quotient = a / b;

			long temp = b;
			b = a % b;
			a = temp;

			temp = x;
			x = lastx - quotient * x;
			lastx = temp;

			temp = y;
			y = lasty - quotient * y;
			lasty = temp;
		}
		return new long[] { a,lastx, lasty };
	}



	/**
	 * Solves linear Congruence Relation
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return x where ax = b (mod n)
	 */
	public static Integer solveLinear(int a, int b, int n) {
		int[] g = xgcd(a, n);
		if (b % g[0] != 0)
			return null;
		return ((b / g[0]) * g[1]) % n;
	}

	/**
	 * @param a
	 * @param m
	 * @return Inverse mod of (a,n) (ie, a^(-1) = x (mod m) => ax = 1 (mod m) ) 
	 */
	public static Integer inverseMod(int a,int m)
	{
		return solveLinear(a, 1, m);
	}

	/**
	 * @param coefficient
	 * @param x
	 * @return Solves a polynomial equation.
	 */
	public static double solvePolynomial(double coefficient[], double x) {
		double fx = 0;
		double powx = 1.0;
		for (int i = 0; i < coefficient.length; i++, powx *= x) {
			fx += coefficient[i] * powx;
		}
		return fx;
	}


	/**
	 * TODO: Change Recursive to DP.
	 * @param sum
	 * @param values
	 * @param i
	 * @return Returns no. of Partition Sets that sum upto a value.
	 */
	public static int partitionSet(int sum, int[] values, int i) {
		if (sum < 0 || i == values.length)
			return 0;
		if (sum == 0)
			return 1;
		return partitionSet(sum - values[i], values, i)
		+ partitionSet(sum, values, i + 1);

	}


	/**
	 * @param N
	 * @return Integer Partition of N using Integer 1..N
	 */
	public static int[][] partitionCount(int N )
	{
		int [][] p = new int[N+1][N+1];

		for(int n = 1; n <= N; n++)
		{
			for(int k = N; k > 0; k--)
			{
				if(k > n) p[n][k] = 0;
				else
					if(k == n) p[n][k] = 1;
					else
						p[n][k] = p[n][k+1] + p[n-k][k];
			}
		}
		return p;
	}

	/**
	 * @param t
	 * @param l
	 * @return Appends to Numbers.
	 */
	public static long appendNumber(long t,long l)
	{
		long p = 1;
		while(p * 10 <= l) p *= 10;
		return t * p * 10 + l;
	}

	/**
	 * @param n
	 * @return True if n is Triangle Number.
	 */
	public static boolean isTriangleNumber(long n)
	{
		return isPerfectSquare(1 + 8  * n);
	}

	/**
	 * @param n
	 * @return True if n is Pentagonal Number.
	 */
	public static boolean isPentagonalNumber(long n)
	{
		return (isPerfectSquare(1 + 24  * n) && ( (Math.floor(Math.sqrt(1 + 24 * n)) + 1) % 6 == 0));
	}

	/**
	 * @param n
	 * @return True if n is Hexagonal Number.
	 */
	public static boolean isHexagonalNumber(long n)
	{
		return(isPerfectSquare(1 + 8  * n) && ( (Math.floor(Math.sqrt(1 + 8 * n)) + 1) % 4 == 0));
	}

	/**
	 * @param n
	 * @return Return's nth Triangle Number.
	 */
	public static long getTriangleNumber(long n)
	{
		return n * (n + 1)/2;
	}

	/**
	 * @param n
	 * @return Return's nth Square Number.
	 */
	public static long getSquareNumber(long n)
	{
		return n * n;
	}

	/**
	 * @param n
	 * @return Return's nth Pentagonal Number.
	 */
	public static long getPentagonalNumber(long n)
	{
		return n * (3*n - 1)/2;
	}

	/**
	 * @param n
	 * @return Return's nth Hexagonal Number.
	 */
	public static long getHexagonalNumber(long n)
	{
		return n * (2*n - 1);
	}

	/**
	 * @param n
	 * @return Return's nth Heptagonal Number.
	 */
	public static long getHeptagonalNumber(long n )
	{
		return n * (5*n - 3) / 2;
	}

	/**
	 * @param n
	 * @return Return's nth Octagonal Number.
	 */
	public static long getOctagonalNumber(long n )
	{
		return n * (3*n - 2);
	}

	/**
	 * @param N
	 * @return Array Containing Euler Totient Values.
	 */
	public static long[] sieveEulerTotientFunction(int N)
	{
		long[] phi = new long[N + 1];
		int i;
		for( i = 2 ; i <= N ; ++i ) 
			phi[i] = i - 1;

		for( i = 2 ; i <= N ; ++i )
		{
			if( phi[i] == i - 1 ) //prime...
				for(int j = N / i ; j >= 2 ; --j ) 
					phi[i * j] -= phi[j];
		}
		return phi;
	}

	/**
	 * @param N
	 * @return Number of Parititions of Possible.
	 */
	public static long[] integerPartition(int N)
	{
		long[] arr = new long[N + 1];
		arr[0] = 1;
		for(int i = 1;  i <=  N; i++)
		{
			int sign = 1;
			arr[i]  = 0;
			for(int j = 1; j <= N; j++)
			{
				int fx = j * (3*j - 1) / 2;
				if( fx > i) break;
				arr[i] = arr[i] + sign * arr[i-fx];
				fx = j * (3*j + 1) / 2;
				if( fx > i) break;
				arr[i] = arr[i] + sign * arr[i-fx];
				sign = -sign; 
			}
		}
		return arr;
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return Calculates (a*b) % c, Considering overflow.
	 */
	public static long mulMod(long a,long b,long c){
		long x = 0, y = a % c;
		while(b > 0){
			if(b%2 == 1)
			{
				x = (x+y)%c;
			}
			y = (y*2)%c;
			b /= 2;
		}
		return x%c;
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return Calculates (a^b % c)
	 */
	public static int powMod(int a,int b,int c){
		long x=1,y=a;
		while(b > 0){
			if(b%2 == 1){
				x=(x*y)%c;
			}
			y = (y*y)%c;
			b /= 2;
		}
		return (int) (x%c);
	}


	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return Calculates (a^b % c)
	 */
	public static long powMod(long a,long b,long c){
		long x=1,y=a;
		while(b > 0){
			if(b%2 == 1){
				x=(x*y)%c;
			}
			y = (y*y)%c;
			b /= 2;
		}
		return (x%c);
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return (a^b) % c
	 */
	public static long powMod(long a,int b,long c){
		return BigInteger.valueOf(a).pow(b).mod(BigInteger.valueOf(c)).longValue();
	}

	/**
	 * @param num
	 * @return Number of factors of num. 
	 */
	public static int getNumberFactors(long num)
	{
		int c = 2;
		for(int i = 2; i < num; i++)
			if(num % i == 0)
				c++;
		return c;
	}

	/**
	 * @param N
	 * @return Array of Integers representing , Number of Factors of their index values.
	 */
	public static int []sieveNumberOfFactors(int N)
	{
		int[] tau = new int[N+1];
		Arrays.fill(tau, 1);
		for(int i = 2; i <= N; i++)
		{
			for(int factor = i; factor <= N; factor+=i)
				tau[factor]++;
		}
		return tau;
	}

	/**
	 * @param n
	 * @param r
	 * @return n!/(r!(n-r)!)
	 */
	public static BigInteger chooseBig(int n,int r)
	{
		BigInteger p = BigInteger.ONE;
		int max = Math.max(n-r, r);
		int min = Math.min(n-r, r);
		while(n > max)
		{
			p  = p.multiply(BigInteger.valueOf(n));
			n--;
		}
		while(min > 1)
		{
			p  = p.divide(BigInteger.valueOf(min));
			min--;
		}
		return p;
	}
	
	public static long choose(int n , int k)
	{
		if(k > n) return 0;
		int[] primes = new PrimeSieve(n+1).toPrimitiveArray();
		long result = 1;
		int f = 0;
		
		for(int p = 0; p < primes.length; p++)
		{
			int prime = primes[p];
			int x = n;
			f = 0;
			while(x >= prime)
			{
				x /= prime;
				f += x;
			}
			x = k;
			while(x >= prime)
			{
				x /= prime;
				f -= x;
			}
			x = n-k;
			while(x >= prime)
			{
				x /= prime;
				f -= x;
			}
			while(f > 0)
			{
				result *= prime;
				f--;
			}
		}
		return result;
	}



	/**
	 * @param a1
	 * @param m1
	 * @param a2
	 * @param m2
	 * @return Solve CRT for 2 Congruence.
	 */
	public static Integer chineseRemainderTheorem(int a1,int m1,int a2,int m2)
	{
		int[] eea = xMath.xgcd(m1,m2);
		if(eea[0] != 1) 
			throw new IllegalArgumentException("m1 and m2 must be coprime.");

		int S = (a1 + (a2-a1)*eea[1]*m1) % (m1*m2);
		return (S < 0)? S + (m1 * m2):S;
	}
	/**
	 * @param a1
	 * @param m1
	 * @param a2
	 * @param m2
	 * @return Solve CRT for 2 Congruence.
	 */
	public static Long chineseRemainderTheorem(long a1,long m1,long a2,long m2)
	{
		long[] eea = xMath.xgcd(m1,m2);
		if(eea[0] != 1) 
			throw new IllegalArgumentException("m1 and m2 must be coprime.");

		long S = (a1 + (a2-a1)*eea[1]*m1) % (m1*m2);
		return (S < 0)? S + (m1 * m2):S;
	}

	/**
	 * @param n
	 * @return Sum of the digits till it's less than 10
	 */
	public static int digitalRoot(int n)
	{
		if(n < 0) n=-n;
		return (n % 9 == 0)? 9 : n % 9;
	}

	/**
	 * @param n
	 * @return Sum of the digits till it's less than 10
	 */
	public static int digitalRoot(long n)
	{
		if(n < 0) n=-n;
		return (int) ((n % 9L == 0)? 9 : n % 9L);
	}


	/**
	 * @param a
	 * @param b
	 * @return rangeProduct a * (a+1) * ... b 
	 */
	public static BigInteger rangeProduct(int a,int b)
	{
		if(a > b) return BigInteger.ZERO;
		BigInteger bigB = BigInteger.valueOf(b);
		BigInteger prod = BigInteger.ONE;
		for(BigInteger i = BigInteger.valueOf(a); bigB.compareTo(i) >= 0; i = i.add(BigInteger.ONE))
		{
			prod = prod.multiply(i);
		}
		return prod;
	}


	/**
	 * @param n
	 * @param r
	 * @return n!/(n-r)!
	 */
	public static BigInteger permutation(int n,int r)
	{
		if(n <= r) return BigInteger.ONE;
		if(r == 1) return BigInteger.valueOf(n);
		return rangeProduct(r+1,n);

	}
	
	/**
	 * @param N
	 * @return Euler Totient Function (Number of Integers (1..n-1) which are coprime with n
	 */
	public static long eulerTotient(long N)
	{
		if(N == 0) return 1;
		long totient, q, k;
		totient = q = N;
		if (q % 2 == 0)
		{
			totient /= 2;
			do
			{
				q /= 2;
			}
			while (q % 2 == 0);
		}
		if (q % 3 == 0)
		{
			totient = totient * 2 / 3;
			do
			{
				q /= 3;
			}
			while (q % 3 == 0);
		}
		k = 5;
		while (k * k <= q)
		{
			if (k % 3 != 0 && q % k == 0)
			{
				totient = totient * (k - 1) / k;
				do
				{
					q /= k;
				}
				while (q % k == 0);
			}
			k += 2;
		}
		if (q > 1)
		{
			totient = totient * (q - 1) / q;
		}
		return totient;
	}


}
