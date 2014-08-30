package org.mechaevil.util.Algorithms.SearchAlgorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

final public class BreadthFirstSearch extends SearchAlgorithm{

	final public static String ALGO_NAME = "Breadth First Search";

	private LinkedList<SearchNode> myQueue = new LinkedList<SearchNode>();
	private Set<Integer> closedList  = new HashSet<Integer>();

	public BreadthFirstSearch(SearchNode root) {
		super(root,ALGO_NAME);
	}

	@Override
	final public SearchNode findFirstSolution() {
		myQueue.clear();
		myQueue.add(getRootNode());
		closedList.clear();
		return findNextSolution();
	}

	@Override
	final public SearchNode findNextSolution() {
		while(!myQueue.isEmpty())
		{
			SearchNode node = myQueue.pop();
			closedList.add(node.hashCode());
			if(node.isGoalNode(getGoalNodes())) //found goal node! YAY! :)
				return node;
			else
			{
				//Get all children and add all non-discovered children to queue
				for(SearchNode child : node.generateChildren())
					if(!closedList.contains(child.hashCode()))
						myQueue.add(child);
			}
		}
		return null;
	}
}
