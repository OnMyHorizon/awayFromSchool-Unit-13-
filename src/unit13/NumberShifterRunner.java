package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifterRunner
{
	public static void main( String args[] ) throws IOException
	{
		System.out.println(NumberShifter.shiftEm(NumberShifter.makeLucky7Array(5)) +"\n");
		System.out.println(NumberShifter.shiftEm(NumberShifter.makeLucky7Array(10))+"\n");
		System.out.println(NumberShifter.shiftEm(NumberShifter.makeLucky7Array(30)) +"\n");
	}
}



