/*
Run Length

Have the function RunLength(str) take the str parameter being passed and return a compressed version of the string using the Run-length encoding algorithm. This algorithm works by taking the occurrence of each repeating character and outputting that number along with a single character of the repeating sequence. For example: "wwwggopp" would return 3w2g1o2p. The string will not contain any numbers, punctuation, or symbols.
*/

import java.util.*;
import java.io.*;

class RunLength2 {

  public static String StringChallenge(String str) {
    char[] arr = str.toCharArray();
    int count = 1;
    String newStr = "";

    for (int i = 0; i < arr.length; i++){

      if ( i + 1 >= arr.length){
        newStr = newStr + count + arr[i];
      }

      else{

        if (arr[i] == arr[i+1]){
          count++;
        }
        else{
          newStr = newStr + count + arr[i];
          count = 1;
        }

      }

    }

    return newStr;
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine()));
  }