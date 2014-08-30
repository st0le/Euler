/**
 * 
 */
package org.mechaevil.Euler.Problem061;

import java.util.ArrayList;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.xDebug;
import org.mechaevil.util.Math.xMath;

/**
 * @author 332609
 *
 */
public class Problem061 {

	private static  ArrayList<Figurate> list;
	private static class Figurate  
	{
		public int type;
		public long n;
		public Figurate(int t,long num)
		{
			type = t; n = num;
		}
		@Override
		public String toString() {
			return n + "[" + type + "]";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		list = new ArrayList<Figurate>();
		long t;
		for(long n = 0; n < 10000; n++)
		{
			t = xMath.getTriangleNumber(n);
			if(((t >= 1000) && (t < 10000)))
				list.add(new Figurate(3,t));
			t = xMath.getSquareNumber(n);
			if(((t >= 1000) && (t < 10000)))
				list.add(new Figurate(4,t));
			t = xMath.getPentagonalNumber(n);
			if(((t >= 1000) && (t < 10000)))
				list.add(new Figurate(5,t));
			t = xMath.getHeptagonalNumber(n);
			if(((t >= 1000) && (t < 10000)))
				list.add(new Figurate(6,t));
			t = xMath.getHexagonalNumber(n);
			if(((t >= 1000) && (t < 10000)))
				list.add(new Figurate(7,t));
			t = xMath.getOctagonalNumber(n);
			if(((t >= 1000) && (t < 10000)))
				list.add(new Figurate(8,t));
		}
		Figurate[] set = new Figurate[6];
		if(findSet(set,0))
		{
			xDebug.display1D(set);
			long s = 0;
			for(Figurate f:set)
				s += f.n;

			System.out.println("P061 : " + s);
		}else
			System.out.println("No Subset Found!");

		timer.stopTimer();
		System.out.println(timer);
	}

	private static boolean findSet(Figurate[] set,int c) {
		if( c == 0)
		{
			//find first octal number
			for(int octal = 0; octal < list.size(); octal++)
				if(list.get(octal).type == 8)
				{
					set[c] = list.get(octal);
					if(findSet(set, c+1))
						return true;
				}
		}else
			if(c == set.length)
			{
				return (set[0].n / 100) == (set[set.length-1].n % 100);  
			}
			else
			{
				long last2Digits = set[c-1].n % 100; 
				for(int i = 0; i < list.size(); i++)
				{
					boolean found = false;
					for(int t = 0; t < c && !found; t++)
					{
						found = (set[t].type == list.get(i).type);
					}
					if(!found && (list.get(i).n / 100 == last2Digits))
					{
						set[c] = list.get(i);
						if(findSet(set,c+1))
							return true;
					}
				}
				return false;
			}
		return false;
	}



}
