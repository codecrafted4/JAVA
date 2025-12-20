package Binary_Search;
/*Capacity To Ship Packages Within B Days
A conveyor belt has packages that must be shipped from one port to another within B days.

The ith package on the conveyor belt has a weight of A[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Print the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within B days.

You have to complete solve function which contains array A and integer B days and you have to return integer answer which represents least weight capacity of ship

Input Format
The first line contains an integer n — the length of array A.

The second line contains n integers A1,A2,…,An — elements of array A.

The third line contains the integer B denoting the number of days.

Output Format
Print the least weight capacity of the ship.

Example 1
Input

 10
 1 2 3 4 5 6 7 8 9 10
 5
Output

15
Explanation

A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:

1st day: 1, 2, 3, 4, 5

2nd day: 6, 7

3rd day: 8

4th day: 9

5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
} */
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static long solve(int[] A, int B) {
        //Write your code here 
                long sum = 0;
        for(int x: A) sum += x;

        long s = 0;
        long e = sum;

        long ans = -1;
        while(s<=e) {
            long mid = s + (e-s)/2;
            if(isPossible(A,mid,B)) {
                ans = mid;
                //System.out.print(mid + " ");
                e = mid-1;
            }
            else s = mid+1;
        }
        return ans;       
    }
      static boolean isPossible(int A[], long weight, int B) {
        int day = 1;
        long currWeight = 0;

        for(int i=0;i<A.length;i++) {
            if(currWeight + A[i] <= weight) {
                currWeight += A[i];
            }
            else {
                day++;
                if(A[i]>weight) return false;
                currWeight = A[i];
            }
        }

//        if(day <= B) return true;
//        return false;
        return day<=B;
    }
}

class Shipping {
        public static void main (String[] args){
                Scanner sc = new Scanner(System.in);
        	int n = sc.nextInt();
        	int[] A = new int[n];
        	for(int i=0;i<n;i++){
                        A[i] = sc.nextInt();
		}
                int B = sc.nextInt();
                System.out.println(Solution.solve(A,B));
	}
}
