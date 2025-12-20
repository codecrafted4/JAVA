/*Allocate Minimum Number Of Pages
You are given N number of books. Every ith book has A[i] number of pages.

You have to allocate contagious books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value.

Each book will be allocated to exactly one student. Each student has to be allocated at least one book

Input Format
First line contains a two integers N denoting number of books and M number of students

Second Line contains N integers where ith integer denotes number pages in ith book

Output Format
Print minimum value of maximum number of pages allocated to any one student

Example 1
Input

4 2
12 34 67 90
Output

113
Explanation

Allocation can be done in following ways: {12} and {34, 67, 90} Maximum Pages = 191

{12, 34} and {67, 90} Maximum Pages = 157 {12, 34, 67} and {90}  Maximum Pages =113

Therefore, the minimum of these cases is 113, which is selected as the output.

Constraints
1 <= N <= 100000

1 <= A[i] <= 1000000

1 <= M <= 100000 */
import java.lang.*;
import java.util.*;

class Solution {
    public long MinimumPages(int[] A, int B) {
        //Write your code here
        if(B > A.length) return -1;

        long sum = 0;
        for(int x: A) sum += x;
        long s = 0;
        long e = sum;
        long ans = -1;
        while(s<=e) {
            long mid = s + (e-s)/2;
            if(isPossible(A,mid,B)) {
                ans = mid;
                e = mid-1;
            }
            else s = mid+1;
        }

        return ans;
    }
      static boolean isPossible(int A[], long maxPages, int B) {
        int students = 1;
        long currPages = 0;

        for(int i=0;i<A.length;i++) {
            if(currPages+A[i]<=maxPages) {
                currPages += A[i];
            }
            else {
                students++;
                if(A[i]>maxPages || students > B) return false;
                currPages = A[i];
            }
        }

        return true;
    }
    
}

class AllocateMinimumPages {
    

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution(); 
        System.out.println(Obj.MinimumPages(A,B));
	}
}