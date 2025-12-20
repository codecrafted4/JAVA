/*4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

NOTE: You just have to complete the given function.

Expected time Complexity: O(N^3)

Input Format
First line contains the size of the array n.

second line will contain n space separated integers.

third line contains the target

Output Format
Return all the required unique quadruplets.

Example 1
Input

6
1 0 -1 0 -2 2 
0
Output

-2 -1 1 2
-2 0 0 2
-1 0 0 1
Explanation

There are three unique required quadruplets. */
import java.util.*;

import Binary_Search.Solution;

import java.io.*;
class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
       // Write your code here
       Arrays.sort(nums);
       int n = nums.length;
       List<List<Integer>>  ans = new ArrayList<>();
       int s=0;
       for(int i=s;i<n-3;i++)
       {
         if(i>0 && nums[i]==nums[i-1])continue;
         
         for( int j = i+1;j<n-2;j++)
         {
            if(j>i+1 && nums[j]==nums[j-1])continue;
            int k =j+1;
            int e = n-1;
            while(k<e)
            {
                int curr_sum = nums[i]+nums[j]+nums[k]+nums[e];
                if(curr_sum<target)
                {
                    k++;
                }
                else if(curr_sum>target)e--;
                else{
                    List<Integer> quad = new ArrayList<>();
                    quad.add(nums[i]);
                    quad.add(nums[j]);
                    quad.add(nums[k]);
                    quad.add(nums[e]);
                    ans.add(quad);
                    while(k<e && nums[k]==nums[k+1])k++;
                    while(k<e && nums[e]==nums[e-1])e--;
                    k++;
                    e--;

                }
            }
         }
       }
       return ans; 

   }
}

public class Main
{
	    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);

      
        for(int i= 0; i<res.size(); i++){
           Collections.sort(res.get(i));
        }

     
        Collections.sort(res, new Comparator<List<Integer>>() {
               public int compare(List<Integer> frst, List<Integer> scnd) {
                    int i=0;
                    while(frst.get(i)==scnd.get(i)) i++;
                    return frst.get(i)-scnd.get(i);
                    }
                });

        for(int i=0; i<res.size(); i++){   
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            } 
            System.out.println("");
        }
        sc.close();
	}
}
