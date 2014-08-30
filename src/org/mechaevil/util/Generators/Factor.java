/**
 * 
 */
package org.mechaevil.util.Generators;

import java.util.Iterator;

/**
 * @author 332609
 *
 */
public class Factor extends AbstractGenerator<Long> {
	Long factor;
	Long num;
	public Factor(Long p)
	{
		factor = 1L;
		num = p;
	}
	@Override
	public boolean hasNext() {
		return factor.compareTo(num) < 0;
	}

	@Override
	public Long next() {
		while(factor < num && (num % factor != 0))
				factor++;
		return factor++;
	}

	@Override
	public Iterator<Long> iterator() {
		return this;
	}

}
