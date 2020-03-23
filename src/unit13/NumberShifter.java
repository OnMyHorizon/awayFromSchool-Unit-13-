package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	private static int [] finalArray;
	public static int[] makeLucky7Array( int size)
	{
		finalArray = new int[size];
		int r = (int) (Math.random() * (11));
		for(int i = 0; i < size; i++){
			 r = (int) (Math.random() * (11));
			 finalArray[i] = r;
		}
		return finalArray;
	}
	public static String shiftEm(int[] array)
	{
		String arrayString = Arrays.toString(finalArray);
		boolean done = false;
		int Index = 0;
		int indexSwap = 0;
		for(int i = 0; i < array.length; i++){
			indexSwap = 0;
			Index = 0;
			done = false;
			if(array[i] == 7){
				Index = i;
				while(!done && indexSwap < array.length){
					if(array[indexSwap] !=  7){
						array[Index] = array[indexSwap];
						array[indexSwap] = 7;
						done = true;
					}
					indexSwap++;
				}
			}
		}
		arrayString += "\n" + Arrays.toString(finalArray);
		return arrayString;
	}
}