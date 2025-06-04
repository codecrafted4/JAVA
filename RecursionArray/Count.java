/*Count 1
Given a number N, your task is to find the number of occurrences of the digit 1 in the number. Do it recursively.

Input Format
The first line contains an integer N denoting the number.

Output Format
For each test case return a number, denoting the number of occurrences of the digit 1 in the given number.

Example 1
Input

21121
Output

3
Explanation

There are 3 occurrences of the digit 1 in the number. */


import java.util.*;

public class Count{
	static int count1(int n) {
        //Write code here
        if(n==0) return 0;
        int ans =0;
        if(n%10 == 1)
        {
            ans =1 ;
        }
        int x = count1(n/10);
        return x+ans;
        

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count1(n));
        sc.close();
    }

    
}

