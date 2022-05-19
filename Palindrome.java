/*
QUESTION
Have the function PalindromeTwo(str) take the str parameter being passed and return the string true if the parameter is a palindrome, (the string is the same 
forward as it is backward) otherwise return the string false. The parameter entered may have punctuation and symbols but they should not affect whether the 
string is in fact a palindrome. For example: "Anne, I vote more cars race Rome-to-Vienna" should return true.
*/

import java.util.*;
import java.io.*;

class Palindrome {

  public static Boolean StringChallenge(String str) {

    String cleanStr = CleanString(str);
    StringBuffer rStr = new StringBuffer(cleanStr);
    String reverseStr = String.valueOf(rStr.reverse());

    if (cleanStr.equalsIgnoreCase(reverseStr))
      return true;
    return false;
  }

  static String CleanString(String str){
    String cleanStr="";
    str = str.replace(" ","").toLowerCase();
    char[] arr = str.toCharArray();

    for (char c : arr){
      int code = (int) c;
      if (code >= 97 && code <= 122)
        cleanStr += String.valueOf(c);
    }
    return cleanStr;
  }

  public static void main (String[] args) {
    Scanner str = new Scanner(System.in);
    System.out.print(StringChallenge(str.nextLine()));
  }

}
