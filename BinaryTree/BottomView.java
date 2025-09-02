/*Bottom view of Binary tree
Given root of the binary tree, print the bottom view from left to right.

Your task is to complete the function bottomView which receives the root as the parameter and returns the bottom view of the tree in an array.

Note : A node is included in bottom view if it can be seen when we look at the tree from bottom. If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.

Input Format
The first line contains the number of test cases.

For each test case you are given a pointer to the root of the binary tree and each binary tree is formed from the level order traversal of the given input numbers..

Output Format
For each test case print the bottom view.

Example 1
Input

1
1 3 2
Output

3 1 2
Explanation

      1
    /   \
   3     2
First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.

Example 2
Input

1
20 8 22 5 3 4 25 N N 10 N N 14
Output

5 10 4 14 25.
Explanation

            20
          /    \
        8       22
      /   \     /   \
    5      3 4     25
          /    \      
        10       14 
In the tree given, 3 and 4 are both the bottom most nodes at horizontal distance 0, we need to print 4. Output should be 5 10 4 14 25

Constraints
1 <= T <= 10

1 <= N <= 10000

Topics
Linked lists
Queues
Trees
Companies
PayTM
Amazon
Flipkart
Walmart Global Tech
Accolite */

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class BottomView {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
			String s = br.readLine();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans = tree.bottomView(root);

            for(Integer num:ans)
            System.out.print(num+" ");

            System.out.println();
		}
	}
}
  
class Pair{
    Node node;
    int y;
    public Pair(Node node ,int y)
    {
        this.node = node;
        this.y = y;
    }
}

class Solution{
    public ArrayList <Integer> bottomView(Node root)

    {
        // Your code her
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        
        q.add(new Pair(root,0));
        mp.put(0,root.data);
        while(!q.isEmpty())
        {
            int sz = q.size();
            for(int i =0;i<sz;i++)
            {
                Pair p = q.poll();
                Node currNode = p.node;
                int y = p.y;
                mp.put(y,currNode.data);
                if(currNode.left!=null)
                {
                    q.add(new Pair(currNode.left,y-1));
                }
                if(currNode.right!=null)
                {
                    q.add(new Pair(currNode.right,y+1));
                }
            }
            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val: mp.values())
        {
            ans.add(val);
        }
        return ans;
    }
}
