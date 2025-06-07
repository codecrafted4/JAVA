/*Implementing Merge Sort
Given an array A[] of size N, containing positive integers. You need to sort the elements of array using the merge sort algorithm.

Input
The input consists of two lines.

The first line of input is the size of array N and the second line consists of N array elements separated by space.

Output
Print the sorted array in a new line.

Example 1
Input

5
4 1 3 9 7
Output

1 3 4 7 9 
Explanation

The array after performing merge sort: 1 3 4 7 9. */


package RecursionSort;

import java.util.*;
import java.io.*;

class Solution {
static void merge(int arr[],int l,int mid,int r)
{
    ArrayList<Integer> A = new ArrayList<>();
    int i = l;
    int j = mid+1;
    while(i<=mid && j<=r)
    {
        if(arr[i]<=arr[j])
        {
            A.add(arr[i++]);
        }
        else
        {
            A.add(arr[j++]);
        }

    }
    while(i<=mid)
    {
        A.add(arr[i++]);
    }
    while(j<=r)
    {
        A.add(arr[j++]);
    }
    for(int k = l;k<=r;k++)
    {
        arr[k]=A.get(k-l);
    }
}

static void mergeSort(int[] arr,int l,int r){
     // Your code here
     if(l>=r) return;
     int mid = (l+r)/2;
     mergeSort(arr,l,mid);
     mergeSort(arr,mid+1,r);
     merge(arr,l,mid,r);

     
        }
}
public class MergeSort {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[n];
        for(int i= 0; i < n; i++)
            a[i] = input.nextInt();
        Solution Obj = new Solution();
        Obj.mergeSort(a,0,n-1);
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}
