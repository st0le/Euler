/**
 * 
 */
package org.mechaevil.util.PrimeFactory;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * @author 332609
 *
 */

//Sieve of Eratosthenes (Optimized using BitSet) 
public class PrimeSieve implements Iterable<Integer>
{ 
	private int maxLimit; 
	private BitSet primeList;


	public PrimeSieve() 
	{ 
		maxLimit = 10000000; //default
		beginSieve(maxLimit);
	} 

	public PrimeSieve(int mLimit) 
	{ 
		maxLimit = mLimit;
		beginSieve(maxLimit);
	} 

	private void beginSieve(int mLimit) 
	{ 
		primeList = new BitSet(mLimit>>1); 
		primeList.set(0,primeList.size(),true); 

		int sqroot = (int) Math.sqrt(mLimit); 
		primeList.clear(0); 
		for(int num = 3; num <= sqroot; num+=2) 
		{ 
			if( primeList.get(num >> 1) ) 
			{ 
				int inc = num << 1;
				for(int factor = num * num; factor < mLimit; factor += inc) 
				{ 
					//if( ((factor) & 1) == 1) 
					//{ 
					primeList.clear(factor >> 1); 
					//} 
				} 
			} 
		} 
	} 

	public boolean isPrime(int num) 
	{ 
		if( num < maxLimit)
		{
			if( (num & 1) == 0) 
				return ( num == 2); 
			else 
				return primeList.get(num>>1);
		}
		return false;
	} 

	public int countPrimes(int mLimit) 
	{ 
		int count = (mLimit < 2)? 0:1; //2 is prime 
		for(int num = 3; num < mLimit; num += 2) 
			if( primeList.get(num >> 1) ) 
				count++; 
		return count; 
	} 

	public int countPrimes() 
	{ 
		return countPrimes(maxLimit); 
	} 

	public int getMaxLimit() {
		return maxLimit;
	}

	public ArrayList<Integer> toArray()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2); 
		for(int num = 3; num < maxLimit; num += 2) 
			if( primeList.get(num >> 1) ) 
				list.add(num);
		return list;
	}

	public int[] toPrimitiveArray()
	{
		if(maxLimit > 2)
		{
			int [] primes = new int[countPrimes()];
			primes[0] = 2;
			
			for(int num = 3,c = 1; num < maxLimit; num += 2) 
				if( primeList.get(num >> 1) ) 
					primes[c++] = num;
			return primes;
		}
		return null;
	}

	public PrimeIterator iterator()
	{
		return new PrimeIterator(primeList,maxLimit>>1);
	}

}