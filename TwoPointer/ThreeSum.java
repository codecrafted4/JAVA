/*3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0. Find all unique triplets in the array which gives the sum of zero.

Input Format
The first line of input contains an integer n denoting the number of elements in the array. The next line contains n space separated integers denoting the elements of the array.

Output Format
Return an array of unique arrays where each array contains three elements such that a + b + c = 0.

Example 1
Input

5
1 2 -2 0 -1
Output

[[1, 0, -1], [2, -2, 0]
Explanation

1 + 0 + -1 = 0 and 2 + -2 + 0 = 0

Example 2
Input

3
0 0 0
Output

[[0, 0, 0]] */

import java.io.*;
import java.util.*;



class ThreeSum {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        //Sort all lists inside the list first
        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }
        //Sort the list
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i) < l2.get(i)) return -1;
                    else if (l1.get(i) > l2.get(i)) return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int s = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =s;i<n-2;i++)
        {
            if(i>0 && nums[i-1]==nums[i])continue;
            int j = i+1;
            int e = n-1;
            while(j<e)
            {
                int sum = nums[i]+nums[j]+nums[e];
                if(sum<0)j++;
                else if(sum>0)e--;
                else{
                    List<Integer> Triplet = new ArrayList<>();
                    Triplet.add(nums[i]);
                    Triplet.add(nums[j]);
                    Triplet.add(nums[e]);
                    ans.add(Triplet);
                    while(j<e && nums[j]==nums[j+1])j++;
                    while(j<e && nums[e]==nums[e-1])e--;
                    j++;
                    e--;
               }
            
            }
            
        }
        return ans;
    }
}
