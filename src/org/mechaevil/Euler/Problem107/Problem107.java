/**
 * 
 */
package org.mechaevil.Euler.Problem107;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.GraphTheory.PrimsMST;

/**
 * @author 332609
 *
 */
public class Problem107 implements Constants{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here

		String[] lines = grid.split("\n");
		int[][] weights = new int[lines.length][lines[0].length()];
		for(int i = 0; i <lines.length; i++)
		{
			String line = lines[i];
			String[] w = line.split(",");
			for(int j = 0 ; j <w.length; j++)
			{
				if(w[j].equals("-"))
					weights[i][j] = Integer.MAX_VALUE;
				else
					weights[i][j] = Integer.parseInt(w[j]);
			}
		}
		PrimsMST solver = new PrimsMST(weights);
		int[][] edges = solver.getMST();
		int s = 0;
		for(int i = 0 ; i < weights.length; i++)
			for(int j = 0 ; j < i; j++)
				if(weights[i][j] != Integer.MAX_VALUE)
						s += weights[i][j];
		
		for(int i = 0 ; i < edges.length; i++)
		{
			if(edges[i][0] != -1)
				s -= weights[edges[i][0]][edges[i][1]];
		}
		System.out.println("P107 : " + s);

		timer.stopTimer();
		System.out.println(timer);


	}

}
