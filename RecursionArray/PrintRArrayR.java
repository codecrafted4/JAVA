/*Print Reverse Array Recursively
You are given an array arr of n elements, you are required to print all the n elements but in a reverse order, in a single line.

Note: Print the elements using a Recursive approach and not using loops(for, while, etc).

Input Format
First line contains an integer n which is the number of elements.

Second line contains n space separated integers.

Output Format
Print all the n elements but in reverse space-separated in a single line

Example 1
Input

4
1 2 3 4
Output

4 3 2 1 */

import java.util.*;


public class PrintRArrayR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        PrintReverseArray(arr, n);
    }

	public static void PrintReverseArray(int[] arr, int n) {
        //Write your code
        if(n<=0)
        {
            return;
        }
        System.out.print(arr[n-1]+" ");
        PrintReverseArray(arr,n-1);
    }
 }
