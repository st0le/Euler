/**
 * 
 */
package org.mechaevil.Euler.Problem060;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.PrimeFactory.PrimeSieve;

/**
 * @author 332609
 *
 */
public class Problem060 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		StopWatch timer = new StopWatch();
		timer.startTimer();
		
		//... your Code here
		
		//Increase your heap Space upto 256MB (won't ork otherwise)
		// Clocked a Cool ~ 10secs on my machine.
		final int N = 10000;
		PrimeSieve table = new PrimeSieve(N * N);
		boolean [][] concatPrimes = new boolean[N][N];
		for(int i = 3; i< N; i+=2)
		{
			if(table.isPrime(i))
			{
				for(int j = i + 2; j < N; j += 2)
				{
					if( table.isPrime(j))
					{
						Integer one = Integer.parseInt(i + "" + j);
						if(table.isPrime(one))
						{
							Integer two = Integer.parseInt(j + "" + i);
							concatPrimes[i][j] = table.isPrime(two);
						}
					}
				}
			}
		}
		int a,b,c,d,e;
		int s = 0;
		int [] minSumArr= null;
		int minSum = Integer.MAX_VALUE;
		for(a = 3; a < N; a+= 2)
		{
			for(b = a + 2; b < N; b += 2)
			{
				if(concatPrimes[a][b])
				{
					for(c = b + 2; c < N; c += 2)
					{
						if(concatPrimes[b][c] && concatPrimes[a][c])
						{

							for(d = c + 2; d < N; d += 2)
							{
								if(concatPrimes[a][d] && concatPrimes[b][d] && concatPrimes[c][d])
								{

									for(e = d + 2; e < N; e += 2)
									{
										if(concatPrimes[a][e] && concatPrimes[b][e] && concatPrimes[c][e] && concatPrimes[d][e])
										{
											s = a + b + c + d + e;
											if( minSum > s) 
											{
												minSumArr = new int[] {a,b,c,d,e};
												minSum = s;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.print("P060 : " + minSum + " [" + minSumArr[0]);
		for(int i = 1;i < 5; i++)
			System.out.print("," + minSumArr[i]);
		System.out.println("]");
		timer.stopTimer();
		System.out.println(timer);
	}
}
