/*
Permutation Step
HIDE QUESTION
Have the function PermutationStep(num) take the num parameter being passed and return the next number greater than num using the same digits. For example: if num is 123 return 132, if it's 12453 return 12534. If a number has no greater permutations, return -1 (ie. 999).
*/

import java.util.*; 
import java.io.*;

public class PermutationStep {

  public static int MathChallenge(int num) {
    char[] arr = String.valueOf(num).toCharArray();
    int len = arr.length, i;

    for (i = len - 1; i > 0; i--){
      if (arr[i] > arr[i-1]) break;
    }

    if (i == 0)
      return -1;
    else{
      int x = arr[i-1], min = i;

      for (int j = i + 1; j < len; j++){
        if (arr[j] > x && arr[j] < arr[min]) min = j;
      }
      swapNums(arr,i-1,min);
      Arrays.sort(arr,i, len);
    }
    return Integer.parseInt(String.valueOf(arr));
  }

  static void swapNums(char[] arr, int x, int y){
    char temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    //Scanner s = new Scanner(System.in);
    //System.out.print(MathChallenge(s.nextLine())); 
    System.out.print(MathChallenge(111211));
  }

}
