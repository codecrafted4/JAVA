package String;

import java.io.*;
import java.util.*;
public class CamelCase1 {
  
  public static void solution(String str) {
     String[] words = str.split("(?=[A-Z])");
        int n = words.length;
        for (int i=0;i<n;i++) {
            System.out.println(words[i]);
        }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    solution(str);
  }
}
