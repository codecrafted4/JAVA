/*String Permutations
You are given a string str.

Complete the body of permutationPrint function - without changing signature - to calculate and print all permutations of str. Print the unique permutations in lexicographic order.

Use sample input and output to take idea about permutations.

Note

The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
The first line of input contains a string str.

Output Format
Print all the permutations of the given string.

Example 1
Input

abc
Output

abc
acb
bac
bca
cab
cba
Explanation

The given string abc has 6 permutations, abc,acb,bac,bca,cab,cba.*/
package Recursion_String_2DArray;
import java.util.*;
class Accio {
    
    public void printPermutations(String str) {
        // write your code heharre
        char strChar[] = str.toCharArray();
        Arrays.sort(strChar);
        String sortedStr = new String(strChar);
        Set<String> ans = new TreeSet<>();
        helper(sortedStr,"",ans);
        for(String s : ans)
        {
            System.out.println(s);
        }

    }
    public void helper(String str,String perm, Set<String> ans)
    {
        if(str.length()==0)
        {
            ans.add(perm);
            return;
        }

        for(int i =0;i<str.length();i++)
        {
            char c = str.charAt(i);
            String rem = str.substring(0,i)+str.substring(i+1);
            helper(rem,perm+c,ans);
        }
    }
}

public class StringPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Accio Obj = new Accio();
        Obj.printPermutations(str);
    }
}

