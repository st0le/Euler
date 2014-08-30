/**
 * 
 */
package org.mechaevil.util.GraphTheory;

/**
 * @author 332609
 *
 */
public class PrimsMST {
	
	int[][] weights = null;
	
	public PrimsMST(int[][] weights)
	{
		this.weights = weights;
	}
	
	public int[][] getMST()
	{
		boolean[] visited = new boolean[weights.length];
		int[][] visitedNodes = new int[weights.length][2];
		for(int i = 0 ; i < visitedNodes.length; i++)
			visitedNodes[i][0] = visitedNodes[i][1] = -1;  
		int vcount = 0;
		visited[vcount] = true;
		while(vcount < weights.length)
		{
			int minDistance = Integer.MAX_VALUE;
			int minFrom=0,minTo=0;
			int from,to;
			boolean found = false;
			for(from = 0;from < weights.length; from++)
			{
				if(visited[from])
				{
					for( to = 0; to < weights.length; to++)
					{
						if(!visited[to])
						{
							if( minDistance > weights[from][to] )
							{
								found = true;
								minDistance = weights[from][to];
								minFrom = from;
								minTo = to;
							}
						}
					}
				}
			}
			if(!found) break;
			//found next minimum connecting edge
			visitedNodes[vcount][0] = minFrom;
			visitedNodes[vcount][1] = minTo;
			vcount++;
			visited[minFrom]  = visited[minTo] = true;
		}
		return visitedNodes;
	}

}
