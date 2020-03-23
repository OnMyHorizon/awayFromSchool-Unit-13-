package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		int mod = 1;
		int num = number;
		boolean done = false;
		while(num != 0)
        {
            num /= 10;
            ++count;
        }
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		int index = getNumDigits(number) -1;
		while (number > 0) {
			sorted[index] = number % 10;
			number /= 10;
			index--;
		}
		Arrays.sort(sorted);
		return sorted;
	}
}