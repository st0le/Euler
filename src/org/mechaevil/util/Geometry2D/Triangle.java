/**
 * 
 */
package org.mechaevil.util.Geometry2D;

/**
 * @author 332609
 *
 */
public class Triangle {
	Point2D p1,p2,p3;
	
	double a,b,c;
	public Triangle(double a,double b,double c)
	{
		this.a = Math.min(a,Math.min(b,c));
		this.c = Math.max(a,Math.max(b,c));
		this.b = a+b+c - this.a - this.b;
		if(this.a + this.b < this.c)
			throw new IllegalArgumentException("Triangle not possible.");
	}

	public Triangle(int x1,int y1,int x2,int y2,int x3,int y3)
	{
		p1 = new Point2D(x1,y1);
		p2 = new Point2D(x2,y2);
		p3 = new Point2D(x3,y3);
		this.a = p1.distance(p2);
		this.b = p2.distance(p3);
		this.c = p3.distance(p1);
	}
	
	public Triangle(Point2D p1,Point2D p2,Point2D p3)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.a = p1.distance(p2);
		this.b = p2.distance(p3);
		this.c = p3.distance(p1);
	}
	
	public double getArea()
	{
		if(p1 != null && p2 != null && p3 != null)
		{
			return Math.abs( (p1.getX() - p3.getX())*(p2.getY()-p1.getY()) - (p1.getX() - p2.getX())*(p3.getY() - p1.getY()))/2;
		}else
		{
			//Heron's Formulae
			double s = (a+b+c)/2;
			return Math.sqrt(s * (s-a) * (s-b) * (s-c));
		}
	}
	
	public double [] getSides()
	{
		return new double[]{a,b,c};
	}
	
	public boolean containsOrigin()
	{
		boolean side1 = p1.crossProduct(p2) > 0;
		boolean side2 = p2.crossProduct(p3) > 0;
		boolean side3 = p3.crossProduct(p1) > 0;
		return side1 == side2 && side2 == side3;
	}
	
	public boolean isRightAngled()
	{
		double min = Math.min(Math.min(a, b), c);
		double max = Math.max(Math.max(a, b), c);
		double mid = a+b+c - min - max;
		return max*max == (min*min + mid*mid); 
	}
	
	public static boolean isPythagorasTriplet(int a,int b,int c)
	{
		int min = Math.min(Math.min(a, b), c);
		int max = Math.max(Math.max(a, b), c);
		int mid = a+b+c - min - max;
		return max*max == (min*min + mid*mid);
	}
}
