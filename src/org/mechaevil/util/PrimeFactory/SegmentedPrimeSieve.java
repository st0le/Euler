/**
 * 
 */
package org.mechaevil.util.PrimeFactory;

import java.util.BitSet;
import java.util.Iterator;

/**
 * @author 332609
 *
 */
public class SegmentedPrimeSieve implements Iterable<Long> {

	private long lowBound = 0; 
	private int segmentLen = 0;
	private BitSet primeList = null;

	public SegmentedPrimeSieve(long lowBound,int segmentLen)
	{
		this.lowBound = lowBound;
		this.segmentLen = segmentLen;
		beginSegmentedSieve();
	}

	private void beginSegmentedSieve() {
		int maxSieveLen = (int)Math.sqrt(lowBound) + 1;
		PrimeSieve table = new PrimeSieve(maxSieveLen + 1);
		primeList = new BitSet(segmentLen >> 1);
		primeList.set(0, primeList.size(),true);
		for(int prime = 3;prime <table.getMaxLimit();prime++)
		{
			if(table.isPrime(prime))
			{
				int closeFactor = prime - (int)(lowBound % (long)prime);
				for(int factor = closeFactor;factor  < segmentLen; factor += prime )
				{
					if((factor & 1) == 1)
					{
						primeList.clear(factor >> 1);
					}
				}

			}
		}
	}

	public boolean isPrime(long num) 
	{ 
		if( (num - lowBound) < segmentLen)
		{
			if( (num & 1) == 0) 
				return ( num == 2); 
			else 
				return primeList.get((int) ((num-lowBound)>>1));
		}
		return false;
	}

	@Override
	public Iterator<Long> iterator() {
		return new SegmentedPrimeIterator(primeList,lowBound,segmentLen >> 1);
	}

}
