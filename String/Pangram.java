package String;

import java.util.*;
import java.io.*;

public class Pangram {
     public  static void isPangram(String s)
      {
           // Your code here
           int n = s.length();
           int[] freq = new int[26];
           for(int i=0;i<n;i++)
           {
               char c = s.charAt(i);
               if(c>='a' && c<='z' || c>='A' && c<='Z')
               {
                    int index=0;
                    if(c>='a' && c<='z')
                    {
                         index = c-'a';
                    }
                    else
                    {
                         index = c-'A';
                    }
                    freq[index]++;
               }
           }
           for(int i =0;i<26;i++){
               if(freq[i]==0)
               {
                    System.out.println(" not pangram");
            
                    return;
               }
               
           }
            
           
           System.out.println("pangram");

    }
    public static void main(String args[]) {
   Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        isPangram(s);
        
    }
}
