package org.mechaevil.util.Algorithms.SearchAlgorithms.AStar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.mechaevil.util.Algorithms.SearchAlgorithms.SearchAlgorithm;
import org.mechaevil.util.Algorithms.SearchAlgorithms.SearchNode;

final public class AStarSearch extends SearchAlgorithm{

	private Map<Integer,AStarSearchNode> closedList;
	private PriorityQueue<AStarSearchNode> openList;

	final private Comparator<AStarSearchNode> fxComparator = new Comparator<AStarSearchNode>() {

		@Override
		public int compare(AStarSearchNode first, AStarSearchNode second) {
			return (first.getFx() <= second.getFx())? -1 : 1;
		}
	}; 

	public AStarSearch(SearchNode root, String name) {
		super(root, name);
	}

	public AStarSearch(SearchNode root,String name,SearchNode... goal) { 
		super(root,name,goal);
	}

	@Override
	final public SearchNode findFirstSolution() {
		openList = new PriorityQueue<AStarSearchNode>(100, fxComparator);
		closedList = new HashMap<Integer, AStarSearchNode>();
		openList.add((AStarSearchNode) getRootNode());
		return findNextSolution();
	}

	@Override
	final public SearchNode findNextSolution() {

		while(!openList.isEmpty())
		{
			AStarSearchNode node = openList.poll();
			closedList.put(node.hashCode(), node);

			if(node.isGoalNode(getGoalNodes())) //YAY!!
			{
				return node;
			}else
			{
				List<SearchNode> children = node.generateChildren();
				for(SearchNode child : children)
				{
					AStarSearchNode myChild = (AStarSearchNode) child;
					if(!closedList.containsKey(myChild.hashCode()))
					{
						openList.add(myChild);
					}
				}
			}
		}
		return null;
	}
}
