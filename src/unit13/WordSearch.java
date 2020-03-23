package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;
    public WordSearch( int size, String str )
    {
    	m = new String[size][size];
    	int ind = 0;
    	for(int h = 0; h < size; h++)
    	{
    		for(int i = 0; i < size; i++)
    		{
    			m[h][i] = str.substring(ind,ind+1);
    			ind++;
    		}
    	}
    }

    public boolean isFound( String word )
    {
    	for(int r = 0; r < m.length; r++)
    		for(int c = 0; c < m[r].length; c++)
    			if( checkRight(word,r,c) || checkLeft(word,r,c) ||checkUp(word,r,c) ||
    				checkDown(word,r,c) || checkDiagUpRight(word,r,c) || checkDiagUpLeft(word,r,c) ||
    				checkDiagDownLeft(word,r,c) || checkDiagDownRight(word,r,c) )
    			{
    				return true;
    			}
  
    	return false;
    }

	public boolean checkRight(String w, int r, int c)
    {
		String checkerText="";
		for(int i = c; i < m[r].length; i++)
		{
			checkerText += m[r][i];
		}
		return checkerText.indexOf(w) != -1;
	}

	public boolean checkLeft(String w, int r, int c)
	{
		String checkerText= "";
		for(int i = c; i >= 0; i--)
		{
			checkerText += m[r][i];
		}
		return checkerText.indexOf(w) != -1;
	}

	public boolean checkUp(String w, int r, int c)
	{
		String checkerText= "";
		for(int i = r; i >= 0; i--)
		{
			checkerText += m[i][c];
		}
		return checkerText.indexOf(w) != -1;

	}

	public boolean checkDown(String w, int r, int c)
   {
		String checkerText= "";
		for(int i = r; i < m.length; i++)
		{
			checkerText += m[i][c];
		}
		return checkerText.indexOf(w) != -1;
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		String checkerText = "";
		for(int i = r; i >= Math.max(0,r - w.length()); i--)
		{
			checkerText += m[i][c];
			c++;
			if(checkerText.indexOf(w) != -1) return true;
			if(c >= m[i].length) return false;
		}
		return checkerText.indexOf(w) != -1;
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		String checkerText = "";
		for(int i = r; i >= Math.max(0,r - w.length()); i--)
		{
			checkerText += m[i][c];
			c--;
			if(checkerText.indexOf(w) != -1) return true;
			if(c < 0) return false;
		}
		return checkerText.indexOf(w) != -1;
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {
		String checkerText = "";
		for(int i = r; i < m.length; i++)
		{
			checkerText += m[i][c];
			c--;
			if(checkerText.indexOf(w) != -1) return true;
			if(c < 0) return false;
		}
		return checkerText.indexOf(w) != -1;
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		String checkerText = "";
		for(int i = r; i < m.length; i++)
		{
			checkerText += m[i][c];
			c++;
			if(checkerText.indexOf(w) != -1) return true;
			if(c >= m[i].length) return false;
		}
		return checkerText.indexOf(w) != -1;
	}

    public String toString()
    {
 		String output = "";
 		for (int i = 0; i <= m.length-1; i++) {
 			for (String n: m[i]) {
 				output += n + " ";
 			}
 			output += "\n";
 		}
 		return output;
    }
}
