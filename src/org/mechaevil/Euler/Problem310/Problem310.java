package org.mechaevil.Euler.Problem310;

import java.util.Set;
import java.util.TreeSet;

import org.mechaevil.util.StopWatch;

public class Problem310 {

	public static void main(String[] args) throws Exception {
		// 		
		StopWatch timer = new StopWatch();
		timer.startTimer();
		// ... your Code here

		final int N = 100000;
		Set<Integer> nimSet = new TreeSet<Integer>();
		int[] nims = new int[N + 1];
		nims[0] = 0;
		for (int i = 1, j; i < nims.length; i++) {
			nimSet.clear();
			for (j = 1; j * j <= i; j++)
				nimSet.add(nims[i - j * j]);
			for (j = 0; nimSet.contains(j); j++);
			nims[i] = j;
		}

		long res = 0; 
		int[] count = new int[128]; 
		int[] countPairs = new int[128]; 
		for(int i = 0; i < nims.length; i++) 
		{ 
			count[nims[i]]++;   
			for(int j = 0; j < count.length; j++) 
				countPairs[j ^ nims[i]] += count[j]; // countPairs[t] contain count of pairs p1, p2 (p1 <= p2 for keeping order) where t = sourceArray[i] ^ sourceArray[j] 
			res += countPairs[nims[i]]; // a ^ b ^ c = 0 if a ^ b = c, we add count of pairs (p1, p2) where sourceArray[p1] ^ sourceArray[p2] = sourceArray[i]. it easy to see that we keep order(p1 <= p2 <= i) 
		}

		System.out.println("P310 : " + res); 
		timer.stopTimer();
		System.out.println(timer);

	}
}
