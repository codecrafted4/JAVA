/*Coin Permutations - 2
You are given n coins of various denominations. Along with that you are also given amount amt.

You are required to calculate and print the permutations of the n coins (same coin can be used again any number of times) using which the amount amt can be paid.

Note:

Print all the permutations following the order in which the coins are present.

Use the code snippet and follow the algorithm discussed in the question video. The judge can't force you, but the intention is to teach a concept. Play in the spirit of the question.

Input Format
First line contains the integer n

Second line contains n space separated integers representing various denominations

Third line contains an integer amt

Output Format
Print the various permutations in different lines, each element in a permutation should be space-separated.

Example 1
Input

3
2 3 5
7
Output

2 2 3
2 3 2
2 5
3 2 2
5 2
Example 2
Input

5
5 4 2 3 1
3
Output

2 1
3
1 2
1 1 1 */
import java.util.*;

class Solution {
    public static void coinChange2(int[] coins, int amt){
        //Write your code here
        int n = coins.length;
        helper(coins,0,"",amt);
    }
    public static void helper(int[] coins, int idx, String sub, int amt)
    {
        if(amt==0)
        {
            System.out.println(sub);
            return;
        }
        if(idx>=coins.length || amt<0)
        {
            return;
        }

        helper(coins,0,sub+coins[idx]+" ",amt-coins[idx]);
        

        helper(coins,idx+1,sub,amt);

    }
}

public class CoinsPermutation2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        Solution Obj = new Solution();
        Obj.coinChange2(coins, amt);
    }
}
