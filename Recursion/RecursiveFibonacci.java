/*
 * Recursive Fibonacci
Given an integer N, find the Nth number in the fibonacci series. Consider 0 and 1 to be the seed values.

In a fibonacci series, each number ( Fibonacci number ) is the sum of the two preceding numbers. The series with 0 and 1 as seed values will go like -

0, 1, 1, 2, 3, 5.....

Input Format
First line contains the integer N

Output Format
Print the Nth fibonacci number

Example 1
Input

1
Output

0
 */
import java.util.*;
import static java.lang.Math.ceil;

public class RecursiveFibonacci {

	public static int fib(int n ){
        // write code here
        if(n==1)
        {
            return 0;
        }
        else if(n==2)
        {
            return 1;

        }
        int value = fib(n-2)+fib(n-1);
        return value;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }
}