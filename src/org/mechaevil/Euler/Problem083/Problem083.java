/**
 * 
 */
package org.mechaevil.Euler.Problem083;

import java.util.Arrays;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.GraphTheory.DijkstraShortestPath;

/**
 * @author 332609
 *
 */
public class Problem083 implements Constants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		//Heapspace 256MB
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
				//back
				if( y-1 >= 0 )
				{
					_x = x ; _y = y - 1;
					weights[x*r+y][_x*r+_y] = matrix[x][y];
				}
			}
		}
		Object[] sol = new DijkstraShortestPath(weights).findShortestPath(0,(r*c-1));
		int cost = 0;
		for(Object o: sol)
		{
			Integer k = (Integer) o;
			cost += matrix[k / r][k % r];
			System.out.println(k + "," + cost);
		}
		System.out.println("P083 : " + cost);

		timer.stopTimer();
		System.out.println(timer);
	}

}
