/**
 * 
 */
package org.mechaevil.util.Generators;

import java.util.Iterator;

/**
 * @author 332609
 * @param <E>
 *
 */
public class FibonacciGenerator extends AbstractGenerator<Long> {

	Long a = 0L,b = 1L;
	Long limit = Long.MAX_VALUE;
	int count = 0;
	
	public FibonacciGenerator(Integer limit)
	{
		this.limit = limit.longValue();
	}
	
	public FibonacciGenerator(Long limit)
	{
		this.limit = limit;
	}
	
	@Override
	public boolean hasNext() {
		if(limit == Long.MAX_VALUE)
			return a >= 0;
		else
			return a < limit;
	}

	@Override
	public Long next() {
		Long t = a;
		b = a + (a = b);
		return t;
	}

	@Override
	public Iterator<Long> iterator() {
		// 
		return this;
	}
}
