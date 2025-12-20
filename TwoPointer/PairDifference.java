/*import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
        //Write code here
        if(k<0) return 0;
        Arrays.sort(nums);
        int i = 0;
        int j =1;
        int count =0;
        while(i<n && j<n)
        {
            if(i==j || nums[j]-nums[i]<k ) j++;
            else if(nums[j]-nums[i] >k)i++;
            else{
                count++;
                i++;
                j++;
                while(i<n && nums[i]==nums[i-1])i++;
                while(i<j && j<n && nums[j]==nums[j-1])j++;           }
        }
        return count;

    }
} */
import java.util.*;
class PairDifference{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
        //Write code here
        if(k<0) return 0;
        Arrays.sort(nums);
        int i = 0;
        int j =1;
        int count =0;
        while(i<n && j<n)
        {
            if(i==j || nums[j]-nums[i]<k ) j++;
            else if(nums[j]-nums[i] >k)i++;
            else{
                count++;
                i++;
                j++;
                while(i<n && nums[i]==nums[i-1])i++;
                while(i<j && j<n && nums[j]==nums[j-1])j++;           }
        }
        return count;

    }
}
