/*
Letter Count

Have the function LetterCount(str) take the str parameter being passed and return the first word with the greatest number of repeated letters. For example: "Today, is the greatest day ever!" should return greatest because it has 2 e's (and 2 t's) and it comes before ever which also has 2 e's. If there are no words with repeating letters return -1. Words will be separated by spaces.
*/

import java.util.*;
import java.io.*;

class LetterCount {

  public static String SearchingChallenge(String str) {
    String[] words = str.split(" ");
    String returnWord = "-1";
    char[] letters;
    char letter;
    int countBiggest = 0, countLetter = 0;

    for (String word:words){

      letters = word.toCharArray();
      for (int i = 0; i < letters.length;i++){
        letter = letters[i];
        countLetter = 0;

        for(int a = 0; a < letters.length; a++){
          if (letter == letters[a]){
            countLetter++;
          }
        }

        if (countLetter > 1) {
          if (countLetter > countBiggest){
            returnWord = word;
            countBiggest = countLetter;
          }
        }

      }

    }

    return returnWord;
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(SearchingChallenge(s.nextLine()));
  }

}