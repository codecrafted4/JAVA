
/*Rotate a Matrix by 90 Degree
You are given a n x n 2-D matrix representing an image, rotate the image by 90 degrees (clockwise).

Input Format
The first line will contain two integers n and n again.

The next n lines contain n integers each representing the matrix.

Output Format
Return a matrix that is rotated by 90 degrees in the clockwise direction.

Example 1
Input

2 2
1 2
2 3
Output

2 1
3 2
Explanation

We do a 90 degree clockwise rotation of the matrix.

Example 2
Input

3 3
7  2  3
2  3  4
5  6  1
Output

5 2 7
6 3 2
1 4 3
Explanation

We do a 90 degree clockwise rotation of the matrix.

Constraints
1 <= n <= 100

Inplace solution

Topics
2D-Arrays
Arrays
Companies
ServiceNow
Facebook
ByteDance
PayTM
Amazon
Bloomberg
Oracle
Adobe
Cisco
Quora
VMware
Apple
Databricks
Uber
Google
Microsoft
eBay
Nvidia*/


import java.io.*;
import java.util.*;

class Solution {
    public int[][] rotateBy90(int [][]mat) {
        // Your code here
        int n = mat[0].length;
        int m = mat.length;

        for(int i =0;i<n;i++){

            for(int j=0;j<m;j++){
                if(i<j){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i]= temp;
                }

            }

        }
        for(int i =0;i<n;i++){
            for( int j =0;j<m/2;j++){
                int temp =mat[i][j];
                mat[i][j] = mat[i][m-j-1];
                mat[i][m-j-1]= temp;
            }
        }
        return mat;
    }
}

public class RotateMatBy90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int [][]mat=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                mat[i][j]=sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        int[][] ans = Obj.rotateBy90(mat);
        for(int i=0; i<n; i++)
        {   for(int j=0; j<n; j++)
        {
            System.out.print(ans[i][j] + " ");
        } System.out.println("");
        }
        System.out.println('\n');
    }
}
