/*aMaze paths
Given two integers N and M, representing the number of rows and columns in the maze respectively, find all the paths to go from the top left cell to the bottom right cell.

Only two moves are allowed h (1-step horizontal to the right) and v (1-step vertically down).

Complete the body of the print aMazePaths function - without changing the signature - to print the list of all paths that can be used to move from top-left to bottom-right. String psf is initially empty. i and j are two variables with an initial value equal to 1.

Note The online judge can't force you to write the function recursively but that is what the spirit of the question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Make the horizontal call first, before the vertical recursive call.

Input Format
The first line contains the value of N.

The second line contains the value of M.

Output Format
Print all possible paths.

Example 1
Input

2
2
Output

hv
vh
Explanation

We first go right then down, which gives hv.

One other path is to go down then right which gives vh. */



package Recursion_String_2DArray;

import java.util.*;
import java.io.*;
public class AmazePath2 {
    public static void aMazePaths(int n, int m, String psf,int i,int j){
       //Write your code here
       
       if(i<0 || j<0 || i>n || j>m)
       {
          return;
      }
       if(i==n && j==m)
       {
        System.out.println(psf);
       }
       aMazePaths(n,m,psf+'h',i,j+1 );
        aMazePaths(n,m,psf+"v",i+1,j);
      }
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine;
        inputLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        inputLine = br.readLine().trim().split(" ");
        int m = Integer.parseInt(inputLine[0]);
        aMazePaths(n, m, "",1,1);
  }
}
