/*Two Sum
You are given a non-decreasing array A of N integers. You are given another integer target.

You have to find two unique indices of the array such that the values at those indices have a sum equal to target.

Return the indices as a sorted integer array of size 2.

It is guaranteed that the test cases are made such that only one solution exists.

The array is 1-indexed.

Note Complete the given function. The input and output would be handled by the driver code.

Your solution must use only constant extra space.

Input Format
The first line contains a single integer N.

The second line contains N space-separated integers of array A.

The third line contains a single integer target.

Output Format
Print the answer in a new line.

Example 1
Input

4
1 2 3 4
6
Output

2 4 */
import java.util.*;
import java.lang.*;
import java.io.*;

class TwoSum {
    
    public static int[] twoSum(int[] A, int target) {
       // Your code here
       int n = A.length;
       int s=0;
       int e = n-1;
       while(s<e){
        int currsum = A[s]+A[e];
        if(currsum <target)s++;
        else if(currsum>target)e--;
        else return new int[] {s+1,e+1};
       }
       return new int[] {-1,-1};
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}
