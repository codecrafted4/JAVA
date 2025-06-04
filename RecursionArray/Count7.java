/*Given a number N, your task is to find the number of occurrences of the digit 7 in the number.

Input Format
The first line contains an integer N denoting the number.

Output Format
For each test case return a number, denoting the number of occurrences of the digit 7 in the given number.

Example 1
Input

27727
Output

3 */
import java.util.*;

public class Count7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count7(n));
        sc.close();
    }

    public static int count7(int n) 
    {
        // your code here
        if(n==0)
        {return 0;}
        int count =0;
        if(n%10==7)
        {
            count = 1;
        }
        return count + count7(n/10);
       
       
    }
}
