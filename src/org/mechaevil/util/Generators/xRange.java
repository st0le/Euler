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
public class xRange extends AbstractGenerator<Integer> {
	private Integer start,end,step;

	public xRange(Integer start,Integer end,Integer step)
	{
		if(start < end &&  step < 0)
			throw new IllegalArgumentException("Invalid Range Values!");
		if(start > end &&  step > 0)
			throw new IllegalArgumentException("Invalid Range Values!");
		
		this.start = start;
		this.end = end;
		this.step = step;
	}
	public xRange(Integer start,Integer end)
	{
		Integer step = 1;
		if(start < end &&  step < 0)
			throw new IllegalArgumentException("Invalid Range Values!");
		if(start > end &&  step > 0)
			throw new IllegalArgumentException("Invalid Range Values!");

		this.start = start;
		this.end = end;
		this.step = step;
	}
	public xRange(Integer end)
	{
		Integer start = 0;
		Integer step = 1;
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
	public Integer next() {
		Integer t = start;
		start += step;
		return t;
	}

	@Override
	public Iterator<Integer> iterator() {
		return this;
	}
}
