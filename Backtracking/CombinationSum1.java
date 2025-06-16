/*Combination Sum
Given an array of distinct integers nums and a target integer target, return a list of all unique combinations of nums where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from nums an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

Input Format
Input is managed for you. (You are given an array nums and target target in the combinationSum() function).

Output Format
Output is managed for you. (You can return the possible valid combinations in any order. The combinations will be automatically printed in sorted order).

Example 1
Input

4 16
6 2 7 5
Output

2 2 2 2 2 2 2 2 
2 2 2 2 2 6 
2 2 2 5 5 
2 2 5 7 
2 2 6 6 
2 7 7 
5 5 6  */
import java.util.*;
class Solution {
    
    public List<List<Integer>> combinationSum(int[] nums, int target){
        //write your code here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(nums,0,ans,subset,target);
        return ans;
    } 
    public void helper(int nums[],int idx,List<List<Integer>> ans,List<Integer> subset,int target )
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(idx>=nums.length || target<0)
        {
            return;
        }
        
        subset.add(nums[idx]);
        helper(nums,idx,ans,subset,target-nums[idx]);
        subset.remove(subset.size()-1);
        helper(nums,idx+1,ans,subset,target);

    }

}
public class CombinationSum1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int []nums = new int[n];
        for(int i = 0 ; i < n ; ++i){
            nums[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum(nums,target);
        for(int i = 0 ; i < ans.size() ; ++i){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) -> {
                int m = Math.min(o1.size(), o2.size());
                for (int i = 0; i < m; i++) {
                    if (o1.get(i) == o2.get(i)){
                        continue;
                    }else{
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 1;
            });
        for (int i = 0; i < ans.size (); i++)
            {
                for (int j = 0; j < ans.get(i).size (); j++)
                {
                    System.out.print(ans.get(i).get(j)+" ");
                }
                System.out.println();

            }


    }
}
