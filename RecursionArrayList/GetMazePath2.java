/*Get Maze Paths
Given a grid with N rows and M columns, you must print all the possible paths from the top-left cell to the bottom-right cell.

However you can only make the following moves:

Move one cell to the right (denoted as h1)
Move two cells to the right (denoted as h2)
Move one cell down (denoted as v1)
Move two cells down (denoted as v2)
Move one cell diagonally down and right (denoted as d1)
Move two cells diagonally down and right (denoted as d2)
Return an ArrayList containing all the possible sequence of moves you can make to reach the bottom-right cell.

Note: The online judge can''t force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
The first line of input contains two space-separated integers N and M.

Output Format
Return the list of all possible paths from the top-left cell to the bottom-right cell. The driver code will print the paths in the required format.

Example 1
Input

3 3
Output

d1d1
d1h1v1
d1v1h1
d2
h1d1v1
h1h1v1v1
h1h1v2
h1v1d1
h1v1h1v1
h1v1v1h1
h1v2h1
h2v1v1
h2v2
v1d1h1
v1h1d1
v1h1h1v1
v1h1v1h1
v1h2v1
v1v1h1h1
v1v1h2
v2h1h1
v2h2
Explanation

h1h1v1v1 - Move one cell to the right, move one cell to the right, move one cell down, move one cell down. This will take you from (1,1) to (3,3).

h1h1v2 - Move one cell to the right, move one cell to the right, move two cells down. This will take you from (1,1) to (3,3).

Similarly, all the other paths will also take you from (1,1) to (3,3). */

package RecursionArrayList;
import java.io.*;
import java.util.*;

public class GetMazePath2{

    static void helper(int i, int j, int n, int m,ArrayList<String> ans, String path)
    {
        if(i>n || j>m) return;
        if(i==n && j==m)
        {
            ans.add(path);
            return;
        }
      
        for(int steps=1;steps<=2;steps++ )
        {
            helper(i,j+steps,n,m,ans,path+'h'+steps);
            

        }
         for(int steps=1;steps<=2;steps++ )
        {
            helper(i+steps,j,n,m,ans,path+'v'+steps);
            

        } for(int steps=1;steps<=2;steps++ )
        {
            helper(i+steps,j+steps,n,m,ans,path+'d'+steps);
            

        }

    }
    
    public static ArrayList<String> allPossiblePaths(int n, int m) {
        // write code here
        ArrayList<String> ans = new ArrayList<>();
        helper(1, 1, n,m,ans,"");
        return ans;
             
             
        }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> result = allPossiblePaths(n, m);
        Collections.sort(result);
        for (String str : result) {
            System.out.println(str);
        }

    }
}


