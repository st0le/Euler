/**
 * 
 */
package org.mechaevil.util.GraphTheory;

import java.util.ArrayList;

/**
 * @author 332609
 *
 */
public class DijkstraShortestPath {

	int [][]weight = null;
	int vertexCount;
	//weights is a 2D array.
	//Integer.Max_value = no link
	// >= 0, link present.
	public DijkstraShortestPath(int [][] weight)
	{
		for(int i = 0 ; i < weight.length;i++)
		{
			if(weight.length != weight[i].length)
				throw new IllegalArgumentException("Rows and Columns must be equal.");
		}
		this.weight = weight;
		vertexCount = weight.length; 
	}

	public Object[] findShortestPath(int src,int dst)
	{
		Integer [] previousNode = new Integer[vertexCount];
		Integer [] bestDistance = new Integer[vertexCount];
		ArrayList<Integer> nodesLeft = new ArrayList<Integer>();

		for(int i = 0; i < vertexCount; i++ )
		{
			if(i != src) nodesLeft.add(i);
			bestDistance[i] = weight[src][i];
			if(bestDistance[i] != Integer.MAX_VALUE)
			{
				previousNode[i] = src;
			}
		}
		while(!nodesLeft.isEmpty())
		{
			//find minimum edge from visited nodes
			int minNodeIndex = 0;
			for(int i = 1; i < nodesLeft.size();i++)
			{
				if(bestDistance[nodesLeft.get(i)] < bestDistance[nodesLeft.get(minNodeIndex)])
					minNodeIndex = i;
			}
			int minNode = nodesLeft.get(minNodeIndex);
			nodesLeft.remove(minNodeIndex);
			for(int i = 0; i < vertexCount; i++)
			{
				if( (bestDistance[minNode] != Integer.MAX_VALUE)
						&& (weight[minNode][i] != Integer.MAX_VALUE)
						&& (bestDistance[minNode] + weight[minNode][i] < bestDistance[i])
				)
				{
					bestDistance[i] = bestDistance[minNode] + weight[minNode][i];
					previousNode[i] = minNode;
				}
			}
		}
		//Build Path...
		if(dst >=0)
		{
			ArrayList<Integer> trace = new ArrayList<Integer>();
			Integer index = dst;
			while(index != src)
			{
				trace.add(0,index);
				if(previousNode[index] == null) return null; //no path available
				index = previousNode[index];
			}
			trace.add(0,src);
			return trace.toArray();
		}else
		{
			return bestDistance;
		}
	}

	public Object[] findShortestPath(int src)
	{
		return findShortestPath(src,-1);
	}



}
