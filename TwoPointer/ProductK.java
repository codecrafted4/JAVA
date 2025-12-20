/*Subarray Product Less Than K
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Input Format
First line contains an integer n.

Next line contains n spaced integers.

The last line contains k.

Output Format
Return the number of contiguous subarrays with product of all elements in the subarray is strictly less than k

Example 1
Input

4
10 5 2 5
100
Output

8
Explanation

The 8 subarrays that have product less than 100 are: [10], [5], [2], [5], [10, 5], [5, 2], [2, 5], [5, 2, 5]

Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Example 2
Input

3
1 2 3
0
Output

0 */
import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Write code here
        if(k==0) return 0;
        int n = nums.length;
        int l =0;
        int prod = 1;
        int r = l;
        int count = 0;
        while(r<n)
        {   
            prod = prod*nums[r];
           
            while(l<=r && prod>=k){
                prod = prod/nums[l];
                l++;

            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
}

public class ProductK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}
