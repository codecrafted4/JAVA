package String;

import java.io.*;
import java.util.*;

public class Hey {

       static String hey(String str)
      {
           // Your code here
           int n = str.length();
            String s = ""; 
            int flag=0; 
           int count=0;
           for(int i =0;i<n;i++)
           {
            
            if(str.charAt(i)=='e')
            {
                flag = 1;
                count++;
                continue;
                
            }
            if(flag ==1)
            {
              for(int k=0;k<2*count;k++)
              {
                s = s+'e';

              }
              flag =0;
              
            }
            if(flag==0)
            {
                s = s+str.charAt(i);
            }
           }
           return s;
           
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        String result = hey(str);
        System.out.print(result);        
        System.out.println('\n');
    }
}
