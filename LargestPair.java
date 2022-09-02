/*
Largest Pair
Have the function LargestPair(num) take the num parameter being passed and determine the largest double digit number within the whole number. 
For example: if num is 4759472 then your program should return 94 because that is the largest double digit number. 
The input will always contain at least two positive digits.

Examples
Input: 453857
Output: 85
Input: 363223311
Output: 63
 */

public class LargestPair {

    public static int LargestPair(int num) {
        int largest = 0;
        String str = Integer.toString(num);
        for (int i = 0; i < str.length() - 1; i++) {
            int temp = Integer.parseInt(str.substring(i, i + 2));
            largest = Math.max(temp,largest);
        }
        return largest;
    }

    public static void main(String[] args) {

        System.out.println("1) " + LargestPair(4759472) + " = " +  94);
        System.out.println("2) " + LargestPair(453857) + " = " +  85);
        System.out.println("3) " + LargestPair(363223311) + " = " +  63);
        System.out.println("4) " + LargestPair(34) + " = " +  34);
        System.out.println("5) " + LargestPair(999) + " = " +  99);
        System.out.println("6) " + LargestPair(101010101) + " = " +  10);
        // System.out.println("7) " + LargestPair(5673536634) + " = " +  73);
        System.out.println("8) " + LargestPair(898989) + " = " +  98);
        System.out.println("9) " + LargestPair(91) + " = " +  91);
        System.out.println("10) " + LargestPair(1211111111) + " = " +  21);
    }

}