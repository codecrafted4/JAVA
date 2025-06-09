/*Count Maze Path
Given two integers N and M, representing the number of rows and columns in the maze respectively, find all the paths to go from the top left cell to the bottom right cell.

Only two moves are allowed 1-step horizontal to the right and 1-step vertically down.

Complete the body of the print countMazePath function - without changing the signature to print the count of all the possible paths from top left to bottom right of the matrix.

Note The online judge can't force you to write the function recursively but that is what the spirit of the question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

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

2 */
package Recursion_String_2DArray;
import java.io.*;
import java.util.*;

public class CountMazePath{
    static int countMazePath(int n, int m)
    {
        //Write your code here
        
        return helper(n,m,0,0);
        
    }
    static int helper(int n, int m, int i,int j){
        if(i>=n || j>=m || i>n || j>m)
        {
            return 0;
        }
        if(i==n-1 && j==m-1)
        {
             return 1;
        }
        int right = helper(n,m,i,j+1);
        int down = helper(n,m,i+1,j);
        return right+down ;
    }
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(countMazePath(n, m));

}
}


