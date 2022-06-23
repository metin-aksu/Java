/*
 Simple Symbols
Have the function SimpleSymbols(str) take the str parameter being passed and determine if it is an acceptable sequence by either returning the string true or false. The str parameter will be composed of + and = symbols with several characters between them (ie. ++d+===+c++==a) and for the string to be true each letter must be surrounded by a + symbol. So the string to the left would be false. The string will not be empty and will have at least one letter.

Examples
Input: "+d+=3=+s+"
Output: true
Input: "f++d+"
Output: false
 */

import java.util.regex.Pattern;
import java.util.regex.MatchResult;

class SimpleSymbols {
    static String simpleSymbols(String str){

        String[] mLetters = Pattern.compile("[a-z]").matcher(str).results()
                            .map(MatchResult::group).toArray(String[]::new);

        for (String letter : mLetters){
            if (str.indexOf("+" + letter + "+") < 0)
                return "false";
        }
        return "true";
    }

    static String simpleSymbols2(String str){
        char[] arr = str.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++ ){
            
            if (arr[i] >= 97 && arr[i] <= 122) {
                if (i == 0 || i + 1 == len) 
                    return "false";
                else if (arr[i-1] != '+' || arr[i+1] != '+')  
                    return "false";
            }
        }
        return "true";
    }
    public static void main(String[] args){

        String str1 = "+d+"; // true
        String str2 = "+d===+a+"; // false
        String str3 = "aaaa"; // false
        String str4 = "+z+z+z+"; // true
        String str5 = "+a="; // false
        String str6 = "2+a+a+"; // true
        String str7 = "+a++"; // true
        String str8 = "+z+z+==+a+"; // true
        String str9 = "==a+"; // false
        String str10 = "b"; // false

        System.out.println(simpleSymbols(str1));
        System.out.println(simpleSymbols(str2));
        System.out.println(simpleSymbols(str3));
        System.out.println(simpleSymbols(str4));
        System.out.println(simpleSymbols(str5));
        System.out.println(simpleSymbols(str6));
        System.out.println(simpleSymbols(str7));
        System.out.println(simpleSymbols(str8));
        System.out.println(simpleSymbols(str9));
        System.out.println(simpleSymbols(str10));
    }
}