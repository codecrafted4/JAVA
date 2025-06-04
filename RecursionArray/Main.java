/*
 * Find Digit Sum
Given the number n, find out and return the sum of digits present in a number recursively.

Input Format
Input consists of single line which has the integer n.

Output Format
Return the sum of digits present in n.

Example 1
Input

1256
Output

14
 */

import java.util.*;

public class Main {
	static int sumOfDigi(int n) {
        //Write code here
       if(n==0)
       {
        return 0;
       }
       return (n%10)+sumOfDigi(n/10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int result = sumOfDigi(n);
        System.out.println(result);
        sc.close();
    }
}
