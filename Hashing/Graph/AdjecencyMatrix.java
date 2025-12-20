import java.util.*;
import java.lang.*;
import java.io.*;

public class AdjecencyMatrix{
 
    public static void addEdge(int[][] adjmatrix,int i,int j,boolean IsBidir){
		adjmatrix[i][j]=1;
		if(IsBidir)
		{
			adjmatrix[j][i]=1;
		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		int v = 5;
	    
		int[][] adjmatrix = new int[v+1][v+1];
        addEdge(adjmatrix,1,2,true);
		addEdge(adjmatrix,1,4,true);
		addEdge(adjmatrix,2,5,true);
		addEdge(adjmatrix,2,3,true);

		for(int i =0;i<=v;i++)
		{
			System.out.print(i+"->");
			for(int j=0;j<=v;j++)
			{
				if(adjmatrix[i][j]==1)
				{
					System.out.print(j +",");
				}
			}
			System.out.println();
		}


	}
}