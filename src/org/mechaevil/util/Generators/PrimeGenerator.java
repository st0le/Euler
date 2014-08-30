/**
 * 
 */
package org.mechaevil.util.Generators;

import java.math.BigInteger;
import java.util.Iterator;

import org.mechaevil.util.Generators.AbstractGenerator;

/**
 * @author 332609
 *
 */
public class PrimeGenerator extends AbstractGenerator<BigInteger> { 
	 
    private BigInteger p = BigInteger.ONE; 
 
    @Override 
    public boolean hasNext() { 
        return true; 
    } 
 
    @Override 
    public BigInteger next() { 
        p = p.nextProbablePrime(); 
        return p; 
    } 
 
    @Override 
    public Iterator<BigInteger> iterator() { 
        return new PrimeGenerator(); 
    } 
} 
 
