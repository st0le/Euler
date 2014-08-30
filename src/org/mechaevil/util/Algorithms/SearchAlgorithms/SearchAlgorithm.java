package org.mechaevil.util.Algorithms.SearchAlgorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class SearchAlgorithm {

	final private SearchNode rootNode;
	final private SearchNode[] goalNode ;
	final private String algoName;

	public SearchAlgorithm(SearchNode root,String name) {
		algoName = name;
		rootNode = root;
		goalNode = null;
	}
	public SearchAlgorithm(SearchNode root,String name,SearchNode... goal) {
		algoName = name;
		rootNode = root;
		goalNode = goal;
	}

	final public String getAlgoName() {
		return algoName;
	}

	public SearchNode findNextSolution() // default implementation
	{
		return null;
	}

	final public SearchNode getRootNode() {
		return rootNode;
	}
	
	final public SearchNode[] getGoalNodes() {
		return goalNode;
	}

	public abstract SearchNode findFirstSolution();
	

	
	final public static List<SearchNode> buildSolutionList(SearchNode solution)
	{
		List<SearchNode> solutionList = new LinkedList<SearchNode>();
		while(solution != null)
		{
			solutionList.add(solution);
			solution = solution.getParent();
		}
		Collections.reverse(solutionList);
		return solutionList;
	}
}
