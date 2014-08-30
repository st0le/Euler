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
public class xRangeLong extends AbstractGenerator<Long> {
	private Long start,end,step;

	public xRangeLong(Long start,Long end,Long step)
	{
		if(start < end &&  step < 0)
			throw new IllegalArgumentException("Invalid Range Values!");
		if(start > end &&  step > 0)
			throw new IllegalArgumentException("Invalid Range Values!");
		
		this.start = start;
		this.end = end;
		this.step = step;
	}
	public xRangeLong(Long start,Long end)
	{
		Long step = 1L;
		if(start < end &&  step < 0)
			throw new IllegalArgumentException("Invalid Range Values!");
		if(start > end &&  step > 0)
			throw new IllegalArgumentException("Invalid Range Values!");

		this.start = start;
		this.end = end;
		this.step = step;
	}
	public xRangeLong(Long end)
	{
		Long start = 0L;
		Long step = 1L;
		if(start < end &&  step < 0)
			throw new IllegalArgumentException("Invalid Range Values!");
		if(start > end &&  step > 0)
			throw new IllegalArgumentException("Invalid Range Values!");
		
		this.start = start;
		this.end = end;
		this.step = step;
	}

	@Override
	public boolean hasNext() {
		if (step > 0)
			return end.compareTo(start) > 0;
		else
			return end.compareTo(start) < 0;
	}

	@Override
	public Long next() {
		Long t = start;
		start += step;
		return t;
	}

	@Override
	public Iterator<Long> iterator() {
		return this;
	}
}
