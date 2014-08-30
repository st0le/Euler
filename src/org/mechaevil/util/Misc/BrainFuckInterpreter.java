/**
 * 
 */
package org.mechaevil.util.Misc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 332609
 *
 */

public class BrainFuckInterpreter {
	final int MAX = 50; 
	byte[] strip = null;
	int ptr = 0;

	private class BrainFuckException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 5826974372355703853L;

		public BrainFuckException(String msg) {
			super(msg);	
		}
	};

	public BrainFuckInterpreter()
	{
		strip = new byte[MAX];
	}
	public BrainFuckInterpreter(int n)
	{
		strip = new byte[n];
	}
	public void resetInterpreter()
	{
		Arrays.fill(strip, (byte)0);
		ptr = 0;
	}
	
	public void printStrip()
	{
		System.out.println(Arrays.toString(strip));
	}

	public void runProgram(String programCode) throws BrainFuckException
	{
		Scanner scanner = new Scanner(System.in);
		ptr = 0;
		int pIndex = 0;
		do
		{
			switch(programCode.charAt(pIndex))
			{
			case '<':
				ptr--;
				pIndex++;
				break;
			case '>':
				ptr++;
				pIndex++;
				break;
			case '+':
				strip[ptr]++;
				pIndex++;
				break;
			case '-':
				strip[ptr]--;
				pIndex++;
				break;
			case '.':
				System.out.print((char)strip[ptr]);
				pIndex++;
				break;
			case ',':
				strip[ptr] = scanner.nextByte();
				pIndex++;
				break;
			case '[':
				
				if( strip [ptr] == 0) //jump past match ]
				{
					int c = 0;
					int index = pIndex + 1;
					do
					{
						if( programCode.charAt(index) == '[')
							c++;
						if( programCode.charAt(index) == ']')
						{
							if(c == 0) {
								pIndex = index + 1;
								break;
							}else
								c--;
						}
						if( index < 0 || index > programCode.length())
							throw new BrainFuckException("Syntax Error : Loop block not found!");
						index++;
					}while(true);
				}else
					pIndex++;
				break;
			case ']':
				//goto matching [
				int c = 0;
				int index = pIndex - 1;
				do
				{
					if( programCode.charAt(index) == ']')
						c++;
					if( programCode.charAt(index) == '[')
					{
						if(c == 0)
						{
							pIndex = index;
							break;
						}else
							c--;
					}
					if( index < 0 || index > programCode.length())
						throw new BrainFuckException("Syntax Error : Loop block not found!");
					index--;
				}while(true);
				break;
			case '\n':
			case '\r':
				pIndex++;
				break;
			case '#':
				pIndex = programCode.indexOf("\n", ptr) + 1;
			default:
				throw new BrainFuckException("Unknown Symbol error!"); 
			}
		}while(pIndex < programCode.length());
	}
}
