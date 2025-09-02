/*Symmetric Tree
Given the root node of a tree. Your task is to check whether it's symmetric about the center or not.

You have to complete isSymmetrical function which consists of pointer to the root of binary tree as input and prints the string output as YES or NO

Input Format
You are given the pointer to the root of the binary tree.

Output Format
For each test case print "YES" if the tree is symmetric, else print "NO"

Example 1
Input

2 1 1
Output

YES
Explanation

We have same numbers on both the subtrees.

Example 2
Input

1 2 3
     
Output

NO
Explanation

We have different numbers on both the subtrees.

Constraints
1 <= n <= 10^5

The value of any node is less than 2^32

Topics
Recursion
Trees
Companies
Facebook
Amazon
Bloomberg
Adobe
Apple
Google
LinkedIn */
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void isSymmetrical(Node root) {
        //Write your code here and print output here
        if(root == null || isMirror(root.left,root.right)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
	static boolean isMirror(Node t1,Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if(t1==null || t2== null)return false;
        
        return (t1.data==t2.data) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}
class SymmetricTree {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        g.isSymmetrical(root1);
    }
}


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
