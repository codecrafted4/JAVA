/*Last Occurence Index
You are given an array A of size N with possibly duplicate elements. Your task is to find the index of last occurence of an element T in the given array. Also, return -1 if the element is not present.

You have to complete lastIndex function which contains array A , integers T (target) and startIndex as inputs and returns the last index of occurence as integer output

Input Format
First line represents size of the array i.e. N

Second line represents n-spaced array elements of the array.

Third line represents element T for which we have to find the last index of occurence.

Output Format
Print the integer value i.e. last index of occurence of the element.

Example 1
Input

6
8 9 4 1 1 2
1
Output

4 */
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N; i++){
			A[i] = s.nextInt();
		}
		int T = s.nextInt();
		System.out.println(lastIndex(A, T, A.length));
	}

	static int lastIndex(int A[],int T,int startIndex)
	{
		//Write your code here
		
		if(startIndex <= 0) return -1;
		if(A[startIndex-1]==T) return startIndex-1;
		return(lastIndex(A,T,startIndex-1));
       
	}
	
}
