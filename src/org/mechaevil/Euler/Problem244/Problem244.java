package org.mechaevil.Euler.Problem244;

import java.util.List;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Algorithms.SearchAlgorithms.BreadthFirstSearch;
import org.mechaevil.util.Algorithms.SearchAlgorithms.SearchAlgorithm;
import org.mechaevil.util.Algorithms.SearchAlgorithms.SearchNode;

public class Problem244 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
	
		StopWatch timer = new StopWatch();
		timer.startTimer();
		//... your Code here

		//SearchAlgorithm searchAlgo = new DepthFirstSearch(new SlidingPuzzleNode());
		SearchAlgorithm searchAlgo = new BreadthFirstSearch(new SlidingPuzzleNode());
		SearchNode node = searchAlgo.findFirstSolution();
		int shortPath = -1;
		int chkSumSum = 0;

		while(node != null)
		{
			List<SearchNode> solution = SearchAlgorithm.buildSolutionList(node);
			if(shortPath == - 1) shortPath = solution.size();
			if(solution.size() > shortPath) break;
			StringBuilder  sb = new StringBuilder();
			for(SearchNode sol : solution)
			{
				SlidingPuzzleNode spNode = (SlidingPuzzleNode) sol;
				sb.append(spNode.getMove());
			}
			String strSol = sb.toString().substring(1);
			chkSumSum += checksum(strSol) ;
			node = searchAlgo.findNextSolution();
		}
		//System.out.println(checksum("LULUR")); = 19761398 // verify checksum function
		System.out.println("P244: " + chkSumSum);

		timer.stopTimer();
		System.out.println(timer);
	}

	public static int checksum(String str)
	{
		long chksum = 0;
		for(char ch: str.toCharArray())	{
			chksum = ((chksum * 243) + ch) % 100000007; 
		}
		return (int) chksum;
	}

}


