package org.mechaevil.util.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubSequence<E extends Comparable<E>> {

	private E [] x;
	private E [] y;
	private ArrayList<E> lcs;

	private int[][] cost = null;

	public LongestCommonSubSequence(E[] sequence1, E[] sequence2)
	{
		x = sequence1;
		y = sequence2;
		processSequence();
	}

	private void processSequence()
	{
		cost = new int [x.length + 1][y.length + 1];
		for(int i = 0 ; i <= x.length; i++)
		{
			for(int j = 0 ;  j <= y.length; j++)
			{
				if(i == 0 || j == 0)
				{
					cost[i][j] = 0;
				}else
					if( x[i-1].compareTo(y[j-1]) == 0)
						cost[i][j] = cost[i-1][j-1] + 1;
					else
						cost[i][j] = Math.max(cost[i-1][j],cost[i][j-1]);
			}
		}
	}
	
	public int getLCS()
	{
		return cost[x.length][y.length];
	}
	
	public List<E> getSubsequence()
	{
		if(lcs == null)
			lcs = new ArrayList<E>(getLCS());
		else
			lcs.clear();
		
		backTrack(x.length,y.length);
		return lcs;
	}
	
	private void backTrack(int i,int j)
	{
		if( i == 0 || j == 0)
			return;
		else
			if(x[i-1].equals(y[j-1]))
			{
				backTrack(i-1,j-1);
				lcs.add(y[j-1]);
			}else
				if(cost[i-1][j] > cost[i][j-1])
					backTrack(i-1, j);
				else
					backTrack(i, j-1);
	}
}
