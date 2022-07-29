/*
Pattern Chaser
Have the function PatternChaser(str) take str which will be a string and return the longest pattern within the string. A pattern for this challenge will be defined as: if at least 2 or more adjacent characters within the string repeat at least twice. So for example "aabecaa" contains the pattern aa, on the other hand "abbbaac" doesn't contain any pattern. Your program should return yes/no pattern/null. So if str were "aabejiabkfabed" the output should be yes abe. If str were "123224" the output should return no null. The string may either contain all characters (a through z only), integers, or both. But the parameter will always be a string type. The maximum length for the string being passed in will be 20 characters. If a string for example is "aa2bbbaacbbb" the pattern is "bbb" and not "aa". You must always return the longest pattern possible.

Examples
Input: "da2kr32a2"
Output: yes a2
Input: "sskfssbbb9bbb"
Output: yes bbb
 */

public class PatternChaser {
    static String patternChaser(String str){
        String pattern = "", mResult = "";

        for(int i = 0; i < str.length()-3; i++){

            pattern = str.substring(i,i+1);

            for (int j = i+1; j < str.length()-2; j++){

                pattern += str.substring(j,j+1);

                if (str.indexOf(pattern,j+1) > 1){

                    if (pattern.length() > mResult.length() ) mResult = pattern;

                }
            }
        }

        return mResult.length() > 1 ? "yes " + mResult : "no null";
    }
    public static void main(String[] args){

        System.out.println("yes aa = " + patternChaser("aaaa"));// yes aa
        System.out.println("yes 12 = " + patternChaser("abcdef12kkk12"));// yes 12
        System.out.println("yes hhh = " + patternChaser("ahhhkskshhh6"));// yes hhh
        System.out.println("no null = " + patternChaser("yoop"));// no null
        System.out.println("yes 893 = " + patternChaser("458933896893"));// yes 893
        System.out.println("no null = " + patternChaser("nohere"));// no null
        System.out.println("yes aaaak = " + patternChaser("aaaakkdnrjsnur998aaaaks"));// yes aaaak
        System.out.println("yes et = " + patternChaser("lettetr"));// yes et
        System.out.println("yes att = " + patternChaser("patterngaloratt"));// yes att
        System.out.println("yes rokkl = " + patternChaser("urokklr9833rokklb"));// yes rokkl
    }
}
