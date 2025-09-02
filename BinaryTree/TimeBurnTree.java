/*Time to Burn Tree
You have been given a binary tree of 'N' unique nodes and a Start node from where the tree will start to burn. Given that the Start node will always exist in the tree, your task is to print the time (in minutes) that it will take to burn the whole tree.

It is given that it takes 1 minute for the fire to travel from the burning node to its adjacent node and burn down the adjacent node.

Input Format
First line consists of an integer n, the number of nodes in the binary tree

The next line contains n spaced integers, representing the level order traversal of the binary tree

The third line consists of an integer x, the starting node of burning

Output Format
Print the time (in seconds) that it takes to burn the entire tree from the starting node

Example 1
Input

7
1 2 3 null null 4 5
3
Output

2
Explanation

In the zeroth minute, Node 3 will start to burn.

After one minute, Nodes (1, 4, 5) that are adjacent to 3 will burn completely.

After two minutes, the only remaining Node 2 will be burnt and there will be no nodes remaining in the binary tree.

So, the whole tree will burn in 2 minutes.

Example 2
Input

7
3 1 2 5 6 null null
3
Output

2
Explanation

Same as above

Constraints
1 <= n <= 10^5

1 <= node of tree <= 10^5

Topics
BFS
DFS
Trees */

import java.util.*;

public class TimeBurnTree {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) arr[i] = sc.next();
    int k = sc.nextInt();
    sc.close();
    Node tree = levelOrderCreateTree(arr);
    System.out.println(timeToBurnTree(tree, k));
  }

  
  public static int timeToBurnTree(Node root, int start) {
     
    //   Write your code here
    Map<Node, Node> childtoparentNode = new HashMap<>();
    getchildparentmap(root,childtoparentNode);
    Node StartNode = findNode(root,start);

    Queue<Node> q = new ArrayDeque<>();
    int time =-1;
    Set<Node> vis = new HashSet<>();
    q.add(StartNode);
    while(!q.isEmpty())
    {
      int sz = q.size();
      for(int i=0;i<sz;i++)
      {
        Node curr = q.poll();
        vis.add(curr);
        if(curr.left!=null && !vis.contains(curr.left)) q.add(curr.left);
        if(curr.right!=null && !vis.contains(curr.right)) q.add(curr.right);
        if(childtoparentNode.containsKey(curr))
        {
            Node Parent = childtoparentNode.get(curr);
            if(!vis.contains(Parent))
            q.add(Parent);
        }
  
      }
      time++;
    }
    return time;



   
  }
  public static Node findNode(Node root, int start)
  {
    if(root == null) return null;
    if(root.data == start) return root;
    Node leftsub = findNode(root.left,start);
    if(leftsub!=null) return leftsub;
    Node rightsub = findNode(root.right,start);
    return rightsub;

  }
  public static void getchildparentmap(Node root, Map<Node, Node> childtoparentNode )
  {
    if(root == null) return;
    if(root.left!=null)childtoparentNode.put(root.left,root);
    if(root.right!=null)childtoparentNode.put(root.right,root);
    getchildparentmap(root.left,childtoparentNode);
    getchildparentmap(root.right,childtoparentNode);
  }

  static void createTree(Node node, int i, String[] arr) {
    if (node != null) {
      if (2 * i + 1 < arr.length) {
        if (arr[2 * i + 1].equals("null")) {
          node.left = null;
        } else {
          node.left = new Node(Integer.parseInt(arr[2 * i + 1]));
        }
        createTree(node.left, 2 * i + 1, arr);
      }
      if (2 * i + 2 < arr.length) {
        if (arr[2 * i + 2].equals("null")) {
          node.right = null;
        } else {
          node.right = new Node(Integer.parseInt((arr[2 * i + 2])));
        }
        createTree(node.right, 2 * i + 2, arr);
      }
    }
  }

  static Node levelOrderCreateTree(String[] arr) {
    if (arr.length == 0) return null;
    Node head = new Node(
      Integer.parseInt(arr[0])
    );
    createTree(head, 0, arr);
    return head;
  }
}

class Node {

  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }
}