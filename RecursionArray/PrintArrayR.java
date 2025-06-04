/*Print Array Recursively
You are given an array arr of n elements, you are required to print all the n elements in a single line.

Note: Print the elements using a Recursive approach and not using loops(for, while, etc).

Input Format
First line contains an integer n which is the number of elements.

Second line contains n space separated integers.

Output Format
Print all the n elements space-separated in a single line

Example 1
Input

4
1 2 3 4
Output

1 2 3 4 */


import java.util.*;


public class PrintArrayR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        PrintArray(arr, n);
    }

	public static void PrintArray(int[] arr, int n) {
      // Write your code here
      int i =0;
      print(arr,i,n);
      }

    public static void print(int[] arr,int i,int n)
    {
        if(i>=n) return;
        System.out.print(arr[i]+" ");
        print(arr,i+1,n);
    }
      
      

}