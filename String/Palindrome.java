import java.io.*;
import java.util.*;

public class Palindrome {
	static int isPalindrome(String str)
      {
              //write code here
              int n= str.length();
              String s = "";
              for(int i=0;i<n;i++)
              {
                char c = str.charAt(i);
                if(c>='A' && c<='Z' )
                {
                    s = s + (char)(c+32);

                }
                else if(c>='a' && c<='z')
                {
                    s = s+c;
                }
                else 
                {
                    continue;
                }
              }
              int m = s.length();
              int flag = 0;
              for(int i=0;i<m/2;i++)
              {
                if(s.charAt(i)==s.charAt(m-i-1))
                {
                    flag = 1;
                    continue;
                }
                else{
                    flag =0;
                }
              }
              if(flag ==1 )
              return 1;
              else 
              return 0;
              
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int result = isPalindrome(str);
        System.out.println(result);        
    }
}