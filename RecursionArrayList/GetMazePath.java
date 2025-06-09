/*Get Maze Paths
You are given n and m representing the number of rows and columns in a maze. You are standing at the top-left corner and have to reach the bottom-right corner.

You can move in only two directions - 1-step horizontal (h) and 1-step vertical (v).

Return the list of all paths that can be used to move from top-left to bottom-right of the maze.

Note: Write the code recusrively. The purpose is to learn recursion and not just solve the problem.

Input Format
First line of input contains two integers n and m.

Output Format
Return the list of all paths that can be used to move from top-left to bottom-right of the maze.

Example 1
Input

3 3
Output

[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
Explanation

You can move to bottom-right in 6 ways.

For 1st way ->

(1,1) -> (1,2) -> (1,3) -> (2,3) -> (3,3)

 */


package RecursionArrayList;

import java.io.*;
import java.util.*;

public class GetMazePath{

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(paths);
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
       // your code here
       ArrayList<String> path = new ArrayList<>();
       helper(sr,sc,dr,dc,path,"");
       return path;

    }
    static void helper(int i, int j,int n, int m, ArrayList<String> path,String s)
    {
        if(i<0 || j<0)
        {
            return;
        }
        if(i>n || j>m)
        {
            return;
        }
        if(i==n && j==m)
        {
            path.add(s);
        }
       

        helper(i,j+1,n,m,path,s+'h');
        helper(i+1,j,n,m,path,s+'v');
        
    }
}
