package String;

import java.io.*;
import java.lang.*;
import java.util.*;

class CountWord {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    String p = sc.nextLine();
    while (t > 0) {
      String s = sc.nextLine();
      System.out.println(countWords(s));
      t--;
    }
  }

  public static int countWords(String s) {
    // your code here
    int n = s.length();
    StringTokenizer token = new StringTokenizer(s);
    int count = token.countTokens(); 
    return count;
    
  }
}
