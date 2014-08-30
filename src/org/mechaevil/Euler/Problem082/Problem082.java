/**
 * 
 */
package org.mechaevil.Euler.Problem082;

import java.util.ArrayList;
import java.util.Arrays;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.GraphTheory.DijkstraShortestPath;

/**
 * @author 332609
 *
 */
public class Problem082 implements Constants{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 

		StopWatch timer = new StopWatch();
		timer.startTimer();

		//... your Code here
		//256MB Heap
		//Will Provide Alternate Solution after checking the forums. 
		String []rows = grid.split("\n");
		int[][]matrix = new int[rows.length][rows[0].split(",").length];
		int rowIndex = 0;
		for(String row : rows)
		{
			String[]cells = row.split(",");
			for(int j = 0; j < cells.length; j++)
				matrix[rowIndex][j] = Integer.parseInt(cells[j]);
			rowIndex++;
		}
		int r = matrix.length;
		int c = matrix[0].length;
		int[][] weights = new int[r*c][r*c];
		
		for(int i = 0 ; i < r*c; i++)
		{
			Arrays.fill(weights[i], Integer.MAX_VALUE);
			weights[i][i] = 0;
		}
		
		for(int i = 0 ; i <r; i++)
		{
			for(int j = 0 ; j <c; j++)
			{
				int x = i;
				int y = j;
				int _x,_y;
				//up
				if( x >= 1 )
				{
					_x = x - 1; _y = y;
					weights[x*r+y][_x*r+_y] = matrix[x][y];
				}
				//down
				if( x + 1 < r )
				{
					_x = x + 1; _y = y;
					weights[x*r+y][_x*r+_y] = matrix[x][y];
				}
				//forward
				if( y+1 < c )
				{
					_x = x ; _y = y + 1;
					weights[x*r+y][_x*r+_y] = matrix[x][y];
				}
			}
		}
		ArrayList<Integer> sources = new ArrayList<Integer> ();
		ArrayList<Integer> destinations = new ArrayList<Integer> ();
		
		for(int x = 0 ; x < r; x++)
		{
			sources.add(x*r);
			destinations.add(x*r + (c-1));
		}
		int minS = Integer.MAX_VALUE;
		for(Integer src:sources)
		{
			Object[] sol = new DijkstraShortestPath(weights).findShortestPath(src);
			for(Integer dst : destinations)
			{
				Integer k = (Integer)sol[dst];
				if(k != Integer.MAX_VALUE)
				{
					minS = Math.min(minS, k + matrix[dst / r][dst % r] );
				}
			}
		}
		System.out.println("P082 : " + minS);
		timer.stopTimer();
		System.out.println(timer);
	}

}
