/*
Array Addition

Have the function ArrayAddition(arr) take the array of numbers stored in arr and return the string true if any combination of numbers in the array (excluding the largest number) can be added up to equal the largest number in the array, otherwise return the string false. For example: if arr contains [4, 6, 23, 10, 1, 3] the output should return true because 4 + 6 + 10 + 3 = 23. The array will not be empty, will not contain all the same elements, and may contain negative numbers. 
*/

import java.util.*; 
import java.io.*;

public class ArrayAddition {

  public static boolean ArrayChallenge(int[] arr) {

    Arrays.sort(arr);
    int maxNumber = arr[arr.length-1];
    int sum = 0;

    for(int i = 0; i < arr.length-1; i++)
      sum += arr[i];

    if(sum == maxNumber)
      return true;
    if (sum < maxNumber)
      return false;

    if (sum > maxNumber) {

      for(int i = 0; i < arr.length-1; i++){
        if ((sum - arr[i]) == maxNumber)
          return true;     
      }
      return false;
    }
    return false;
  }

  public static void main (String[] args) {  
    Scanner s = new Scanner(System.in);
    System.out.print(ArrayChallenge(s.nextLine())); 
  }

}