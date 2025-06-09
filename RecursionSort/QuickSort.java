/*Implementing Quick Sort
Given an array A[] of size N, containing positive integers. You need to sort the elements of array using the Quick sort algorithm.

Input Format
The first line of input N is the size of array and the second line consists of N array elements separated by space.

Output Format
Print the sorted array in a new line.

Example 1
Input

5
4 1 3 9 7
Output

1 3 4 7 9 
Explanation

The array after perfoming Quick sort: 1 3 4 7 9. */



import java.util.*;
import java.io.*;


class Solution{
    static int partition(int arr[],int s,int e){
    int randomIdx = (int)(Math.random()*(e-s+1)) + s;
    swap(arr,randomIdx,e);
    int pivote = e;
    int left = s-1;
    for(int i = s;i<=e-1;i++)
    {
        if(arr[i]<arr[pivote]){
            left++;
            swap(arr,left,i);
        }
        
    }
    swap(arr,left+1,pivote);
    return left+1;
    }
static void swap(int arr[],int i,int j)
{
    int temp = arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
static void quickSorthelper(int arr[],int s,int e)
{
    if(s>=e)
    {
        return;
    }
    int p = partition(arr,s,e);
    quickSorthelper(arr,s,p-1);
    quickSorthelper(arr,p+1,e);
}


	static void quickSort(int[] arr){
        //Write code herei
        int s = 0;
        int e = arr.length-1;
        quickSorthelper(arr,s,e);
        
    }
}

public class QuickSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
		Obj.quickSort(arr);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        sc.close();
    }
}
