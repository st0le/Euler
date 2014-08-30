/**
 * 
 */
package org.mechaevil.Euler.Problem205;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.UtilityMethods;

/**
 * @author 332609
 *
 */
public class Problem205 {
	
	public static int[] peter = new int[37];
	
	public static void calcForPeter(int index,int s)
	{
		if(index == 9)
			peter[s]++;
		else
		{
			for(int die = 1; die <= 4; die++ )
			{
				calcForPeter(index+1, s+die);
			}
		}
	}
	
	public static int[] colin = new int[37];
	
	public static void calcForColin(int index,int s)
	{
		if(index == 6)
			colin[s]++;
		else
		{
			for(int die = 1; die <= 6; die++ )
			{
				calcForColin(index+1, s+die);
			}
		}
	}
	
	public static void main(String[] args) {
				
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here
		calcForPeter(0,0);
		calcForColin(0,0);
		
		long prolls = UtilityMethods.sumArray(peter);
		long crolls = UtilityMethods.sumArray(colin);
		double prob = 0.0f;
		for(int p = 4; p <= 36; p++)
			for(int c = 6; c <= 36; c++)
				if(p > c)
				{
					prob += (peter[p] * colin[c] / (double)(prolls * crolls)); 
					
				}
		System.out.println(String.format("P205 : %.7f",prob));

		timer.stopTimer();
		System.out.println(timer);

	}


}
