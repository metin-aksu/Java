/*
 Palindrome
 
Have the function Palindrome(str) take the str parameter being passed and return the string true if the parameter is a palindrome, (the string is the same forward as it is backward) otherwise return the string false. For example: "racecar" is also "racecar" backwards. Punctuation and numbers will not be part of the string.
Examples
Input: "never odd or even"
Output: true
Input: "eye"
Output: true
 */

public class Palindrome {
    public static Boolean StringChallenge(String str) {

        str = str.replaceAll("[^a-zA-Z]","").toLowerCase();
        String str2 = new StringBuilder(str).reverse().toString();      
        return str.equals(str2); 
               
      }
    public static void main(String[] args) {

        String str1 = "racecar"; // true
        String str2 = "eye"; // true
        String str3 = "dont nod"; // true
        String str4 = "rats live on no evil star"; // true
        String str5 = "do geese see god"; // true
        String str6 = "never odd or even"; // true
        String str7 = "rotor plus three"; // false
        String str8 = "nun"; // true
        String str9 = "radars"; // false
        String str10 = "abcdef"; // false
        
        System.out.println(str1 + " : true : " + StringChallenge(str1));
        System.out.println(str2 + " : true : " + StringChallenge(str2));
        System.out.println(str3 + " : true : " + StringChallenge(str3));
        System.out.println(str4 + " : true : " + StringChallenge(str4));
        System.out.println(str5 + " : true : " + StringChallenge(str5));
        System.out.println(str6 + " : true : " + StringChallenge(str6));
        System.out.println(str7 + " : false : " + StringChallenge(str7));
        System.out.println(str8 + " : true : " + StringChallenge(str8));
        System.out.println(str9 + " : false : " + StringChallenge(str9));
        System.out.println(str10 + " : false : " + StringChallenge(str10));
    }
}