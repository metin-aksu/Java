/*
Even Pairs
Have the function EvenPairs(str) take the str parameter being passed and determine if a pair of adjacent even numbers exists anywhere in the string. If a pair exists, return the string true, otherwise return false. For example: if str is "f178svg3k19k46" then there are two even numbers at the end of the string, "46" so your program should return the string true. Another example: if str is "7r5gg812" then the pair is "812" (8 and 12) so your program should return the string true.

Examples
Input: "3gy41d216"
Output: true
Input: "f09r27i8e67"
Output: false
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EvenPairs {

  public static boolean EvenPairs(String str) {
    Pattern p = Pattern.compile("\\d+");
    Matcher nums = p.matcher(str);
    while(nums.find()) {
      int num = Integer.parseInt(nums.group());
      if (num > 9 && num % 2 == 0) {
        return true;
      }    
    }
    return false;
  }

  public static void main (String[] args) {    

    String str1 = "f178svg3k19k46"; // true
    String str2 = "7r5gg812"; // true
    String str3 = "3gy41d216"; //  true
    String str4 = "f09r27i8e67"; //  false
    String str5 = "1111"; // false
    String str6 = "5678dddd"; // true
    String str7 = "abc"; // false
    String str8 = "128fk9846mf78"; // true
    String str9 = "jfb735f9ph8152"; // true
    String str10 = "106a"; // true

    System.out.println(str1 + " => true = " + EvenPairs(str1));
    System.out.println(str2 + " => true = " + EvenPairs(str2));
    System.out.println(str3 + " => true = " + EvenPairs(str3));
    System.out.println(str4 + " => false = " + EvenPairs(str4));
    System.out.println(str5 + " => false = " + EvenPairs(str5));
    System.out.println(str6 + " => true = " + EvenPairs(str6));
    System.out.println(str7 + " => false = " + EvenPairs(str7));
    System.out.println(str8 + " => true = " + EvenPairs(str8));
    System.out.println(str9 + " => true = " + EvenPairs(str9));
    System.out.println(str10 + " => true = " + EvenPairs(str10));    
  }
}
