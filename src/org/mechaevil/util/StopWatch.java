/**
 * 
 */
package org.mechaevil.util;



/**
 * @author 332609
 *
 */
public class StopWatch {
	
	private long startTime,endTime;
	
	public StopWatch()
	{
		resetTimer();
	}
	
	public void resetTimer()
	{
		startTime = endTime = 0;
	}
	
	public void startTimer()
	{
		startTime = System.nanoTime();
	}
	
	public void stopTimer()
	{
		endTime = System.nanoTime();
	}
	
	public double getElapsedTimeInMillis()
	{
		return (endTime - startTime)/ 1000000.0;
	}
	
	public long getElapsedTimeInNano()
	{
		return endTime - startTime;
	}
	
	@Override
	public String toString() {
		return "Time Elapsed : " + getElapsedTimeInMillis() + " ms";
	}
}
