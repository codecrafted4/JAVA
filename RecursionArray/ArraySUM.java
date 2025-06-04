/*Sum of Array elements using recursion
Given an array of integers, find sum of array elements using recursion.

Input Format
Input consists of a 2 lines.

First line contains n.

Second line contains n spaced integers.

Output Format
Return the sum of array elements.

EXAMPLE 1
Input:

4
1 2 3 4
Output::

10 */
import java.util.*;

public class ArraySUM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(sumofArrayRec(arr, n));
    }

	public static int sumofArrayRec(int[] arr, int n) {
        // write code here
        if(n<=0)
        {
            return 0;
        }
        return arr[n-1]+sumofArrayRec(arr,n-1);
    }
}
