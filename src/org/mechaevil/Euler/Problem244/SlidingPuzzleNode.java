package org.mechaevil.Euler.Problem244;

import java.util.ArrayList;
import java.util.List;

import org.mechaevil.util.Algorithms.SearchAlgorithms.SearchNode;

public class SlidingPuzzleNode extends SearchNode{

	private final byte BLUE = 0;
	private final byte RED = 1;
	private final byte BLANK = 3;
	private final int ROWS = 4;
	private final int COLS = 4;
	private byte[][] tiles = new byte[ROWS][COLS];
	private String strBoard = "NA";
	private int bx,by;
	private char move;

	public SlidingPuzzleNode(){
		resetBoard();
		move = 'X';
		makeStringRepresentation();
	}
	public SlidingPuzzleNode(SlidingPuzzleNode parent,int sx,int sy,char ch){
		super(parent);
		copyBoard(parent);
		bx = sx;
		by = sy;
		move = ch;
		byte color = tiles[sx][sy];
		tiles[parent.bx][parent.by] = color;
		tiles[bx][by] = BLANK;
		makeStringRepresentation();
	}

	private void copyBoard(SlidingPuzzleNode parent) {
		for(int i = 0 ; i < ROWS; i++)
			for(int j = 0 ; j < COLS; j++)
				tiles[i][j] = parent.tiles[i][j];
	}
	private void resetBoard() {
		for(int i = 0 ; i < ROWS; i++)
			for(int j = 0 ; j < COLS; j++)
				tiles[i][j] = (j < COLS/2)? RED : BLUE;
		bx = by = 0;
		tiles[bx][by] = BLANK;
	}


	private void makeStringRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		for(int i = 0 ; i < ROWS; i++)
		{
			for(int j = 0 ; j < COLS; j++)
				sb.append((tiles[i][j] == BLANK)? '*':(tiles[i][j] == RED)? 'R': 'B').append(' ');
			sb.append('\n');
		}
		strBoard = sb.toString();
	}


	@Override
	public List<SearchNode> generateChildren() {
		ArrayList<SearchNode> children = new ArrayList<SearchNode>(4);
		if(bx + 1 < ROWS)
			children.add(new SlidingPuzzleNode(this,bx+1,by,'U'));
		if(bx - 1 >= 0)
			children.add(new SlidingPuzzleNode(this,bx-1,by,'D'));
		if(by + 1 < COLS)
			children.add(new SlidingPuzzleNode(this,bx,by+1,'L'));
		if(by - 1 >= 0)
			children.add(new SlidingPuzzleNode(this,bx,by - 1,'R'));
		return children;
	}

	@Override
	public int hashCode() {
		return strBoard.hashCode();
	}

	@Override
	public String toString() {
		return strBoard;
	}
	@Override
	public boolean isGoalNode(SearchNode... goals) {
		byte[][]goal = new byte[][]{ 
				{ BLANK, BLUE, RED, BLUE},
				{ BLUE, RED, BLUE, RED},
				{ RED, BLUE, RED, BLUE},
				{ BLUE, RED, BLUE, RED}
		};
		for(int i = 0 ; i < ROWS; i++)
			for(int j = 0 ; j < COLS; j++)
				if(tiles[i][j] != goal[i][j])
				return false;
		return true;
	}
	
	@Override
	public int compareTo(SearchNode other) {
		SlidingPuzzleNode node = (SlidingPuzzleNode) other;
		for(int i = 0 ; i < ROWS; i++)
			for(int j = 0 ; j < COLS; j++)
				if(tiles[i][j] != node.tiles[i][j])
				return tiles[i][j] - node.tiles[i][j];
		return 0;
	}

	public char getMove() {
		return move;
	}
	
}
