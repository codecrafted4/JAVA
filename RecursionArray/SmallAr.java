/*
 * Smallest Number in an Array using Recursion
Given an array arr of length n, you have to find the minimum element present in the array using recursion.

Input Format
First line consists of an integer n, the number of elements in the array

Second line consists of n spaced inetegrs, representing the array arr.

Output Format
Return the minimum element of the array.

Example 1
Input

3
1 2 3
Output

1
 */

 import java.util.*;



public class SmallAr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(recforMin(arr, 0));
    }

	public static int recforMin(int[] arr, int idx) {
        //Write your code here
      
        if(idx>=arr.length)
        return Integer.MAX_VALUE;
        int x = recforMin(arr,idx+1);
        return Math.min(arr[idx],x);       
    }
}
