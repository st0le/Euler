package org.mechaevil.util.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//TODO: Use the O(nlogn) Algorithm...The Following is O(n^2) and finds just one sequence...
public class LongestIncreasingSubsequence<E extends Comparable<E>> {

	private E[] x= null;
	private int[] cost = null;
	private int[] pred = null;
	private int mxSeqEnd;
	private int mxCost;
	
	
	public LongestIncreasingSubsequence(E[] arr)
	{
		x = arr;
		processData();
	}

	private void processData()
	{
		cost = new int [x.length];
		pred = new int [x.length];
		mxCost = 0;
		mxSeqEnd = 0;
		pred[0] = -1;
		for(int i = 0 ; i < x.length; i++)
		{
			int mx = 0;
			for(int j = 0; j < i; j++)
			{
				if(x[i].compareTo(x[j]) > 0 && mx < cost[j])
				{
					mx = cost[j];
					pred[i] = j;
				}
			}
			cost[i] = mx + 1;
			if(cost[i] > mxCost)
			{
				mxCost = cost[i];
				mxSeqEnd = i;
			}
		}
	}

	public int getLIS()
	{
		return mxCost;
	}

	public List<E> getSubSequence()
	{
		ArrayList<E> lis = new ArrayList<E>(getLIS());
		int i = mxSeqEnd ;
		while (i >= 0)
		{
			lis.add(x[i]);
			i = pred[i];
		}
		Collections.reverse(lis);
		return lis;

	}

}
