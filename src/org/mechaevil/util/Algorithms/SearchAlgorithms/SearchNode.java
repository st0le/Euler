package org.mechaevil.util.Algorithms.SearchAlgorithms;

import java.util.List;

public abstract class SearchNode implements Comparable<SearchNode> {
	private SearchNode parent = null;

	public SearchNode() {
		this(null);
	}

	public SearchNode(SearchNode parent) {
		this.parent = parent;
	}

	final public SearchNode getParent() {
		return parent;
	}

	final public void setParent(SearchNode parent) {
		this.parent = parent;
	}

	public abstract List<SearchNode> generateChildren();

	// default implementation, can be overriden
	public boolean isGoalNode(SearchNode... goals) {
		for (SearchNode goal : goals)
			if (compareTo(goal) == 0)
				return true;
		return false;
	}

	@Override
	public int compareTo(SearchNode other) {
		return 1; // never equal.
	}

	@Override
	public abstract int hashCode();

	@Override
	final public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}
}
