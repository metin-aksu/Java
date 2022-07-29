/*
Palindrome Two

Have the function PalindromeTwo(str) take the str parameter being passed and return the string true if the parameter is a palindrome, (the string is the same forward as it is backward) otherwise return the string false. The parameter entered may have punctuation and symbols but they should not affect whether the string is in fact a palindrome. For example: "Anne, I vote more cars race Rome-to-Vienna" should return true.
Examples
Input: "Noel - sees Leon"
Output: true
Input: "A war at Tarawa!"
Output: true
 */

import java.util.*;

public class PalindromeTwo {

    static boolean palindromeTwo(String str) {
        str = str.replaceAll("[^a-zA-Z]","");
        String str2 = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(str2);
    }

    public static void main(String[] args) {
        System.out.println("1) true = " + palindromeTwo("racecar"));
        System.out.println("2) true = " + palindromeTwo("Never a foot too far - even"));
        System.out.println("3) true = " + palindromeTwo("Anne - I vote more cars race Rome-to-Vienna"));
        System.out.println("4) true = " + palindromeTwo("Too hot to hoot"));
        System.out.println("5) false = " + palindromeTwo("not a palindrome"));
        System.out.println("6) true = " + palindromeTwo("Nurse! I spy gypsies - run!"));
        System.out.println("7) true = " + palindromeTwo("No word~ no bond~ row on"));
        System.out.println("8) false = " + palindromeTwo("Sir{} I am not Iris!"));
        System.out.println("9) false = " + palindromeTwo("radars belong underwater"));
        System.out.println("10) true = " + palindromeTwo("A war at Tarawa!"));
    }

}
