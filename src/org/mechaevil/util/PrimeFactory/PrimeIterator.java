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
public class PrimeIterator implements Iterator<Integer> {

	private final BitSet mybset ;
	private int index  = 0;
	private int maxIndex = 0;

	public PrimeIterator(BitSet b,int mIndexLimit)
	{
		mybset = b;
		index = 0;
		maxIndex  = mIndexLimit;
	}
	@Override
	public boolean hasNext() {
		return (index + 1 <= maxIndex) && (mybset.nextSetBit(index + 1) >= 0) && (mybset.nextSetBit(index + 1) <= maxIndex);
	}

	@Override
	public Integer next() {
		if(index == 0)
		{
			index = 1;
			return 2;
		}
		index = mybset.nextSetBit(index);
		return 2 * (index++) + 1;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not Supported!");
	}

}
