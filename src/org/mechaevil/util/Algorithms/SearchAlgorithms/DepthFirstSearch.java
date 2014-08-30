package org.mechaevil.util.Algorithms.SearchAlgorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

final public class DepthFirstSearch extends SearchAlgorithm{

	final public static String ALGO_NAME = "Depth First Search";
	
	private LinkedList<SearchNode> myStack = new LinkedList<SearchNode>(); 
	private Set<Integer> closedList  = new HashSet<Integer>();
	
	public DepthFirstSearch(SearchNode root) {
		super(root,ALGO_NAME);
	}

	
	@Override
	final public SearchNode findFirstSolution() {
		myStack.clear();
		myStack.add(getRootNode());
		closedList.clear();
		return findNextSolution();
	}
	
	@Override
	final public SearchNode findNextSolution() {
		while(!myStack.isEmpty())
		{
			SearchNode node = myStack.removeLast();
			closedList.add(node.hashCode());
			System.out.println(node);
			if(node.isGoalNode(getGoalNodes()))//found goal, YAY! :)
				return node;
			else
			{
				//Get all children and add all non-discovered children to stack
				for(SearchNode child : node.generateChildren())
					if(!closedList.contains(child.hashCode()))
						myStack.add(child);
			}
		}
		return null;
	}
}
