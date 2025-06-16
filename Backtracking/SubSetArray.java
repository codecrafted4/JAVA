/*Subsets of Array
Given an array 'A' with 'N' distinct positive integers.

Your task is to find all subsets of the given array.

Input Format
The first line contains an integer 'N' denoting the number of elements.

The second line contains 'N' space-separated integers denoting the elements of the array 'A'.

Output Format
For each test case return an array of arrays, denoting all possible subsets of the array in lexicographically sorted order.

Example 1
Input

3
10 15 20
Output


10 
10 15 
10 15 20 
10 20 
15
15 20 
20
Explanation

All possible subsets of the array have been printed.

Example 2
Input

2
1 2
Output


1
1 2
2 */
import java.util.*; 

class SubSetArray{

    public static void sort2DArrayList(ArrayList<ArrayList<Integer>> list) {
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> sublist1, ArrayList<Integer> sublist2) {
                // Compare values up to the minimum of their sizes
                int minLength = Math.min(sublist1.size(), sublist2.size());
                for (int i = 0; i < minLength; i++) {
                    int valueComparison = Integer.compare(sublist1.get(i), sublist2.get(i));
                    if (valueComparison != 0) {
                        return valueComparison;
                    }
                }

                // If values are the same, compare sizes
                return Integer.compare(sublist1.size(), sublist2.size());
            }
        });
    }
    
 
    
    public static ArrayList<ArrayList<Integer>> subsets(int[] arr, int n) {
        //Write your code here 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        helper(arr,0,ans,subset);
        return ans;
       
    }
    public static void helper(int[] arr, int i,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> subset)
    {   
        if(i>=arr.length)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(arr[i]);
        helper(arr,i+1,ans,subset);
        subset.remove(subset.size()-1);
        helper(arr,i+1,ans,subset);
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int []A=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            } 

            Arrays.sort(A); 
            ArrayList <ArrayList<Integer>> res = subsets(A,n); 
        
            sort2DArrayList(res); 

            for (int i = 0; i < res.size (); i++)
            {
                for (int j = 0; j < res.get(i).size (); j++)
                {
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.println();

            }
        }
    }
}
