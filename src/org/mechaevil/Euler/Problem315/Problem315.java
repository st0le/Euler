package org.mechaevil.Euler.Problem315;

import java.util.ArrayList;
import java.util.List;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

public class Problem315 {

	static int TOP = 1;
	static int MIDDLE = 1 << 1;
	static int BOTTOM = 1 << 2;
	static int TOPRIGHT = 1 << 3;
	static int BOTRIGHT = 1 << 4;
	static int TOPLEFT = 1 << 5;
	static int BOTLEFT = 1 << 6;

	static int[] sevenSegment = new int []{
		TOP | TOPLEFT | TOPRIGHT | BOTLEFT | BOTRIGHT | BOTTOM, //0
		TOPRIGHT | BOTRIGHT,//1
		TOP | TOPRIGHT | BOTLEFT | BOTTOM | MIDDLE,//2
		TOP | TOPRIGHT | BOTRIGHT | BOTTOM | MIDDLE,//3
		TOPLEFT | TOPRIGHT |  BOTRIGHT | MIDDLE,//4
		TOP | TOPLEFT |   BOTRIGHT | BOTTOM | MIDDLE,//5
		TOP | TOPLEFT | BOTLEFT | BOTRIGHT | BOTTOM | MIDDLE,//6
		TOP | TOPLEFT | TOPRIGHT |  BOTRIGHT  ,//7
		TOP | TOPLEFT | TOPRIGHT | BOTLEFT | BOTRIGHT | BOTTOM | MIDDLE,//8
		TOP | TOPLEFT | TOPRIGHT | BOTRIGHT | BOTTOM | MIDDLE,//9
	};

	static int[] sevenSegmentCount = new int []{
		6, //0
		2,//1
		5,//2
		5,//3
		4,//4
		5,//5
		6,//6
		4,//7
		7,//8
		6,//9
	};

	
	static int samsClock(int currentTime)
	{
		//int hold = currentTime;
		int tx = 0;
		int dr = 0;
		while(currentTime > 0)
		{
			dr += currentTime % 10;
			tx += sevenSegmentCount[currentTime % 10];
			currentTime /= 10;
		}
		//System.out.println(hold + " = " + tx); 
		return 2*tx + ((dr >= 10)? samsClock(dr) : 2*sevenSegmentCount[dr]);
	}
	
	static int txNeeded(List<Integer> cur,List<Integer> nxt)
	{
		
		int tx = 0;
		if(cur.size() == 0)
		{
			for(int i = 0; i < nxt.size(); i++)
				tx += sevenSegmentCount[nxt.get(i)];
		}else
		{
			for(int i = 0; i< nxt.size(); i++)
			{
				int change = (sevenSegment[cur.get(i)] ^ sevenSegment[nxt.get(i)]) & 0x7F;
				//System.out.println(cur.get(i) + " -> " + nxt.get(i) + " = "+ Integer.bitCount(change));
				tx += Integer.bitCount(change);
			}
			for(int i = nxt.size(); i < cur.size(); i++)
			{
				tx += sevenSegmentCount[cur.get(i)];
				//System.out.println(cur.get(i) + " -> BLANK = "+ sevenSegmentCount[cur.get(i)]);
			}
		}
		//System.out.println(cur + " ; " + nxt + " = " + tx);
		return tx;
	}


	static int maxsClock(int currentTime)
	{
		List<Integer> numbers = new ArrayList<Integer>(20);
		while(true)
		{
			numbers.add(currentTime);
			if(currentTime < 10) break; 
			currentTime = xMath.sumDigits(currentTime);
		}
		
		List<Integer> curList = new ArrayList<Integer>();
		List<Integer> nxtList = new ArrayList<Integer>();
		
		int cur;
		int tx = 0;
		for(int i = 0; i < numbers.size(); i++)
		{
			nxtList.clear();
			cur = numbers.get(i);
			while(cur > 0)
			{
				nxtList.add(cur % 10);
				cur /= 10;
			}
			tx += txNeeded(curList, nxtList);
			curList.clear();
			curList.addAll(nxtList);
		}
		return tx + sevenSegmentCount[numbers.get(numbers.size() - 1)];
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// ... your Code here

		long samsTotal = 0;
		long maxsTotal = 0;
		final int A = 10000000;
		final int B = 20000000;
		PrimeSieve sieve = new PrimeSieve(B);
		for(int num = A|1; num < B; num +=2)
		{
			if(sieve.isPrime(num))
			{
				samsTotal += samsClock(num);
				maxsTotal += maxsClock(num);
			}
		}
		System.out.println("Sams Total : " + samsTotal);
		System.out.println("Maxs Total : " + maxsTotal);
		System.out.println("P315 : " + (samsTotal - maxsTotal));
		
		timer.stopTimer();
		System.out.println(timer);
	}

}
