/**
 * 
 */
package org.mechaevil.Euler.Problem062;

import java.util.ArrayList;
import java.util.HashMap;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.zString;

/**
 * @author 332609
 *
 */
public class Problem062 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		HashMap<String,Integer> cubeCount = new HashMap<String,Integer>();
		HashMap<String,ArrayList<Long>> cubeTable = new HashMap<String,ArrayList<Long>>();
		long ans = 0;
		for(long n=0;;n++)
		{
			String sortedN3 = zString.sortString("" + (n *n *n));
			if(cubeCount.containsKey(sortedN3))
			{
				int k = cubeCount.get(sortedN3) + 1;
				cubeCount.put(sortedN3,k);
				cubeTable.get(sortedN3).add(n);
				if( k == 5)
				{
					long cube = cubeTable.get(sortedN3).get(0);
					ans = cube * cube * cube;
					break;
				}
			}else
			{
				cubeCount.put(sortedN3, 1);
				ArrayList<Long> temp = new ArrayList<Long>();
				temp.add(n);
				cubeTable.put(sortedN3,temp);
			}
		}
		System.out.println("P062 : " + ans);
		
		timer.stopTimer();
		System.out.println(timer);
	}

}
