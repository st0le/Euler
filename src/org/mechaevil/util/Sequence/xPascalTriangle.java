/**
 * 
 */
package org.mechaevil.util.Sequence;

/**
 * @author 332609
 * 
 */
public class xPascalTriangle {

	private long modValue;
	private int maxLimit;
	private long[][] table;

	public xPascalTriangle() {
		generateTriangle(1000);
	}
	public xPascalTriangle(int mLimit,int mValue)
	{
		generateTriangle(mLimit,mValue);
	}

	public xPascalTriangle(int mLimit) {
		generateTriangle(mLimit);
	}

	private void generateTriangle(int limit) {
		// 
		maxLimit = limit;
		table = new long[maxLimit+1][];
		table[0] = new long[1];
		table[0][0] = 1;
		for (int i = 1; i <= maxLimit; i++) {
			table[i] = new long[i + 1];
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0)
					table[i][j] = 1;
				else
					table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
			}
		}
	}
	
	private void generateTriangle(int limit,int modvalue) {
		// 
		modValue = modvalue;
		maxLimit = limit;
		table = new long[maxLimit+1][];
		table[0] = new long[1];
		table[0][0] = 1;
		for (int i = 1; i <= maxLimit; i++) {
			table[i] = new long[i + 1];
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0)
					table[i][j] = 1;
				else
					table[i][j] = (table[i - 1][j] + table[i - 1][j - 1]) % modValue;
			}
		}
	}
	
	public long getBinomialCoefficient(int n,int r)
	{
		return (n >=0 && r >=0 && n <= maxLimit && r <= n)?table[n][r]:0;
	}
	
	public void displayTriangle() {
		for (int i = 0; i <= maxLimit; i++) {
			for(int j = 0; j <= i; j++)
				System.out.print(table[i][j] + " ");
			System.out.println();
		}
	}
}
