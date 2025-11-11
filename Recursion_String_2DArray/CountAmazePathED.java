/*Count aMaze paths for Every Direction
Given two integers N and M, representing the number of rows and columns in the maze respectively, find all the paths to go from the top left cell to the bottom right cell.

All moves are allowed, i.e. a valid path can consist of steps that are horizontal, vertical or diagonal in any direction, except no cell should be repeated twice in the same path.

Complete the body of the print aMazePaths function - without changing the signature - to print the list of all paths that can be used to move from top-left to bottom-right. String psf is initially empty. i and j are two variables with an initial value equal to 1.

Note The online judge can't force you to write the function recursively but that is what the spirit of the question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
The first line contains two integers value of N and M.

Output Format
Print total number of possible paths.

Example 1
Input

2 2
Output

5 */


package Recursion_String_2DArray;

import java.util.Scanner;

public class CountAmazePathED {
        static int countAllPath(int n, int m)
    {
        //Write your code here
        return helper(n,m,0,0);
    }
    static int helper(int n,int m, int i, int j)
    {
        if(i>=n || j>=m || i<0 || j<0)
        {
            return 0;
        }
        if(i==n-1 && j==m-1)
        {
            return 1;
        }
        int right = helper(n,m,i,j+1);
        int diagonal = helper(n,m,i+1,j+1);
        int down = helper(n,m,i+1,j);
        int rldr = helper(n,m,i+1,j-1);
        int drud = helper(n,m,i-1,j+1);
     
        return right+diagonal+down+rldr+drud;
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        System.out.println(countAllPath(n,m));
    }
    
}
