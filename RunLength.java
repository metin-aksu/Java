/*
Run Length
HIDE QUESTION
Have the function RunLength(str) take the str parameter being passed and return a compressed version of the string using the Run-length encoding algorithm. This algorithm works by taking the occurrence of each repeating character and outputting that number along with a single character of the repeating sequence. For example: "wwwggopp" would return 3w2g1o2p. The string will not contain any numbers, punctuation, or symbols.
*/

import java.util.*; 
import java.io.*;

class RunLength {

  public static String StringChallenge(String str) {

    String[] arrStr = str.split("");
    int arrLen = arrStr.length;
    String letter= arrStr[0], newStr="", item="";
    int count = 0;

    for (int i = 0; i <= arrLen; i++){
      if (i < arrLen) item = arrStr[i];

      if (letter.equals(item) && i < arrLen){ 
        count++;
      }
      else {
        newStr += count + letter;
        count = 1;
        letter = item;
      }            
    } 
    return newStr;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}