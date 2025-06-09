/*Maze Problem
You are given two numbers n and m representing number of rows and columns in a maze.

You are standing in the top-left corner and have to reach the bottom-right corner.

In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).

Your task is to print the list of all paths that can be used to move from top-left to bottom-right.

Note

You need to write a recursive solution to the problem.

You only need to complete the given function. The function parameters consist of the starting row and column, destination row and column and an empty string.

Use example to take idea about output.

Input Format
The first line conatins an integer n.

The second line conatins an integer m.

Output Format
Print in a new line the list of all paths that can be used to move from top-left to bottom-right.

Example 1
Input

2
2
Output

h1v1
v1h1
d1 */

package Recursion_String_2DArray;
import java.io.*;
import java.util.*;

public class AmazePath1 {
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        //Write your code here
        if(sr<0 || sc<0 || sr>dr || sc>dc)
        {return;}
        if(sr==dr && sc == dc)
        {
            System.out.println(psf);
        }
        for(int steps =1;steps<=4;steps++)
        {
            printMazePaths(sr,sc+steps,dr,dc,psf+'h'+steps);
        }
        for(int steps =1;steps<=4;steps++)
        {
            printMazePaths(sr+steps,sc,dr,dc,psf+'v'+steps);
        }
        for(int steps =1;steps<=4;steps++)
        {
            printMazePaths(sr+steps,sc+steps,dr,dc,psf+'d'+steps);
        }
       
        

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }
}

