/**
 * 
 */
package org.mechaevil.Euler.Problem035;

import java.util.HashSet;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem035 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		final int N = 1000000;
		HashSet <Integer> hashTable = new HashSet<Integer>();
		PrimeSieve table = new PrimeSieve(N);
		hashTable.add(2);
		hashTable.add(3);
		hashTable.add(5);
		hashTable.add(7);
		for(int i = 11; i < table.getMaxLimit(); i+=2 )
		{
			if(table.isPrime(i))
			{
				if(!hashTable.contains(i) && isCircularPrime(table,i,hashTable))
				{
					//System.out.println(i);
				}
			}
		}
		System.out.println("P035 : " + hashTable.size());

		timer.stopTimer();
		System.out.println(timer);


	}

	private static boolean isCircularPrime(PrimeSieve t,int i, HashSet<Integer> hashTable) {
		// 
		int [] rotations = new int[10];
		int c = 0;
		int hold = i;
		int p = 1;
		while(p*10 <= i) p*=10;
		do
		{
			rotations[c++] = i;
			i = (i % 10) * p + (i / 10);
			if(!t.isPrime(i)) return false;
		}while(i != hold);
		
		for( i = 0; i < c; i++)
			hashTable.add(rotations[i]);
		return true;
	}

}
