/*
LCS
Have the function LCS(strArr) take the strArr parameter being passed which will be an array of two strings containing only the characters {a,b,c} and have your program return the length of the longest common subsequence common to both strings. A common subsequence for two strings does not require each character to occupy consecutive positions within the original strings. For example: if strArr is ["abcabb","bacb"] then your program should return 3 because one longest common subsequence for these two strings is "bab" and there are also other 3-length subsequences such as "acb" and "bcb" but 3 is the longest common subsequence for these two strings.
Examples
Input: ["abc","cb"]
Output: 1
Input: ["bcacb","aacabb"]
Output: 3
 */

public class LCS {

    public static int LCS(String[] strArr) {
        String str1 = strArr[0];
        String str2 = strArr[1];
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {

        System.out.println("1) " + LCS(new String[]{"abc","cb"}) + " = 1");
        System.out.println("2) " + LCS(new String[]{"abcabb","bacb"}) + " = 3");
        System.out.println("3) " + LCS(new String[]{"bcacb","aacabb"}) + " = 3");
        System.out.println("4) " + LCS(new String[]{"aaac","caaa"}) + " = 3");
        System.out.println("5) " + LCS(new String[]{"cbac","cacbbc"}) + " = 3");
        System.out.println("6) " + LCS(new String[]{"caabbcab","bbabcc"}) + " = 4");
        System.out.println("7) " + LCS(new String[]{"b","a"}) + " = 0");
        System.out.println("8) " + LCS(new String[]{"a","aa"}) + " = 1");
        System.out.println("9) " + LCS(new String[]{"abcabcabc","bbcbbcaa"}) + " = 5");
        System.out.println("10) " + LCS(new String[]{"abccc","caabac"}) + " = 3");

    }
}
