/**
 * 
 */
package org.mechaevil.util.Geometry2D;

/**
 * @author 332609
 *
 */
public class Point2D {

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	private int x,y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public double distance(Point2D other)
	{
		int dx2 = (this.x - other.x) * (this.x - other.x);
		int dy2 = (this.y - other.y) * (this.y - other.y);
		return Math.sqrt(dx2 + dy2);
	}
	
	public int crossProduct(Point2D b)
	{
		return this.x * b.y - this.y * b.x; 
	}

	public int dotProduct(Point2D b)
	{
		return this.x * b.x + this.y * b.y;
	}
	
	public double slope(Point2D b) 
	{
		return (this.y - b.y)/(double)(this.x - b.x);
		
	}
	
} 


