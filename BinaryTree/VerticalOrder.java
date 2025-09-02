/*Vertical Order Traversal of Binary Tree
You are given root of a binary tree, your task is to print the nodes in order obtained via vertical traversal of the tree.

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

Input Format
The first line contains the number of test cases.

For each test case: You are given a pointer to the root of the binary tree.

Output Format
Complete the function VerticalTraversal() which returns a 2D array containing nodes according the question.

Example 1
Input

1
1 2 3
Output

2
1
3
Explanation

The tree can be imagined as

  1
 / \
2   3
So according to vertical traversal, we have {{2}, {1}, {3}}

Example 2
Input

1
3 9 20 N N 15 7
Output

9
3 15
20
7
Explanation

The tree can be imagined as

  3
 / \
9  20
  /  \
 15   7
Constraints
1 <= number of testcases <= 10

1 <= number of nodes in the tree <= 1000

1 <= nodes.val <= 1000

Topics
Queues
BFS
DFS */
import java.io.*;
import java.lang.*;
import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class Pair{
    int y;
    int x;
    TreeNode node;
    Pair(TreeNode node, int y)
    {
        this.node = node;
        this.y = y;
        
    }
}

class Solution {

    List<List<Integer>> VerticalTraversal(TreeNode root) {
       Map<Integer,ArrayList<Integer>> ans = new TreeMap<>();

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                Pair p = q.poll();
                TreeNode currNode = p.node;
                int y = p.y;

                if(!ans.containsKey(y)) {
                    ans.put(y,new ArrayList<>());
                }
                ArrayList<Integer> currNodes = ans.get(y);
                currNodes.add(currNode.data);
                ans.put(y,currNodes);

                if(currNode.left!=null) {
                    q.add(new Pair(currNode.left,y-1));
                }

                if(currNode.right!=null) {
                    q.add(new Pair(currNode.right,y+1));
                }
            }
        }

        List<List<Integer>> vert = new ArrayList<>();
        for(int key: ans.keySet()) {
            vert.add(ans.get(key));
        }
        return vert;



   
    }
}

class VerticalOrder{

    static TreeNode buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.VerticalTraversal(root);
            for(int i = 0; i < ans.size(); i++) {
                for(int a : ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            //System.out.println();
            t--;
        }
    }
}
