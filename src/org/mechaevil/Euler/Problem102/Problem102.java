/**
 * 
 */
package org.mechaevil.Euler.Problem102;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Geometry2D.Triangle;

/**
 * @author 332609
 *
 */
public class Problem102 implements Constants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		String [] triangles = tlines.split("\n");
		int c = 0;
		for(String t:triangles)
		{
			String[]cor  = t.split(",");
			Integer[] icor = new Integer[cor.length];
			for(int i = 0 ; i < cor.length; i++)
				icor[i] = Integer.parseInt(cor[i]);
			
			Triangle tr = new Triangle(icor[0],icor[1],icor[2],icor[3],icor[4],icor[5]);
			if(tr.containsOrigin())
				c++;
		}
		System.out.println("P102 : " + c);
		timer.stopTimer();
		System.out.println(timer);

	}

}
