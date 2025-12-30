

/*Find Geometric Triplets
Write a program to print all the triplets that form a geometric progression. All the elements of the array are in increasing order of their value.

Input Format
Input consists of two lines.

First line contains an integer N denoting size of array

Second line contains N integers denoting the array elements separated by single space

Output Format
Print all the triplets that form a geometric progression, each in a new line. Print each geometric triplet in lexicographic form i.e. if a set of triplet has a lesser value at the same position compared to some other triplet then it has to be printed before the latter one.

Example 1
Input

6
1 2 6 10 18 54
Output

2 6 18
6 18 54
Example 2
Input

8
2 8 10 15 16 30 32 64
Output

2 8 32
8 16 32
16 32 64
Constraints
1 <= arr.size() <= 10

Topics
Arrays
Math*/
import java.util.*;
public class GeometricTriplet {

    public static void findGeometricTriplets(int arr[], int n) {
        // Write code here
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if((arr[j]*arr[j])==(arr[i]*arr[k])){
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        findGeometricTriplets(arr, N);
        sc.close();
    }
}
