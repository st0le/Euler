package org.mechaevil.util.Algorithms.SearchAlgorithms.AStar;

import org.mechaevil.util.Algorithms.SearchAlgorithms.SearchNode;

public abstract class AStarSearchNode extends SearchNode{
	
	private int gx,hx;

	final public int getGx() {
		return gx;
	}
	final public int getHx() {
		return hx;
	}

	final public void setHx(int hx) {
		this.hx = hx;
	}

	final public int getFx() {
		return hx+gx;
	}
	
	public abstract void setGx(AStarSearchNode parent);
	@Override
	public abstract int compareTo(SearchNode other);
	
}
