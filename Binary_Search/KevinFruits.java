/*Kevin And His Fruits
Kevin has N buckets each consisting of some fruits. Kevin wants to eat at least M fruits and so, he decided to set a marker (integer) as maximum as possible such that if he eats number of fruits in the i-th bucket - marker fruits then it must be at least M.

Note Each bucket may not have the same amount of fruits. It is guaranteed that the sum of all fruits (including all the buckets) will be greater than M. Kevin can only eat fruits from a particular bucket if and only if the bucket has more fruits than the marker.

Input Format
The first line will contain two space-separated integers N and M where N is the total number of buckets, and M is the minimum number of fruits that Kevin wants to eat.

The second line will contain N space-separated integers which denote the number of fruits in the i-th bucket.

Output Format
Print the maximum possible value of the marker.

Example 1
Input

4 30
10 40 30 20
Output

20
Explanation

If we set the marker at 20 then Kevin can eat following fruits from each bucket: 0 (1st bucket) + 20 (2nd bucket) + 10 (3rd bucket) + 0 (4th bucket) = 30 (K). */

import java.util.*;

public class KevinFruits {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            arr.add(sc.nextInt());
        }
        int ans = Solution.getMaxMarker(arr, n, m);
        System.out.println(ans);
    }
}
class Solution 
{
    static int getMaxMarker(ArrayList<Integer> arr, int n, int m) 
    {
         int sum =0;
         for(int x : arr) sum +=x;
         int s =0;
         int l = sum;
         int ans = -1;
         while(s<=l)
         {
            int mid= s+(l-s)/2;
            if(IsPossible(arr,n,mid,m))
            {
                
                ans = mid;
                s = mid+1;
            }
            else
            {
                l = mid-1;
            }
         }
         return ans;
    }
    static boolean IsPossible(ArrayList<Integer> arr, int n, int marker, int m)
    {
          int currsum = 0;

          for(int i =0;i<n;i++)
          { 
            if(arr.get(i)>=marker )
            {
                currsum += (arr.get(i)-marker);
            }
          }
          if(currsum>=m)
          {
            return true;
          }
          return false;
    }
}