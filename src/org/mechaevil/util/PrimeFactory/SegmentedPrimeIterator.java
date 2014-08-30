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
public class SegmentedPrimeIterator implements Iterator<Long> {

	private final BitSet mybset ;
	private int index  = 0;
	private int maxIndex = 0;
	private long lowBound = 0;

	public SegmentedPrimeIterator(BitSet b,long lowBound,int mIndexLimit)
	{
		mybset = b;
		index = 0;
		this.lowBound = lowBound;
		maxIndex  = mIndexLimit;
	}
	@Override
	public boolean hasNext() {
		return (index + 1 <= maxIndex) && (mybset.nextSetBit(index + 1) >= 0) && (mybset.nextSetBit(index + 1) <= maxIndex);
	}

	@Override
	public Long next() {
		index = mybset.nextSetBit(index);
		return lowBound + (2 * (index++) + 1);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not Supported!");
	}

}
