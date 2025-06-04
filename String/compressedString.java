import java.util.*;
import java.io.*;

public class compressedString {
	static void compressedString(String s) {
        
         // write your code here
         int n = s.length();
         int count =1;
         int flag =0;
         for(int i=1;i<n;i++)
         {
           
            if(s.charAt(i-1)==s.charAt(i))
            {
                flag =1;
                count++;
                continue;
                
            }
            else if(flag==1)
            {
               System.out.print(s.charAt(i-1)+ Integer.toString(count));
               flag =0;
               count=1;
            }
            else
            {
                System.out.print(s.charAt(i-1));
            }

         }
         if(flag == 1)
         {
            System.out.print(s.charAt(n-1)+Integer.toString(count));
         }
         if(s.charAt(n-2)!=s.charAt(n-1))
         {
         System.out.print(s.charAt(n-1));
         }
         
    }
        public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            compressedString(s);
            System.out.println();
        }
    }
}