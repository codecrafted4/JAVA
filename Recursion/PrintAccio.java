import java.io.*;
import java.util.*;

class PrintAccio
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();

        solve(n);

    }

	public static void solve(int n)
    {
          // Your code here
          if(n==0)
          {
            return;
          }
          solve(n-1);
          System.out.println("ACCIOJOB");
    }
}
