/*Get Stair Paths
You are given a number n representing the number of stairs in a staircase. You are standing at the top of the floor. In one step you can jump 1 stair, 2 stairs, or 3 stairs.

Return the list of all paths that can be used to climb up the staircase. See examples for more clarity regarding output.

Note: Write the code recursively. The purpose is to learn recursion and not just solve the problem.

Input Format
First line of input contains a single integer n.

Output Format
Return the list of all paths that can be used to climb up the staircase.

Example 1
Input

3
Output

[111, 12, 21, 3] */

package RecursionArrayList;

import java.io.*;
import java.util.*;

public class StairPath{
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStairPaths(int n) {
        // your code here
        ArrayList<String> ans = new ArrayList<>();
        helper(n,ans,"");
        return ans;
    }
    static void helper(int n, ArrayList<String> ans,String path)
    {
        if(n<0)
        return;
        if(n==0)
        {
            ans.add(path);
        }

        helper(n-1,ans,path+"1");
        helper(n-2,ans,path+"2");
        helper(n-3,ans,path+"3");
    }
}


