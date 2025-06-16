\/*Combination Sum 2
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C

where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

The solution set must not contain duplicate combinations.

Print Answer in sorted Manner.

Input format:
the first line contains integer n denoting number of elements in array

the second line denotes the array space separated

the third line denotes the target sum

Output format:
all combinations space separated and in sorted order

Example 1:
Input:

7
10 1 2 7 6 1 5
8
output:

1 1 6
1 2 5
1 7
2 6
Example 2:
Input:

5
2 5 2 1 2
5
output:

1 2 2
5 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class CombinationSum2 {
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int sum){
        
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    	Collections.sort(a);
        ArrayList<Integer> subset = new ArrayList<>();
		
		helper(a,0,ans,subset,sum);
		return ans;
		
    }
    public static void helper(ArrayList<Integer> arr,int idx,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> subset,int sum)
	{
		if(sum==0 && !ans.contains(subset))
		{
			ans.add(new ArrayList<>(subset));
			return;
		}
		if(sum<0 || idx>=arr.size())
		{
			return;
		}
		 
		subset.add(arr.get(idx));
		helper(arr,idx+1,ans,subset,sum-arr.get(idx));
		subset.remove(subset.size()-1);
		helper(arr,idx+1,ans,subset,sum);

	}
   
  
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    	int n = sc.nextInt();
			ArrayList<Integer> a=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				a.add(sc.nextInt());
			}
			int sum = sc.nextInt();

	    	ArrayList<ArrayList<Integer>> ans = combinationSum(a, sum);
			Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
				public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
					for(int i=0;i<Math.min(o1.size(),o2.size());i++)
					if(o1.get(i)!=o2.get(i))
					return o1.get(i).compareTo(o2.get(i));
					
					return o1.size()>o2.size()?1:0;
				}
				
			});
			for(ArrayList<Integer> A : ans)
			{
				for(Integer B : A)
				{
					System.out.print(B+" ");
				}
				System.out.println();
			}
		
	}
}
