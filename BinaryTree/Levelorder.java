/*TREE LEVEL ORDER TRAVERSAL
You are given the number of nodes present in the tree. You have to input the nodes and form a Binary Search Tree (BST). After forming the BST, print the Level Order traversal of the BST.

Input
Line 1 contains integer n denoting number of nodes.

Line 2 contains n spaced integers denoting node values.

Output
Print a single line of space separated integers denoting Level Order traversal of tree.

Constraints
1<=n<=500

-1000<=value of node<=1000

Sample Input
6

1 2 5 3 4 6
Sample Output
1 2 5 3 6 4
Explanation
The BST is like :-
     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4
We need to print the nodes level by level. We process each level from left to right.

Level Order Traversal: 1 -> 2 -> 5 -> 3 -> 6 -> 4.
Topics
Trees
Companies
Facebook
Adobe
Microsoft */

import java.util.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}


class BST{
    Node root = null;
    BST(){

    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Levelorder {

    public static List<Integer> levelOrderTraversal(Node root){
    //write your code here.
    if(root==null) return new ArrayList<>();
    Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    ArrayList<Integer> list = new ArrayList<>();

    while(!q.isEmpty())
    {
        int size = q.size();
        for(int i =0;i<size;i++)
        {
            Node curr = q.poll();
            list.add(curr.val);
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);

        }
    }
    return list;


        
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }

       List<Integer> list = levelOrderTraversal(t.root);   

       for(int val : list){
        System.out.print(val+ " ");
       }    

    }
}
