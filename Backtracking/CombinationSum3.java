/*Combination Sum 3
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers `1` through `9` are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Input Format
Input is managed for you. (You are given k and n in the combinationSum3() function).

Output Format
Output is managed for you. (You can return the possible valid combinations in any order. The combinations will be automatically printed in sorted order).

Example 1
Input

3 8
Output

1 2 5 
1 3 4 
Explanation

Here all these combinations have sum equal to 8.

(1 2 5) 
(1 3 4)
Example 2
Input

4 10
Output

1 2 3 4 */

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //write your code here 

        int arr[] = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        helper(arr,0,ans,subset,n,k);
        return ans;
    }
    public void helper(int[] arr,int idx,List<List<Integer>> ans,ArrayList<Integer> subset,int n ,int k)
    {
        if(n==0 && k==0)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(idx>=arr.length || n<0 || k<0)
        {
            return;
        }
            
            subset.add(arr[idx]);

            helper(arr,idx+1,ans,subset,n-arr[idx],k-1);
            subset.remove(subset.size()-1);

            helper(arr,idx+1,ans,subset,n,k);
            
        
    }
    
}
public class CombinationSum3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum3(k,n);
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
