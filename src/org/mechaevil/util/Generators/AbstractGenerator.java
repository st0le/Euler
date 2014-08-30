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
public abstract class AbstractGenerator<E> implements Iterator<E>,Iterable<E> {
	
	@Override
	public final void remove(){
		throw new UnsupportedOperationException("Remove not allowed!");
	}
}
