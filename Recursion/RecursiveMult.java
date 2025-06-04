/* Question :- You are given two integers N and M. Calculate and return their multiplication using recursion.
You can only use subtraction and addition for your calculation. No other operators are allowed.
Note
Complete the given function. The input would be handled by the driver code. You only have to print the answer.

Input Format
The first line contains N.
The second line contains M.
Example 1
Input
10
13*/

import java.io.*;
import java.util.*;

public class RecursiveMult {
  public static int solve(int n,int m)
{
    if(m==0)
    {
      return 0;
    }
     return n+solve(n, m-1);
}
  public static void multiplyRecursively(int n, int m) {
    //Write code here and print output
  System.out.println(solve(n,m));
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    multiplyRecursively(n, m);
  }
}