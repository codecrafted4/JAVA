package String;

import java.util.*;

public class Toggle {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String str = sc.nextLine();
    toggleCase(n, str);
  }

  static void toggleCase(int n, String str) {
    // your code here
  
    for(int i =0;i<n;i++)
    {char c = str.charAt(i);
      if(c>='a' && c<='z')
      {
        System.out.print((char)(c-32));
      }
      else if(c>='A' && c <= 'Z')
      {
        System.out.print((char)(c+32));
      }
      else{
        System.out.print(c);;
      }
    }
    
  }

}
