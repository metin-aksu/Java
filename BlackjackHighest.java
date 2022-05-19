/*
Blackjack Highest
Have the function BlackjackHighest(strArr) take the strArr parameter being passed which will be an array of numbers and letters representing blackjack cards. 
Numbers in the array will be written out. So for example strArr may be ["two","three","ace","king"]. The full list of possibilities
for strArr is: two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace. Your program should output below, above, or blackjack 
signifying if you have blackjack (numbers add up to 21) or not and the highest card in your hand in relation to whether or not you have blackjack. 
If the array contains an ace but your hand will go above 21, you must count the ace as a 1. You must always try and stay below the 21 mark. 
So using the array mentioned above, the output should be below king. The ace is counted as a 1 in this example because if it wasn't you would be above the 21 mark.

Another example would be if strArr was ["four","ten","king"], the output here should be "above king". If you have a tie between a ten and a face card in your hand, 
return the face card as the "highest card". If you have multiple face cards, the order of importance is jack, queen, king.

Examples
Input: new string[] {"four","ace","ten"}
Output: below ten
Input: new string[] {"ace","queen"}
Output: blackjack ace
*/

import java.util.*; 
import java.io.*;

class BlackjackHighest {

  public static String blackjackHighest(String[] strArr) {
    int[][] cards = new int[strArr.length][3]; 

    for (int i = 0; i < strArr.length; i++) {
      cards[i][0] = CardValue(strArr[i],0);
      cards[i][1] = CardValue(strArr[i],1);
      cards[i][2] = CardValue(strArr[i],2);
    }
    Arrays.sort(cards, (a, b) -> a[2] - b[2]);
    String maxCard = getCardName(cards[strArr.length-1][2]);
        
    int total = 0, minVal,maxVal;
    boolean useMin;

    for (int i = 0; i < strArr.length; i++) {
      minVal = cards[i][0];
      maxVal = cards[i][1];
      useMin = false;

      if (total + maxVal > 21) {
        total += minVal;
        useMin = true; 
      }
      else {
        total += maxVal;
      }
            
      if (useMin == true && (cards[i][0] != cards[i][1]))
        maxCard = getCardName(cards[strArr.length-2][2]);            
    } // for end        
        
    if (total == 21)
      return "blackjack " + maxCard;
    if (total > 21)
      return "above " + maxCard;
    if (total < 21)
      return "below " + maxCard;

    return "Undefined";
  }  
  // ===============================================================
  static int CardValue(String name, int index){
    name = name.toLowerCase();
    if (name == "two") return 2; 
    if (name == "three") return 3;  
    if (name == "four") return 4;  
    if (name == "five") return 5;  
    if (name == "six") return 6;  
    if (name == "seven") return 7;  
    if (name == "eight") return 8;  
    if (name == "nine") return 9;  
    if (name == "ten") return 10;

    if (name == "ace"){
      if (index == 0) return 1; 
      if (index == 1) return 11; 
      if (index == 2) return 14;
    }
    if (index == 0 || index == 1) return 10;

    if (index == 2){
      if (name == "jack") return 11;
      if (name == "queen") return 12;
      if (name == "king") return 13;
    }
    return 0; 
  }
  // ===============================================================    
  static String getCardName(int val) {
    	if (val == 2) return "two";
    	if (val == 3) return "three";
    	if (val == 4) return "four";
    	if (val == 5) return "five";
    	if (val == 6) return "six";
    	if (val == 7) return "seven";
    	if (val == 8) return "eight";
    	if (val == 9) return "nine";
    	if (val == 10) return "ten";
    	if (val == 11) return "jack";
    	if (val == 12) return "queen";
    	if (val == 13) return "king";
    	if (val == 14) return "ace";    	
    	return "empty";    	
  }
  // ===============================================================
  public static void main (String[] args) {   
    Scanner s = new Scanner(System.in);
    System.out.print(blackjackHighest(s.nextLine())); 
  }
}
    
 
